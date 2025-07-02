package io.gchape.github.sqleditor.controller.scene;

import io.gchape.github.sqleditor.view.App;
import javafx.scene.Scene;

public enum SceneCtrl {
    INSTANCE();

    private final App root;
    private final Scene scene;

    SceneCtrl() {
        root = App.INSTANCE;
        scene = new Scene(root.getView());
    }

    public final Scene getScene() {
        return scene;
    }
}
