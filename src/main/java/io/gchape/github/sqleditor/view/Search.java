package io.gchape.github.sqleditor.view;

import io.gchape.github.sqleditor.view.utils.Icons;
import javafx.beans.property.*;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public enum Search {
    INSTANCE();

    private final HBox root;
    private final TextField searchField;
    private final Button searchBtn;

    private final StringProperty searchFieldText = new SimpleStringProperty("");
    private final ObjectProperty<EventHandler<? super MouseEvent>> onSearchBtnClicked = new SimpleObjectProperty<>();

    Search() {
        searchField = new TextField();
        searchBtn = new Button("", Icons.searchIcon1);
        root = new HBox(searchField, searchBtn);

        configure();
        bind();
    }

    private void bind() {
        searchFieldText.bindBidirectional(searchField.textProperty());
        searchBtn.onMouseClickedProperty().bind(onSearchBtnClicked);
    }

    private void configure() {
        root.getStyleClass().add("search-bar");
        searchBtn.getStyleClass().add("search-button");
        searchField.getStyleClass().add("search-field");

        searchField.setPromptText("Search...");

        HBox.setHgrow(searchField, Priority.ALWAYS);
    }

    public Region getView() {
        return root;
    }

    public ReadOnlyStringProperty searchFieldTextProperty() {
        return searchFieldText;
    }

    public ObjectProperty<EventHandler<? super MouseEvent>> onSearchBtnClickedProperty() {
        return onSearchBtnClicked;
    }
}
