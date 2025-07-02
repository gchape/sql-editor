package io.gchape.github.sqleditor.view;

import io.gchape.github.sqleditor.view.builder.FXControls;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Region;
import javafx.stage.DirectoryChooser;

import static io.gchape.github.sqleditor.view.utils.Icons.fileIcon1;
import static io.gchape.github.sqleditor.view.utils.Icons.folderIcon1;

public enum Toolbar {
    INSTANCE();

    private final ToolBar root;
    private final DirectoryChooser directoryChooser;
    private final StringProperty projectPath;

    private Button newFileBtn;
    private Button openProjectBtn;

    Toolbar() {
        root = new ToolBar();
        directoryChooser = new DirectoryChooser();

        projectPath = new SimpleStringProperty("../");

        build();
        setHandlers();
    }

    private void setHandlers() {
        openProjectBtn.setOnMouseClicked(e -> {
            var window = ((Node) e.getSource()).getScene().getWindow();
            var selectedDir = directoryChooser.showDialog(window);

            if (selectedDir != null) {
                projectPath.set(selectedDir.getAbsolutePath());
            }
        });
    }

    private void build() {
        root.setCache(true);
        root.setOrientation(Orientation.HORIZONTAL);

        openProjectBtn = new FXControls.Type<>(Button.class)
                .newInstance()
                .setText("Open...")
                .setGraphic(folderIcon1)
                .build();

        newFileBtn = new FXControls.Type<>(Button.class)
                .newInstance()
                .setText("New")
                .setGraphic(fileIcon1)
                .build();

        root.getItems().addAll(newFileBtn, openProjectBtn);
    }

    public Region getView() {
        return root;
    }

    public StringProperty projectPathProperty() {
        return projectPath;
    }
}
