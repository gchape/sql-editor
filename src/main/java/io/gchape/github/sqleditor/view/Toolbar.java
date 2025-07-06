package io.gchape.github.sqleditor.view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;

import static io.gchape.github.sqleditor.view.utils.Icons.*;

public enum Toolbar {
    INSTANCE();

    private final ToolBar root;
    private final Button runQueryBtn;
    private final Button newFileBtn;
    private final Button openProjectBtn;
    private final DirectoryChooser directoryChooser;

    private final StringProperty projectPath = new SimpleStringProperty("../");
    private final ObjectProperty<EventHandler<? super MouseEvent>> onRunQueryMClicked = new SimpleObjectProperty<>();
    private final ObjectProperty<EventHandler<? super MouseEvent>> onNewFileMClicked = new SimpleObjectProperty<>();

    Toolbar() {
        root = new ToolBar();

        openProjectBtn = new Button("Open Project", folderIcon1);
        newFileBtn = new Button("New File", fileIcon1);
        runQueryBtn = new Button("Run Query", runIcon1);
        directoryChooser = new DirectoryChooser();

        configure();
        bind();
    }

    private void bind() {
        openProjectBtn.setOnMouseClicked(e -> {
            Window window = ((Node) e.getSource()).getScene().getWindow();
            projectPath.set(directoryChooser.showDialog(window).getAbsolutePath());
        });

        runQueryBtn.onMouseClickedProperty().bind(onRunQueryMClicked);
        newFileBtn.onMouseClickedProperty().bind(onNewFileMClicked);
    }

    private void configure() {
        root.setCache(true);
        root.setOrientation(Orientation.HORIZONTAL);

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

    public ObjectProperty<EventHandler<? super MouseEvent>> onRunQueryMClickedProperty() {
        return onRunQueryMClicked;
    }

    public ObjectProperty<EventHandler<? super MouseEvent>> onNewFileMClickedProperty() {
        return onNewFileMClicked;
    }
}
