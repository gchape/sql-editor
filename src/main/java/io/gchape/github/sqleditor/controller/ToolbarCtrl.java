package io.gchape.github.sqleditor.controller;

import io.gchape.github.sqleditor.model.SharedModel;
import io.gchape.github.sqleditor.view.Toolbar;
import io.gchape.github.sqleditor.view.editor.TabbedSqlEditor;
import io.gchape.github.sqleditor.view.utils.Icons;
import io.gchape.github.sqleditor.view.utils.Secure;
import javafx.scene.control.Tab;
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

        sharedModel.setTabs(TabbedSqlEditor.INSTANCE.getTabs());

        Toolbar.INSTANCE.onRunQueryMClickedProperty().set((e) -> {

        });

        Toolbar.INSTANCE.onNewFileMClickedProperty().set((e) -> {
            var tab = new Tab(Secure.base64hash(6));
            tab.setGraphic(Icons.newTabIcon1());

            SharedModel.INSTANCE.getTabs().add(tab);
        });
    }

    public Region getView() {
        return toolbar.getView();
    }
}
