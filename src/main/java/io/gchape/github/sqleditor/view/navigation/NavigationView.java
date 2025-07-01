package io.gchape.github.sqleditor.view.navigation;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public enum NavigationView {
    INSTANCE();

    private final HBox root;

    NavigationView() {
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
