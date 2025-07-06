package io.gchape.github.sqleditor.view;

import io.gchape.github.sqleditor.controller.ProjectTreeCtrl;
import io.gchape.github.sqleditor.controller.ToolbarCtrl;
import io.gchape.github.sqleditor.view.editor.SqlEditor;
import io.gchape.github.sqleditor.view.editor.TabbedSqlEditor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public enum App {
    INSTANCE();

    private final static KeyCombination KEYCODE_FIND_WORD =
            new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN);

    private final GridPane root;
    private final ProjectTreeCtrl projectTreeCtrl;
    private final ToolbarCtrl toolbarCtrl;
    private final TabbedSqlEditor tabbedSqlEditor;
    private final Search search;

    App() {
        root = new GridPane();

        projectTreeCtrl = ProjectTreeCtrl.INSTANCE;
        toolbarCtrl = ToolbarCtrl.INSTANCE;
        tabbedSqlEditor = TabbedSqlEditor.INSTANCE;
        search = Search.INSTANCE;

        setHandlers();
        compose();
    }

    private void setHandlers() {
        SqlEditor.INSTANCE.searchTextProperty()
                .bind(Search.INSTANCE.searchFieldTextProperty());

        root.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
            if (KEYCODE_FIND_WORD.match(e)) {
                boolean contains = root.getChildren().contains(search.getView());

                if (contains) {
                    root.getChildren().remove(search.getView());
                } else {
                    root.getChildren().add(search.getView());
                }
            }
        });
    }

    private void compose() {
        var fileTree = projectTreeCtrl.getView();
        var navigation = toolbarCtrl.getView();
        var editor = tabbedSqlEditor.getView();

        root.add(navigation, 0, 0, 2, 1);
        root.add(fileTree, 0, 1, 1, 2);
        root.add(search.getView(), 1, 1, 1, 1);
        root.add(editor, 1, 2, 1, 1);

        GridPane.setHgrow(navigation, Priority.ALWAYS);
        GridPane.setHgrow(editor, Priority.ALWAYS);
        GridPane.setVgrow(editor, Priority.ALWAYS);
        GridPane.setVgrow(fileTree, Priority.ALWAYS);
    }

    public final Region getView() {
        return root;
    }
}
