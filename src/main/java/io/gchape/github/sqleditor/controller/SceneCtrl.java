package io.gchape.github.sqleditor.controller;

import io.gchape.github.sqleditor.view.ApplicationView;
import javafx.scene.Scene;

public enum SceneCtrl {
    INSTANCE();

    private final ApplicationView root;
    private final Scene scene;

    SceneCtrl() {
        root = ApplicationView.INSTANCE;
        scene = new Scene(root.getView());
    }

    public final Scene getScene() {
        return scene;
    }
}
