package io.gchape.github.sqleditor.view.builder;

public final class FXControls {
    private FXControls() {
    }

    public static Builder.FXButton newButton() {
        return new Builder.FXButton();
    }

    public static Builder.FXShortcut newShortcut() {
        return new Builder.FXShortcut();
    }
}
