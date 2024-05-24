package commands;

import library.*;
import org.joda.time.LocalDate;

public class BookCommands extends ItemListCommands<Book>{
//----------------------------------------------------------
    public BookCommands() {
        super("Books menu");
        add("Print author books", this::findAuthorBooks);
        arrangeNumbers();
    }

    public ItemList<Book> getMainList() { return Main.library.getBooks(); }

    public  void addItem()
        throws EmptyInputException {
        Book book = new Book();
        book.setName(Commands.readString("Enter name: "));
        book.setAuthor(findHard(Main.library.getAuthors(),
                "Enter author id: "));
        book.setPublishingYear(Commands.
                readInteger("Enter publishing year: ",
                    y -> y > 1900 && y <= LocalDate.now().getYear()));
        getMainList().add(book);
    }

    public  void updateItem(Book book)
        throws EmptyInputException {
        book.setName(Commands.readUpdateString("Enter name",
            book.getName()));
//        int authorId = readUpdateInteger("Enter author id",
//            book.getAuthor().getId(),
//            i -> Main.library.getAuthors().getList().stream().
//            anyMatch(x -> x.getId().equals(i)));
        int authorId = new AuthorCommands().updateId(book, "Enter author id");
        book.setAuthor(Main.library.getAuthors().find(authorId));
        book.setPublishingYear(Commands.
                readUpdateInteger("Enter publishing year", book.getPublishingYear(),
                        y -> y > 1900 && y <= LocalDate.now().getYear()));
    }
//----------------------------------------------------------
    public Boolean findAuthorBooks() {
        try {
            Integer authorId = readInteger("Enter author id: ", i -> i > 0);
            ItemList<Book> result = new ItemList<>();
            result.setList(Main.library.getBooks().getList().stream().
                    filter(it -> it.getAuthor().getId().equals(authorId)).
                    toList());
            printList(result.getList()); }
        catch (Exception ignored) {}
        return true;
    }
//----------------------------------------------------------
}
