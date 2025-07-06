package io.gchape.github.sqleditor.view.builder;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public interface Builder {
    class FXShortcut {
        private final HBox shortcut;
        private Label keyLabel;
        private Label descLabel;

        public FXShortcut() {
            shortcut = new HBox();
            shortcut.getStyleClass().add("shortcut-item");
        }

        public FXShortcut key(final String key) {
            keyLabel = new Label(key);
            keyLabel.getStyleClass().add("shortcut-key");

            return this;
        }

        public FXShortcut description(final String description) {
            descLabel = new Label(description);
            descLabel.getStyleClass().add("shortcut-description");

            return this;
        }

        public HBox build() {
            shortcut.getChildren().addAll(keyLabel, descLabel);
            return shortcut;
        }
    }
}
