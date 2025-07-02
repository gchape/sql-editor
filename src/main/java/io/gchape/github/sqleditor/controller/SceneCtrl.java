package io.gchape.github.sqleditor.controller;

import io.gchape.github.sqleditor.view.Application;
import javafx.scene.Scene;

public enum SceneCtrl {
    INSTANCE();

    private final Application root;
    private final Scene scene;

    SceneCtrl() {
        root = Application.INSTANCE;
        scene = new Scene(root.getView());
    }

    public final Scene getScene() {
        return scene;
    }
}
