package library;

import commands.Commands;

//import java.time.LocalDate;
import org.joda.time.LocalDate;

public class Reader extends IdName {

    private String firstName;
    private LocalDate birthDate;

    public Reader(String name, String firstName,
            LocalDate birthDate) {
        super(name);
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public Reader() {
        super();
        birthDate = new LocalDate(1900, 1, 1);
    }

    public String getFirstName() { return firstName; };
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    @Override
    public String toString(){
        return super.toString() +
                String.format(" %s ", getFirstName()) +
                birthDate.toString(Commands.dateFormat) + ">";
    }
}
