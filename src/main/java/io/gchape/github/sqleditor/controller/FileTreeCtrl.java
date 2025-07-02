package io.gchape.github.sqleditor.controller;

import io.gchape.github.sqleditor.model.SharedModel;
import io.gchape.github.sqleditor.view.hierarchy.FileTree;
import javafx.scene.layout.Region;

import java.nio.file.Path;

public enum FileTreeCtrl {
    INSTANCE(FileTree.INSTANCE);

    private final FileTree fileTreeView;
    private final SharedModel sharedModel;

    FileTreeCtrl(final FileTree fileTreeView) {
        this.fileTreeView = fileTreeView;
        this.sharedModel = SharedModel.INSTANCE;

        setHandlers();
    }

    private void setHandlers() {
        sharedModel.openedDirPathProperty().subscribe((absolutePath) -> {
            if (absolutePath != null) {
                var selectedPath = Path.of(absolutePath);

                fileTreeView.render(selectedPath);
            }
        });
    }

    public Region getView() {
        return fileTreeView.getView();
    }
}
