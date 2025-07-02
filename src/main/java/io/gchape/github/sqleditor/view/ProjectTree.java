package io.gchape.github.sqleditor.view;

import io.gchape.github.sqleditor.view.utils.Icons;
import javafx.application.Platform;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public enum ProjectTree {
    INSTANCE();

    private final TreeView<String> root;

    ProjectTree() {
        root = new TreeView<>(null);
        root.setCache(true);
        root.setShowRoot(false);
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
        current.setGraphic(Icons.newFolderIcon2());

        try (var children = Files.list(dir)) {
            children.forEach(child -> {
                if (Files.isDirectory(child)) {
                    current.getChildren().add(renderRecursive(child));
                } else {
                    final var treeItem = new TreeItem<>(child.getFileName().toString());
                    treeItem.setGraphic(Icons.newFileIcon2());

                    current.getChildren().add(treeItem);
                }
            });
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return current;
    }
}
