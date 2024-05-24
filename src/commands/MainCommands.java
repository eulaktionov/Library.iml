package commands;

import library.Book;
import library.Library;

public class MainCommands extends Commands {
//----------------------------------------------------------
    public MainCommands() {
        super("Main menu");
        add("Log", () ->
            { new LogCommands().run(); return true; });
        add("Authors List", () ->
            { new AuthorCommands().run(); return true; });
        add("Books List", () ->
            { new BookCommands().run(); return true; });
        add("Book Copies List", () ->
            { new CopyCommands().run(); return true; });
        add("Reader List", () ->
            { new ReaderCommands().run(); return true; });
        arrangeNumbers();
    }
//----------------------------------------------------------
}
