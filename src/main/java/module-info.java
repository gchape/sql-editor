module io.gchape.github.sqleditor {
    requires javafx.controls;
    requires openjpa.lib;
    requires java.base;
    requires org.fxmisc.richtext;

    exports io.gchape.github.sqleditor;
    exports io.gchape.github.sqleditor.controller;
    exports io.gchape.github.sqleditor.controller.scene;
}