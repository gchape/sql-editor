package io.gchape.github.sqleditor;

import io.gchape.github.sqleditor.controller.SceneCtrl;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Objects;

public class SqlEditorApplication extends Application {
    private SceneCtrl sc;

    @Override
    public void init() {
        sc = SceneCtrl.INSTANCE;

        addStylesheets();
    }

    private void addStylesheets() {
        sc.getScene().getStylesheets().add(
                Objects.requireNonNull(
                                getClass().getResource("/stylesheet/sql-editor.css"))
                        .toExternalForm()
        );
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Sql Editor");
        stage.setScene(sc.getScene());
        stage.setHeight(600.00);
        stage.setWidth(800.00);
        stage.show();
    }
}
