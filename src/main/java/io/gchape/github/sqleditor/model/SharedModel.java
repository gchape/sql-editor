package io.gchape.github.sqleditor.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public enum SharedModel {
    INSTANCE();

    private final StringProperty openedDirPath;

    SharedModel() {
        openedDirPath = new SimpleStringProperty();
    }

    public StringProperty openedDirPathProperty() {
        return openedDirPath;
    }
}
