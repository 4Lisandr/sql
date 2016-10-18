package ua.com.juja.sqlcmd.controller;

import ua.com.juja.sqlcmd.DatabaseManager;
import ua.com.juja.sqlcmd.InMemoryDatabaseManager;
import ua.com.juja.sqlcmd.view.Console;
import ua.com.juja.sqlcmd.view.View;

/**
 *
 */
public class MainController {
    public static void main(String[] args) {
        View view = new Console();
        DatabaseManager databaseManager = new InMemoryDatabaseManager();

        view.write("Hello user!");
        view.write("database|name|password");

        String data = view.read();

    }
}
