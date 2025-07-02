package io.gchape.github.sqleditor.view.editor;

import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import java.util.stream.IntStream;

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
    }

    private void setHandlers() {
        codeArea.textProperty().subscribe(this::updateFringe);
        fringe.scrollTopProperty().bindBidirectional(codeArea.scrollTopProperty());
    }

    private void updateFringe() {
        String text = codeArea.getText();
        if (text == null || text.isEmpty()) {
            fringe.setText("1");
            return;
        }

        var lines = text.split("\n", -1);
        var lineNumbers = new StringBuilder();

        IntStream.range(1, lines.length).forEachOrdered(i ->
                lineNumbers.append(i).append(System.lineSeparator()));
        lineNumbers.append(lines.length);

        fringe.setText(lineNumbers.toString());
    }

    private void configure() {
        HBox.setHgrow(fringe, Priority.NEVER);
        HBox.setHgrow(codeArea, Priority.ALWAYS);

        fringe.setEditable(false);
        codeArea.setFocusTraversable(false);
        fringe.setFocusTraversable(false);

        fringe.getStyleClass().add("fringe");
        codeArea.getStyleClass().add("code-area");

        root.getChildren().addAll(fringe, codeArea);
    }

    public Region getView() {
        return root;
    }
}