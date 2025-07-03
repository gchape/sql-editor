package io.gchape.github.sqleditor.view;

import io.gchape.github.sqleditor.controller.handlers.ToolbarEventHandlers;
import io.gchape.github.sqleditor.view.builder.FXControls;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.DirectoryChooser;

import static io.gchape.github.sqleditor.view.utils.Icons.*;

public enum Toolbar {
    INSTANCE();

    private final ToolBar root;
    private final DirectoryChooser directoryChooser;
    private final StringProperty projectPath;
    private ToolbarEventHandlers toolbarEventHandlers;

    private Button runQueryBtn;
    private Button newFileBtn;
    private Button openProjectBtn;

    Toolbar() {
        this.root = new ToolBar();
        this.directoryChooser = new DirectoryChooser();
        this.projectPath = new SimpleStringProperty("../");

        configure();
    }

    public void setToolbarEventHandlers(final ToolbarEventHandlers toolbarEventHandlers) {
        this.toolbarEventHandlers = toolbarEventHandlers;
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

        newFileBtn.setOnMouseClicked(toolbarEventHandlers::onNewFileBtnClicked);
        runQueryBtn.setOnMouseClicked(toolbarEventHandlers::onRunQueryBtnClicked);
    }

    private void configure() {
        root.setCache(true);
        root.setOrientation(Orientation.HORIZONTAL);

        openProjectBtn = FXControls
                .newButton()
                .text("Open Project")
                .graphic(folderIcon1)
                .build();

        newFileBtn = FXControls
                .newButton()
                .text("New File")
                .graphic(fileIcon1)
                .build();

        runQueryBtn = FXControls
                .newButton()
                .text("Run Query")
                .graphic(runIcon1)
                .build();

        var spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        root.getItems().addAll(newFileBtn, openProjectBtn, spacer, runQueryBtn);
    }

    public Region getView() {
        return root;
    }

    public StringProperty projectPathProperty() {
        return projectPath;
    }
}
