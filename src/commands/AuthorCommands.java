package commands;

import library.*;

public class AuthorCommands extends ItemListCommands<Author> {
//----------------------------------------------------------
    public AuthorCommands() {
        super("Authors menu");
    }

    public ItemList<Author> getMainList() {
        return Main.library.getAuthors();
    }

    public  void addItem()
        throws EmptyInputException {
        Author author = new Author();
        author.setName(readString("Enter name: "));
        author.setFirstName(readString("Enter first name: "));
        getMainList().add(author);
    }

    public  void updateItem(Author author)
        throws EmptyInputException {
        author.setName(readUpdateString("Enter name",
            author.getName()));
        author.setFirstName(readUpdateString("Enter first name",
            author.getFirstName()));
    }
//----------------------------------------------------------
}
