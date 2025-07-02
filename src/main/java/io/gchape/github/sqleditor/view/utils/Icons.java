package io.gchape.github.sqleditor.view.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Icons {
    public static ImageView fileIcon = new ImageView(new Image(
            Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/file.png")))
    );

    public static ImageView folderIcon = new ImageView(new Image(
            Objects.requireNonNull(Icons.class.getResourceAsStream("/icons/folder.png")))
    );
}
