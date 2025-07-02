package io.gchape.github.sqleditor.view.editor;

import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public enum TabbedSqlEditor {
    INSTANCE();

    private final VBox root;
    private final TabPane tabPane;
    private final SqlEditor sqlEditor;

    TabbedSqlEditor() {
        root = new VBox();
        tabPane = new TabPane();
        tabPane.setSide(Side.BOTTOM);
        sqlEditor = SqlEditor.INSTANCE;

        build();
    }

    private void build() {
        final var sqlEd = sqlEditor.getView();
        VBox.setVgrow(sqlEd, Priority.ALWAYS);

        root.getChildren().addAll(tabPane, sqlEd);

        tabPane.getTabs().add(new Tab("terminal.sql"));
    }

    public Region getView() {
        return root;
    }
}
