package commands;

import library.ItemList;
import org.joda.time.LocalDate;

import java.util.*;
import java.util.function.Predicate;

public class Commands {
//----------------------------------------------------------
    public static Scanner reader = new Scanner(System.in);
    public static String dateFormat = "dd.MM.yyyy";
    public static String separatorLine = "-".repeat(30);
//----------------------------------------------------------
    public static class Item {
        private String text;
        private IMenuCommand method;
        private int id;

        public Item(String text, IMenuCommand method) {
            this.text = text;
            this.method = method;
        }

        public String toString() {
            return String.format("%2d : %s", id, text);
        }
    }
//----------------------------------------------------------
    private final String title;
    private final List<Item> commands;

    public Commands(String title) {
        this.title = title;
        commands = new ArrayList<>();
    }

    public void add(String text, IMenuCommand method) {
        commands.add(new Item(text, method));
    }

    public void removeAt(int index) {
        commands.remove(index);
    }

    public void insertAt(int index, String text, IMenuCommand method) {
        commands.add(index, new Item(text, method));
    }

    public void updateAt(int index, String text) {
        commands.get(index).text = text;
    }

    public void updateAt(int index, IMenuCommand method) {
        commands.get(index).method = method;
    }
    public void arrangeNumbers() {
        int number = 1;
        for(var command : commands) {
            command.id = number++;
        }
    }

    public void run() {
        boolean result = true;
        do {
            try {
                result = execute();
            } catch (EmptyInputException e) {
                result = false;
            } catch (Exception e) {
                System.out.println("Command Error!");
                System.out.println(e.getMessage());
            }
        }
        while (result);
    }

    private boolean execute() throws Exception{
        System.out.println(separatorLine);
        System.out.println("<" + title  + ">");
        System.out.println(separatorLine);
        printList(commands);
        int id = readInteger("--> ",
            i -> i > 0 && i <= commands.getLast().id);
        Item command = commands.stream().
                filter(it -> it.id == id).findFirst().get();
        return command.method != null && command.method.get();
    }
//----------------------------------------------------------
    public static String readString(String prompt)
        throws EmptyInputException {

        System.out.print(prompt);
        String s = reader.nextLine();

        if (s.isEmpty()) throw new EmptyInputException();

        return s;
    }

    public static Integer readInteger(String prompt, Predicate<Integer> correct)
        throws EmptyInputException {

        int value = 0;
        boolean isValid;

        try {
            value = Integer.parseInt(readString(prompt));
            isValid = correct.test(value);
        }
        catch (NumberFormatException e) {
            isValid = false;
        }

        if (!isValid) System.out.println("Value Error!");

        return  isValid ? value : readInteger(prompt, correct);
    }

    public static LocalDate readLocalDate(String prompt)
            throws EmptyInputException {

        System.out.println(prompt);
        int day = readInteger("Enter day: ", d -> d > 0 && d <= 31);
        int month = readInteger("Enter month: ", m -> m > 0 && m <= 12);
        int year = readInteger("Enter year: ", y -> y > 1900 && y <= LocalDate.now().getYear());
        return new LocalDate(year, month, day);
    }
//----------------------------------------------------------
    public static String readUpdateString(String prompt, String oldValue) {
        System.out.printf("%s (%s): ", prompt, oldValue);
        String s = reader.nextLine();

        return s.isEmpty() ? oldValue : s;
    }

    public static Integer readUpdateInteger(String prompt, Integer oldValue,
        Predicate<Integer> correct) {

        int value = 0;
        boolean isValid;

        try {
            value = Integer.parseInt(readUpdateString(prompt, oldValue.toString()));
            isValid = correct.test(value);
        }
        catch (NumberFormatException e) {
            isValid = false;
        }

        if (!isValid) System.out.println("Value Error!");

        return  isValid ? value : readUpdateInteger(prompt, oldValue, correct);
    }

    public static LocalDate readUpdateLocalDate(String prompt, LocalDate oldValue)
            throws EmptyInputException {

        System.out.println(prompt);
        int day = readUpdateInteger("Enter day: ",
            oldValue.getDayOfMonth(), d -> d > 0 && d <= 31);
        int month = readUpdateInteger("Enter month: ",
                oldValue.getMonthOfYear(), m -> m > 0 && m <= 12);
        int year = readUpdateInteger("Enter year: ",
                oldValue.getYear(), y -> y > 1900 && y <= LocalDate.now().getYear());
        return new LocalDate(year, month, day);
    }
//----------------------------------------------------------
    public static <T> void printList(List<T> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("Not found");
            return;
        }

        list.forEach(System.out::println);
    }

    public static <T> void printList(List<T> list, String title) {
        if (!(title.isBlank() || list.isEmpty())) {
            System.out.println(title);
        }
        printList(list);
    }
//----------------------------------------------------------
    public static <T> T find(ItemList<T> itemList)
            throws EmptyInputException, NotFoundException {
        T item = itemList.find(readInteger("Enter Id: ", i -> i > 0));
        if (item == null) throw new NotFoundException();
        return item;
    }

    public static <T> T findHard(ItemList<T> itemList, String prompt)
            throws EmptyInputException {
        T item = itemList.find(readInteger(prompt, i -> i > 0));
        while (item == null) {
            System.out.println("Id Error!");
            item = itemList.find(readInteger(prompt, i -> i > 0));
        }
        return item;
    }
//----------------------------------------------------------
}
