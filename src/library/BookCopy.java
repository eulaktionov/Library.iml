package library;

public class BookCopy  extends IdName {

    private Book book;
    private String number;

    public BookCopy(Book book, String number) {
        super();
        this.book = book;
        this.number = number;
    }

    public BookCopy() {
        super();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString() + " " + book.toString() +
                String.format(" %s>", getNumber());
    }
}
