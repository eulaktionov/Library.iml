package library;

public class IdName {

    private Integer id;
    private String name;

    public IdName(String name) {
        this.id = 0;
        this.name = name;
    }
    public IdName() { this(""); }

    public  Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; };
    public void setName(String name) { this.name = name; }

    @Override
    public String toString(){
        return String.format("<%d %s", getId(), getName());
    }
}
