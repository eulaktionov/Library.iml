package library;

public class Author  extends IdName {

    private String firstName;

    public Author(String name, String firstName) {
        super(name);
        this.firstName = firstName;
    }

    public Author() { super(); }

    public String getFirstName() { return firstName; };
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @Override
    public String toString(){
        return super.toString() +
            String.format(" %s>", getFirstName());
    }
}
