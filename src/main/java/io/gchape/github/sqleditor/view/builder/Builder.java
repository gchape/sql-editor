package io.gchape.github.sqleditor.view.builder;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public interface Builder<T> {
    Builder<T> setText(final String title);

    Builder<T> setGraphic(final ImageView imageView);

    Builder<T> addStyleClass(final String styleClass);

    T build();

    class FXButton implements Builder<Button> {
        private final Button button;

        public FXButton() {
            button = new Button();
        }

        @Override
        public Builder<Button> setText(final String title) {
            button.setText(title);
            return this;
        }

        @Override
        public Builder<Button> setGraphic(final ImageView imageView) {
            button.setGraphic(imageView);
            return this;
        }

        @Override
        public Builder<Button> addStyleClass(final String styleClass) {
            button.getStyleClass().add(styleClass);
            return this;
        }

        @Override
        public Button build() {
            return button;
        }
    }
}
