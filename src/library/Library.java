package library;

import org.joda.time.LocalDate;

import java.util.List;
import org.joda.time.LocalDate;

public class Library {
//----------------------------------------------------------
    private ItemList<Author> authors;
    private ItemList<Book> books;
    private ItemList<BookCopy> copies;
    private ItemList<Reader> readers;
    private ItemList<LogEntry> log;
//----------------------------------------------------------
    public Library() {
        authors = new ItemList<>();
        authors.add(new Author("an111", "afn11"));
        authors.add(new Author("an222", "afn22"));
        authors.add(new Author("an111", "afn22"));
//----------------------------------------------------------
        books = new ItemList<>();
        books.add(new Book("bn111", authors.get(0), 2001));
        books.add(new Book("bn222", authors.get(1), 2002));
        books.add(new Book("bn111", authors.get(2), 2003));
        books.add(new Book("bn333", authors.get(0), 2004));
        books.add(new Book("bn444", authors.get(2), 2005));
//----------------------------------------------------------
        copies = new ItemList<>();
        copies.add(new BookCopy(books.get(0), "101"));
        copies.add(new BookCopy(books.get(0), "102"));
        copies.add(new BookCopy(books.get(1), "111"));
        copies.add(new BookCopy(books.get(2), "121"));
        copies.add(new BookCopy(books.get(3), "131"));
        copies.add(new BookCopy(books.get(3), "132"));
        copies.add(new BookCopy(books.get(3), "133"));
        copies.add(new BookCopy(books.get(4), "141"));
//----------------------------------------------------------
        readers = new ItemList<>();
        readers.add(new Reader("rn111", "rfn11",
                new LocalDate(2001, 1,1)));
        readers.add(new Reader("rn222", "rfn22",
                new LocalDate(2002, 2,2)));
        readers.add(new Reader("rn333", "rfn33",
                new LocalDate(2003, 3,3)));
//----------------------------------------------------------
        log = new ItemList<>();
        LogEntry logEntry = new LogEntry(1,1);
        logEntry.setGiveDate(new LocalDate(2024, 5, 11));
        logEntry.setGetDate(new LocalDate(2024, 5, 12));
        log.add(logEntry);

        logEntry = new LogEntry(1,3);
        logEntry.setGiveDate(new LocalDate(2024, 5, 11));
        log.add(logEntry);

        logEntry = new LogEntry(2,1);
        logEntry.setGiveDate(new LocalDate(2024, 5, 12));
        log.add(logEntry);

        logEntry = new LogEntry(2,4);
        logEntry.setGiveDate(new LocalDate(2024, 5, 12));
        log.add(logEntry);
    }
//----------------------------------------------------------
    public ItemList<Author> getAuthors() { return authors; }
    public ItemList<Book> getBooks() { return books; }
    public ItemList<BookCopy> getCopies() { return copies; }
    public ItemList<Reader> getReaders() { return readers; }
    public ItemList<LogEntry> getLog() { return log; }
//----------------------------------------------------------
    public void relinkBookAuthor() {
        for (var book : books.getList()) {
            Author author = authors.getList().stream().
                filter(it -> it.getId() == book.getAuthor().getId()).
                    findFirst().orElse(null);
            book.setAuthor(author);
        }
    }

    public void relinkCopyBook() {
        for (var copy : copies.getList()) {
            Book book = books.getList().stream().
                    filter(it -> it.getId() == copy.getBook().getId()).
                    findFirst().orElse(null);
            copy.setBook(book);
        }
    }
//----------------------------------------------------------
}
