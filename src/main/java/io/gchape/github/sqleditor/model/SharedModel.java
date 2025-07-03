package io.gchape.github.sqleditor.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;

public enum SharedModel {
    INSTANCE();

    private final StringProperty openedDirPath;
    private ObservableList<Tab> tabs;

    SharedModel() {
        openedDirPath = new SimpleStringProperty();
    }

    public StringProperty openedDirPathProperty() {
        return openedDirPath;
    }

    public ObservableList<Tab> getTabs() {
        return tabs;
    }

    public void setTabs(final ObservableList<Tab> tabs) {
        this.tabs = tabs;
    }
}
