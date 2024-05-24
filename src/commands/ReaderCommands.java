package commands;

import library.*;

public class ReaderCommands extends ItemListCommands<Reader> {
//----------------------------------------------------------
    public ReaderCommands() {
        super("Readers menu");
    }

    public  ItemList<Reader> getMainList() { return Main.library.getReaders(); }

    public  void addItem()
        throws EmptyInputException {
        Reader reader = new Reader();
        reader.setName(readString("Enter name: "));
        reader.setFirstName(readString("Enter first name: "));
        reader.setBirthDate(readLocalDate("Enter birth date..."));
        getMainList().add(reader);
    }

    public  void updateItem(Reader reader)
        throws EmptyInputException {
        reader.setName(readUpdateString("Enter name", reader.getName()));
        reader.setFirstName(readUpdateString("Enter first name",
            reader.getFirstName()));
        reader.setBirthDate(readUpdateLocalDate("Enter birth date... ",
            reader.getBirthDate()));
    }
//----------------------------------------------------------
}
