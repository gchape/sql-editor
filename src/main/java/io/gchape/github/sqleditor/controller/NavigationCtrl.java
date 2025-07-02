package io.gchape.github.sqleditor.controller;

import io.gchape.github.sqleditor.model.SharedModel;
import io.gchape.github.sqleditor.view.header.Navigation;
import javafx.scene.layout.Region;

public enum NavigationCtrl {
    INSTANCE(Navigation.INSTANCE);

    private final SharedModel sharedModel;
    private final Navigation navigationView;

    NavigationCtrl(final Navigation navigationView) {
        this.navigationView = navigationView;
        this.sharedModel = SharedModel.INSTANCE;

        bind();
    }

    private void bind() {
        sharedModel.openedDirPathProperty()
                .bind(navigationView.openedDirPathProperty());
    }

    public Region getView() {
        return navigationView.getView();
    }
}
