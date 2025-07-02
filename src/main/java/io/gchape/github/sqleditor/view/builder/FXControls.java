package io.gchape.github.sqleditor.view.builder;

import javafx.scene.control.Button;
import javafx.scene.control.Control;

public final class FXControls {
    private FXControls() {
    }

    public static class Type<T extends Control> {
        private final Class<T> type;

        public Type(final Class<T> type) {
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        public Builder<T> newInstance() {
            if (type == Button.class) {
                return (Builder<T>) new Builder.FXButton();
            } else {
                try {
                    throw new ClassNotFoundException();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
