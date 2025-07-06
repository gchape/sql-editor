package io.gchape.github.sqleditor.view.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Icons {
    public static ImageView fileIcon1 = new ImageView(new Image(
            Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/file1.png")))
    );

    public static ImageView folderIcon1 = new ImageView(new Image(
            Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/folder1.png")))
    );

    public static ImageView runIcon1 = new ImageView(new Image(
            Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/run1.png")))
    );

    public static ImageView searchIcon1 = new ImageView(new Image(
            Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/search1.png")))
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

    public static ImageView newTabIcon1() {
        return new ImageView(new Image(
                Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/tab1.png")))
        );
    }
}
