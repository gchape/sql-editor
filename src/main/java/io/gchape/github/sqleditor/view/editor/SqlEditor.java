package io.gchape.github.sqleditor.view.editor;

import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public enum SqlEditor {
    INSTANCE();

    private final TextArea fringe;
    private final HBox root;
    private final TextArea codeArea;

    SqlEditor() {
        root = new HBox();
        codeArea = new TextArea();
        fringe = new TextArea();

        configure();
        setHandlers();
        updateLineNumbers();
    }

    private void setHandlers() {
        codeArea.textProperty().subscribe(this::updateLineNumbers);
        fringe.scrollTopProperty().bindBidirectional(codeArea.scrollTopProperty());
    }

    private void updateLineNumbers() {
        String text = codeArea.getText();
        if (text == null || text.isEmpty()) {
            fringe.setText("1");
            return;
        }

        var lines = text.split("\n", -1);
        var lineCount = lines.length;
        var lineNumbers = new StringBuilder();
        for (int i = 1; i <= lineCount; i++) {
            lineNumbers.append(i);
            if (i < lineCount) {
                lineNumbers.append(System.lineSeparator());
            }
        }

        fringe.setText(lineNumbers.toString());
    }

    private void configure() {
        HBox.setHgrow(fringe, Priority.NEVER);
        HBox.setHgrow(codeArea, Priority.ALWAYS);

        fringe.getStyleClass().add("fringe");
        fringe.setEditable(false);
        fringe.setFocusTraversable(false);

        codeArea.getStyleClass().add("code-area");
        codeArea.setFocusTraversable(false);

        root.getChildren().addAll(fringe, codeArea);
    }

    public Region getView() {
        return root;
    }
}