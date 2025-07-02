package io.gchape.github.sqleditor.view;

import io.gchape.github.sqleditor.controller.FileTreeCtrl;
import io.gchape.github.sqleditor.controller.NavigationCtrl;
import io.gchape.github.sqleditor.view.editor.TabbedSqlEditor;
import javafx.scene.layout.*;

public enum Application {
    INSTANCE();

    private final GridPane root;
    private final FileTreeCtrl fileTreeCtrl;
    private final NavigationCtrl navigationCtrl;
    private final TabbedSqlEditor tabbedSqlEditor;

    Application() {
        root = new GridPane();
        root.getStyleClass().add("editor-view");

        fileTreeCtrl = FileTreeCtrl.INSTANCE;
        navigationCtrl = NavigationCtrl.INSTANCE;
        tabbedSqlEditor = TabbedSqlEditor.INSTANCE;

        compose();
    }

    private void compose() {
        var fileTree = fileTreeCtrl.getView();
        var navigation = navigationCtrl.getView();
        var editor = tabbedSqlEditor.getView();

        root.add(navigation, 0, 0, 2, 1);
        root.add(fileTree, 0, 1);
        root.add(editor, 1, 1);

        GridPane.setHgrow(navigation, Priority.ALWAYS);

        GridPane.setHgrow(editor, Priority.ALWAYS);
        GridPane.setVgrow(editor, Priority.ALWAYS);

        GridPane.setVgrow(fileTree, Priority.ALWAYS);

        var col1 = new ColumnConstraints();
        col1.setMinWidth(200);
        col1.setMaxWidth(200);

        var col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);

        root.getColumnConstraints().addAll(col1, col2);

        var row1 = new RowConstraints();
        row1.setMinHeight(40);
        row1.setMaxHeight(40);

        var row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS);

        root.getRowConstraints().addAll(row1, row2);
    }

    public final Region getView() {
        return root;
    }
}
