package io.gchape.github.sqleditor.view.header;

import io.gchape.github.sqleditor.view.builder.ButtonBuilder;
import javafx.geometry.Orientation;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

import static io.gchape.github.sqleditor.view.utils.Icons.fileIcon;
import static io.gchape.github.sqleditor.view.utils.Icons.folderIcon;

public enum Navigation {
    INSTANCE();

    private final HBox root;
    private final ToolBar toolBar;

    Navigation() {
        root = new HBox();
        toolBar = new ToolBar();

        root.getStyleClass().add("nav-bar");
        toolBar.getStyleClass().add("tool-bar");

        build();
    }

    private void build() {
        toolBar.setOrientation(Orientation.HORIZONTAL);

        var newFileBtn = new ButtonBuilder()
                .setTitle("New")
                .setGraphic(fileIcon)
                .setStyleClass("toolbar-btn")
                .build();

        var openBtn = new ButtonBuilder()
                .setTitle("Open...")
                .setGraphic(folderIcon)
                .setStyleClass("toolbar-btn")
                .build();

        toolBar.getItems().addAll(newFileBtn, openBtn);

        root.getChildren().add(toolBar);
    }

    public Region getView() {
        return root;
    }
}
