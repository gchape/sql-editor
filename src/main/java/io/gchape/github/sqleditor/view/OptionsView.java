package io.gchape.github.sqleditor.view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public enum OptionsView {
    INSTANCE();

    private final HBox root;

    OptionsView() {
        root = new HBox();

        build();
    }

    private void build() {
        root.getChildren().addAll(new Button("File"), new Button("Open"));
    }

    public Region getView() {
        return root;
    }
}
