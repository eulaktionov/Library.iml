package commands;

import library.*;
import org.joda.time.LocalDate;

public class LogCommands extends ItemListCommands<LogEntry>{

    public  LogCommands() {
        super("Log menu");
        removeAt(5);    // print names
        removeAt(1);    // print names
        add("Give book", this::add);
        add("Get book", this::getBook);
        add("View reader's books", this::viewReaderBooks);
        add("View needed books", this::viewNeededBooks);
        arrangeNumbers();
    }

    public  ItemList<LogEntry> getMainList() { return Main.library.getLog(); }

    public  void addItem()
            throws EmptyInputException {
    }

    public  void updateItem(LogEntry logEntry)
            throws EmptyInputException {
    }

    public boolean giveBook() {

        return true;
    }

    public boolean getBook() {

        return true;
    }

    public boolean viewReaderBooks() {

        return true;
    }

    public boolean viewNeededBooks() {

        return true;
    }
}
