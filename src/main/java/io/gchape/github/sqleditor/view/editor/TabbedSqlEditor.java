package io.gchape.github.sqleditor.view.editor;

import io.gchape.github.sqleditor.view.Welcome;
import javafx.collections.ObservableList;
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
    private final Welcome welcome;
    private final SqlEditor sqlEditor;

    TabbedSqlEditor() {
        tabPane = new TabPane();
        sqlEditor = SqlEditor.INSTANCE;
        welcome = Welcome.INSTANCE;
        root = new VBox(tabPane, sqlEditor.getView());

        configure();
        bind();
    }

    private void bind() {
        tabPane.getTabs().subscribe(() -> {
            if (getTabs().isEmpty()) {
                root.getChildren().clear();

                VBox.setVgrow(welcome.getView(), Priority.ALWAYS);
                root.getChildren().add(welcome.getView());
            } else if (!root.getChildren().contains(tabPane)) {
                root.getChildren().clear();

                root.getChildren().addAll(tabPane, sqlEditor.getView());
            }
        });
    }

    private void configure() {
        tabPane.setSide(Side.BOTTOM);

        VBox.setVgrow(sqlEditor.getView(), Priority.ALWAYS);
    }

    public ObservableList<Tab> getTabs() {
        return tabPane.getTabs();
    }

    public Region getView() {
        return root;
    }
}
