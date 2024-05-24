package commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import library.Library;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
//----------------------------------------------------------
    private static String libraryFile = "library.json";
    public static Library library;

    public static void main(String[] args) {
        System.out.println(Commands.separatorLine);
        System.out.println("Library project v2.3");
        System.out.println("Enter command (Enter - Escape)");

        library = deserializeLib(libraryFile);
        new MainCommands().run();
        serializeLib(libraryFile, library);
    }
//----------------------------------------------------------
    public static void serializeLib(String filename, Library library)
    {
        try
        {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectMapper objectMapper = new ObjectMapper().
                    enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.registerModule(new JodaModule());
            objectMapper.writeValue(file, library);
            file.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static Library deserializeLib(String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JodaModule());
            FileInputStream file = new FileInputStream(filename);
            Library library = objectMapper.readValue(file, Library.class);
            library.relinkBookAuthor();
            file.close();
            return library;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new Library();
        }
    }
//----------------------------------------------------------
}