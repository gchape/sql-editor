package io.gchape.github.sqleditor.controller;

import io.gchape.github.sqleditor.model.SharedModel;
import io.gchape.github.sqleditor.view.Toolbar;
import javafx.scene.layout.Region;

public enum ToolbarCtrl {
    INSTANCE(Toolbar.INSTANCE);

    private final SharedModel sharedModel;
    private final Toolbar toolbar;

    ToolbarCtrl(final Toolbar toolbar) {
        this.toolbar = toolbar;
        this.sharedModel = SharedModel.INSTANCE;

        bind();
    }

    private void bind() {
        sharedModel.openedDirPathProperty()
                .bind(toolbar.projectPathProperty());
    }

    public Region getView() {
        return toolbar.getView();
    }
}
