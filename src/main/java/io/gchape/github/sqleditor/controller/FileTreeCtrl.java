package io.gchape.github.sqleditor.controller;

import io.gchape.github.sqleditor.model.SharedModel;
import io.gchape.github.sqleditor.view.ProjectTree;
import javafx.scene.layout.Region;

import java.nio.file.Path;

public enum FileTreeCtrl {
    INSTANCE(ProjectTree.INSTANCE);

    private final ProjectTree projectTree;
    private final SharedModel sharedModel;

    FileTreeCtrl(final ProjectTree projectTree) {
        this.projectTree = projectTree;
        this.sharedModel = SharedModel.INSTANCE;

        setHandlers();
    }

    private void setHandlers() {
        sharedModel.openedDirPathProperty().subscribe((absolutePath) -> {
            if (absolutePath != null) {
                var selectedPath = Path.of(absolutePath);

                projectTree.render(selectedPath);
            }
        });
    }

    public Region getView() {
        return projectTree.getView();
    }
}
