package io.gchape.github.sqleditor.view;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

public enum SQLEditorView {
    INSTANCE();

    private final Color BLUEISH_GLOW = Color.rgb(220, 220, 255, 0.4);

    private final CodeArea codeArea;

    SQLEditorView() {
        codeArea = new CodeArea();
        codeArea.setLineHighlighterOn(true);
        codeArea.setLineHighlighterFill(BLUEISH_GLOW);
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
    }

    public Region getView() {
        return codeArea;
    }
}
