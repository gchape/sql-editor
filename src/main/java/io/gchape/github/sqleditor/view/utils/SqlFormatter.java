package io.gchape.github.sqleditor.view.utils;

import org.apache.openjpa.lib.jdbc.SQLFormatter;

public class SqlFormatter {
    public static SQLFormatter DEFAULT = new SQLFormatter();

    static {
        DEFAULT.setLineLength(50);
        DEFAULT.setNewline(System.lineSeparator());
        DEFAULT.setMultiLine(true);
    }
}
