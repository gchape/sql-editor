package io.gchape.github.sqleditor.view.editor;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

public enum SqlEdView {
    INSTANCE();

    private final CodeArea codeArea;

    SqlEdView() {
        codeArea = new CodeArea();
        codeArea.setLineHighlighterOn(true);
        codeArea.setLineHighlighterFill(Color.rgb(220, 220, 255, 0.4));
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
    }

    public Region getView() {
        return codeArea;
    }
}
