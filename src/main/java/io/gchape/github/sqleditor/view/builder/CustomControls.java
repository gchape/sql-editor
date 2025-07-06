package io.gchape.github.sqleditor.view.builder;

public final class CustomControls {
    private CustomControls() {
    }

    public static Builder.FXShortcut newShortcut() {
        return new Builder.FXShortcut();
    }
}
