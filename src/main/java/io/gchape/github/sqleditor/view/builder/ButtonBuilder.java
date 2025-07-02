package io.gchape.github.sqleditor.view.builder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class ButtonBuilder {
    private String title;
    private Node graphic;
    private String styleClass;
    private double prefWidth = -1;
    private String tooltipText;
    private EventHandler<ActionEvent> action;

    public ButtonBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ButtonBuilder setStyleClass(String styleClass) {
        this.styleClass = styleClass;
        return this;
    }

    public ButtonBuilder setPrefWidth(double prefWidth) {
        this.prefWidth = prefWidth;
        return this;
    }

    public ButtonBuilder setGraphic(Node graphic) {
        this.graphic = graphic;
        return this;
    }

    public ButtonBuilder setTooltip(String tooltipText) {
        this.tooltipText = tooltipText;
        return this;
    }

    public ButtonBuilder setOnAction(EventHandler<ActionEvent> action) {
        this.action = action;
        return this;
    }

    public Button build() {
        Button button = new Button(title != null ? title : "");

        if (styleClass != null && !styleClass.isEmpty()) {
            button.getStyleClass().add(styleClass);
        }

        if (prefWidth > 0) {
            button.setPrefWidth(prefWidth);
        }

        if (graphic != null) {
            button.setGraphic(graphic);
        }

        if (tooltipText != null && !tooltipText.isEmpty()) {
            button.setTooltip(new Tooltip(tooltipText));
        }

        if (action != null) {
            button.setOnAction(action);
        }

        return button;
    }
}

