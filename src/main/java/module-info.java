module io.gchape.github.sqleditor {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;
    requires jdk.compiler;
    requires sql.formatter;

    exports io.gchape.github.sqleditor;
    exports io.gchape.github.sqleditor.controller;
    exports io.gchape.github.sqleditor.controller.scene;
    exports io.gchape.github.sqleditor.controller.handlers;
}