package io.gchape.github.sqleditor.controller;

import io.gchape.github.sqleditor.model.SharedModel;
import io.gchape.github.sqleditor.view.header.Navigation;
import javafx.scene.layout.Region;

public enum NavigationCtrl {
    INSTANCE(Navigation.INSTANCE);

    private final SharedModel sharedModel;
    private final Navigation navigation;

    NavigationCtrl(final Navigation navigation) {
        this.navigation = navigation;
        this.sharedModel = SharedModel.INSTANCE;

        bind();
    }

    private void bind() {
        sharedModel.openedDirPathProperty()
                .bind(navigation.openedDirPathProperty());
    }

    public Region getView() {
        return navigation.getView();
    }
}
