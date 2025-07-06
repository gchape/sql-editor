package io.gchape.github.sqleditor.view;

import io.gchape.github.sqleditor.view.builder.CustomControls;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;

public enum Welcome {
    INSTANCE();

    private final BorderPane root;

    Welcome() {
        root = new BorderPane();
        root.getStyleClass().add("border-pane");

        configure();
    }

    private void configure() {
        FlowPane shortcuts = new FlowPane();
        shortcuts.setAlignment(Pos.CENTER);
        shortcuts.setOrientation(Orientation.VERTICAL);
        shortcuts.setVgap(7);

        shortcuts.getChildren().addAll(
                CustomControls.newShortcut()
                        .key("Ctrl+N")
                        .description("New SQL File")
                        .build(),

                CustomControls.newShortcut()
                        .key("Ctrl+S")
                        .description("Save")
                        .build(),

                CustomControls.newShortcut()
                        .key("Ctrl+Enter")
                        .description("Execute Selected")
                        .build(),

                CustomControls.newShortcut()
                        .key("Shift+Alt+L")
                        .description("Reformat File")
                        .build(),

                CustomControls.newShortcut()
                        .key("Ctrl+F")
                        .description("Find")
                        .build(),

                CustomControls.newShortcut()
                        .key("Ctrl+W")
                        .description("Close Tab")
                        .build(),

                CustomControls.newShortcut()
                        .key("Ctrl+/")
                        .description("Toggle Comment")
                        .build()
        );

        root.setCenter(shortcuts);
        BorderPane.setAlignment(shortcuts, Pos.CENTER);
    }

    public Region getView() {
        return root;
    }
}
