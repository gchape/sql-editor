package io.gchape.github.sqleditor.controller;

import io.gchape.github.sqleditor.view.AppView;
import javafx.scene.Scene;

public enum SceneCtrl {
    INSTANCE();

    private final AppView root;
    private final Scene scene;

    SceneCtrl() {
        root = AppView.INSTANCE;
        scene = new Scene(root.getView());
    }

    public final Scene getScene() {
        return scene;
    }
}
