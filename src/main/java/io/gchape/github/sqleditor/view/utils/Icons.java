package io.gchape.github.sqleditor.view.utils;

import javafx.scene.CacheHint;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.Objects;
import java.util.Random;

public class Icons {
    public static ImageView fileIcon1 = new ImageView(new Image(
            Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/file1.png")))
    );

    public static ImageView folderIcon1 = new ImageView(new Image(
            Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/folder1.png")))
    );

    public static ImageView fileIcon2 = new ImageView(new Image(
            Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/file1.png")))
    );

    public static ImageView folderIcon2 = new ImageView(new Image(
            Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/folder2.png")))
    );

    public static ImageView newFolderIcon2() {
        return new ImageView(new Image(
                Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/folder2.png")))
        );
    }

    public static ImageView newFileIcon2() {
        return new ImageView(new Image(
                Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/file2.png")))
        );
    }
}
