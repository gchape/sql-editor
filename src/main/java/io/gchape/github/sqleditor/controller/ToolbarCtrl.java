package io.gchape.github.sqleditor.controller;

import io.gchape.github.sqleditor.controller.handlers.ToolbarEventHandlers;
import io.gchape.github.sqleditor.model.SharedModel;
import io.gchape.github.sqleditor.view.Toolbar;
import io.gchape.github.sqleditor.view.editor.TabbedSqlEditor;
import io.gchape.github.sqleditor.view.utils.Icons;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import java.security.SecureRandom;
import java.util.Base64;

public enum ToolbarCtrl implements ToolbarEventHandlers {
    INSTANCE(Toolbar.INSTANCE);

    private final SecureRandom secureRandom;
    private final SharedModel sharedModel;
    private final Toolbar toolbar;

    ToolbarCtrl(final Toolbar toolbar) {
        this.toolbar = toolbar;
        this.sharedModel = SharedModel.INSTANCE;
        this.secureRandom = new SecureRandom();

        bind();
    }

    private void bind() {
        sharedModel.openedDirPathProperty()
                .bind(toolbar.projectPathProperty());

        sharedModel.setTabs(TabbedSqlEditor.INSTANCE.getTabs());
    }

    public Region getView() {
        return toolbar.getView();
    }

    @Override
    public void onRunQueryBtnClicked(final MouseEvent e) {
        // TODO
    }

    @Override
    public void onNewFileBtnClicked(final MouseEvent e) {
        Tab tab = new Tab();

        var bytes = new byte[6];
        secureRandom.nextBytes(bytes);
        var base64hash = Base64.getEncoder().encodeToString(bytes);

        tab.setText(base64hash);
        tab.setGraphic(Icons.newTabIcon1());
        SharedModel.INSTANCE.getTabs().add(tab);
    }
}
