module io.gchape.github.sqleditor {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;
    requires jdk.compiler;
    requires org.fxmisc.richtext;

    exports io.gchape.github.sqleditor;
    exports io.gchape.github.sqleditor.controller;
}