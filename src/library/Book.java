package library;

public class Book extends IdName {

    private  Author author;
    private  Integer publishingYear;

    public Book(String name, Author author, Integer publishingYear) {
        super(name);
        this.author = author;
        this.publishingYear = publishingYear;
    }

    public Book() { super(); }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public Integer getPublishingYear() { return publishingYear; }
    public void setPublishingYear(Integer publishingYear) {
        this.publishingYear = publishingYear;
    }

    @Override
    public String toString(){
        return super.toString() + " " + author.toString() +
                String.format(" %d>", getPublishingYear());
    }
}
