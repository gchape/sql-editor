package io.gchape.github.sqleditor.view.editor;

import io.gchape.github.sqleditor.view.utils.SqlFormatter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

public enum SqlEditor {
    INSTANCE();

    public final static KeyCombination KEYCODE_FORMAT_COMBINATION =
            new KeyCodeCombination(KeyCode.L, KeyCombination.SHIFT_DOWN, KeyCombination.ALT_DOWN);

    public final static KeyCombination KEYCODE_SAVE_COMBINATION =
            new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);

    private final StringProperty searchText = new SimpleStringProperty("");

    private final HBox root;
    private final CodeArea codeArea;

    SqlEditor() {
        codeArea = new CodeArea();
        root = new HBox(codeArea);

        configure();
        bind();
    }

    private void bind() {
        codeArea.addEventFilter(KeyEvent.KEY_PRESSED, this::save);
        codeArea.addEventFilter(KeyEvent.KEY_PRESSED, this::formatSql);
    }

    private void save(final KeyEvent e) {
        if (KEYCODE_SAVE_COMBINATION.match(e)) {
            e.consume();
        }
    }

    private void formatSql(final KeyEvent e) {
        if (KEYCODE_FORMAT_COMBINATION.match(e)) {
            e.consume();

            var formattedSql = (String) SqlFormatter.DEFAULT.prettyPrint(codeArea.getText());
            codeArea.replaceText(formattedSql);
        }
    }

    private void configure() {
        HBox.setHgrow(codeArea, Priority.ALWAYS);

        codeArea.getStyleClass().add("code-area");
        codeArea.setLineHighlighterOn(true);
        codeArea.setLineHighlighterFill(Paint.valueOf("#262626"));
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
    }

    public Region getView() {
        return root;
    }

    public StringProperty searchTextProperty() {
        return searchText;
    }
}