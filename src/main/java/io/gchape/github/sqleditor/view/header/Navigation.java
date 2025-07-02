package io.gchape.github.sqleditor.view.header;

import io.gchape.github.sqleditor.view.builder.ButtonBuilder;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.DirectoryChooser;

import static io.gchape.github.sqleditor.view.utils.Icons.fileIcon1;
import static io.gchape.github.sqleditor.view.utils.Icons.folderIcon1;

public enum Navigation {
    INSTANCE();

    private final HBox root;
    private final ToolBar toolBar;
    private final DirectoryChooser directoryChooser;
    private final StringProperty openedDirPath;

    private Button openDirBtn;
    private Button createFileBtn;

    Navigation() {
        root = new HBox();
        toolBar = new ToolBar();
        directoryChooser = new DirectoryChooser();

        root.getStyleClass().add("nav-bar");
        toolBar.getStyleClass().add("tool-bar");

        openedDirPath = new SimpleStringProperty("../");

        build();
        setHandlers();
        bind();
    }

    private void setHandlers() {
        openDirBtn.setOnMouseClicked(e -> {
            var window = ((Node) e.getSource()).getScene().getWindow();
            var selectedDir = directoryChooser.showDialog(window);

            if (selectedDir != null) {
                openedDirPath.set(selectedDir.getAbsolutePath());
            }
        });
    }

    private void bind() {
    }

    private void build() {
        toolBar.setOrientation(Orientation.HORIZONTAL);

        openDirBtn = new ButtonBuilder()
                .setTitle("Open...")
                .setGraphic(folderIcon1)
                .setStyleClass("toolbar-btn")
                .build();

        createFileBtn = new ButtonBuilder()
                .setTitle("New")
                .setGraphic(fileIcon1)
                .setStyleClass("toolbar-btn")
                .build();

        toolBar.getItems().addAll(createFileBtn, openDirBtn);
        root.getChildren().add(toolBar);
    }

    public Region getView() {
        return root;
    }

    public StringProperty openedDirPathProperty() {
        return openedDirPath;
    }
}
