package commands;

import library.Book;
import library.BookCopy;
import library.ItemList;

public class CopyCommands extends ItemListCommands<BookCopy>{
//----------------------------------------------------------
    public CopyCommands() {
        super("Copies menu");
        add("Print book copies", this::findBookCopies);
        arrangeNumbers();
    }

    public ItemList<BookCopy> getMainList() {
        return Main.library.getCopies();
    }

    public  void addItem()
        throws EmptyInputException {
        BookCopy copy = new BookCopy();
        copy.setBook(findHard(Main.library.getBooks(),
                "Enter book id: "));
        copy.setNumber(Commands.readString("Enter number: "));
        getMainList().add(copy);
    }

    public  void updateItem(BookCopy copy)
        throws EmptyInputException {
//        int bookId = readUpdateInteger("Enter book id",
//            copy.getBook().getId(),
//            i -> Main.library.getBooks().getList().stream().
//            anyMatch(x -> x.getId().equals(i)));
        int bookId = new BookCommands().updateId(copy, "Enter book id");
        copy.setBook(Main.library.getBooks().find(bookId));
        copy.setNumber(Commands.readUpdateString("Enter number: ",
            copy.getNumber()));
    }

    public Boolean findBookCopies() {
        try {
        Integer bookId = readInteger("Enter book id: ", i -> i > 0);
        ItemList<BookCopy> result = new ItemList<>();
        result.setList(Main.library.getCopies().getList().stream().
                filter(it -> it.getBook().getId().equals(bookId)).
                toList());
        printList(result.getList()); }
        catch (Exception e) {}
        return true;
    }
//----------------------------------------------------------
}
