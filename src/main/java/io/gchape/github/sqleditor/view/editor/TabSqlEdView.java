package io.gchape.github.sqleditor.view.editor;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public enum TabSqlEdView {
    INSTANCE();

    private final VBox root;
    private final TabPane tabPane;
    private final SqlEdView sqlEdView;

    TabSqlEdView() {
        root = new VBox();
        tabPane = new TabPane();
        sqlEdView = SqlEdView.INSTANCE;

        build();
    }

    private void build() {
        final var sqlEd = sqlEdView.getView();

        root.getChildren().addAll(tabPane, sqlEd);

        VBox.setVgrow(sqlEd, Priority.ALWAYS);
        tabPane.getTabs().add(new Tab("default"));
        tabPane.getTabs().add(new Tab("default"));

    }

    public Region getView() {
        return root;
    }
}
