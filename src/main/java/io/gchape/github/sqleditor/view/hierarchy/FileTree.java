package io.gchape.github.sqleditor.view.hierarchy;

import javafx.application.Platform;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public enum FileTree {
    INSTANCE();

    private final TreeView<String> root;

    FileTree() {
        root = new TreeView<>();
        root.getStyleClass().add("file-tree");
    }

    public Region getView() {
        return root;
    }

    public void render(final Path dir) {
        final var root = renderRecursive(dir);

        Platform.runLater(() -> this.root.setRoot(root));
    }

    private TreeItem<String> renderRecursive(final Path dir) {
        final var current = new TreeItem<>(dir.getFileName().toString());

        try (var children = Files.list(dir)) {
            children.forEach(child -> {
                if (Files.isDirectory(child)) {
                    current.getChildren().add(renderRecursive(child));
                } else {
                    current.getChildren().add(new TreeItem<>(child.getFileName().toString()));
                }
            });
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return current;
    }
}
