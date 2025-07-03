package io.gchape.github.sqleditor.view.editor;

import com.github.vertical_blank.sqlformatter.SqlFormatter;
import com.github.vertical_blank.sqlformatter.core.FormatConfig;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum SqlEditor {
    INSTANCE();

    public final static KeyCombination KEYCODE_FORMAT_COMBINATION =
            new KeyCodeCombination(KeyCode.L, KeyCombination.SHIFT_DOWN, KeyCombination.ALT_DOWN);

    public final static KeyCombination KEYCODE_SAVE_COMBINATION =
            new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);

    private final static FormatConfig FORMAT_CONFIG =
            FormatConfig.builder()
                    .indent("    ")
                    .uppercase(true)
                    .linesBetweenQueries(2)
                    .maxColumnLength(100)
                    .build();

    private final TextArea fringe;
    private final HBox root;
    private final TextArea codeArea;

    SqlEditor() {
        fringe = new TextArea();
        codeArea = new TextArea();
        root = new HBox(fringe, codeArea);

        configure();
        setHandlers();
    }

    private void setHandlers() {
        codeArea.textProperty()
                .subscribe(this::updateFringe);

        codeArea.addEventFilter(KeyEvent.KEY_PRESSED, this::save);
        codeArea.addEventFilter(KeyEvent.KEY_PRESSED, this::formatSql);

        fringe.scrollTopProperty()
                .bindBidirectional(codeArea.scrollTopProperty());
    }

    private void save(final KeyEvent e) {
        if (KEYCODE_SAVE_COMBINATION.match(e)) {
            e.consume();
        }
    }

    private void formatSql(final KeyEvent e) {
        if (KEYCODE_FORMAT_COMBINATION.match(e)) {
            e.consume();

            var formattedSql = SqlFormatter.format(codeArea.getText(), FORMAT_CONFIG);
            codeArea.setText(formattedSql);
        }
    }

    private void updateFringe() {
        final var text = codeArea.getText();
        if (text == null || text.isEmpty()) {
            fringe.setText("1");
            return;
        }

        var lines = text.split("\n", -1);
        var lineNumbers = IntStream
                .rangeClosed(1, lines.length)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        fringe.setText(lineNumbers);
    }

    private void configure() {
        HBox.setHgrow(fringe, Priority.NEVER);
        HBox.setHgrow(codeArea, Priority.ALWAYS);

        fringe.setMouseTransparent(true);
        fringe.setFocusTraversable(false);

        fringe.getStyleClass().add("fringe");
        codeArea.getStyleClass().add("code-area");
    }

    public Region getView() {
        return root;
    }
}