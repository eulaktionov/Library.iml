package commands;

import library.IdName;
import library.ItemList;

public abstract class ItemListCommands <T> extends Commands {
//----------------------------------------------------------
    public ItemListCommands(String title) {
        super(title);
        add("Print all", this::printAll);
        add("Add item", this::add);
        add("Remove item", this::removeItem);
        add("Update item", this::update);
        add("Print item", this::printItem);
        add("Print names", this::printFoundNames);
        arrangeNumbers();
    }
//----------------------------------------------------------
    public abstract ItemList<T> getMainList();
    public  abstract void addItem() throws EmptyInputException;
    public abstract void updateItem(T item) throws EmptyInputException;
//----------------------------------------------------------
    public Boolean add() {
        try { addItem(); }
        catch (Exception ignore) {}
        return true;
    }

    public  Boolean update() {
        try {
            T item = findHard(getMainList(), "Enter Id: ");
            updateItem(item);
        } catch (Exception ignored) {}
        return true;
    }

    public Boolean removeItem() {
        try {
            getMainList().remove(findHard(getMainList(), "Enter Id: "));
        }
        catch (Exception ignore) {}
        return true;
    }

    public Boolean printItem() {
        try {
            System.out.println(findHard(getMainList(), "Enter Id: "));
        }
        catch (Exception ignored) {}
        return true;
    }
    //----------------------------------------------------------
    public Boolean printAll() {
        getMainList().println();
        return true;
    }

    public  Boolean printFoundNames() {
        try {
            getMainList().find(readString("Enter name or part: ")).println();
        }
        catch (Exception ignored) {}
        return true;
    }

    public Integer updateId(IdName item, String prompt) {
        return readUpdateInteger(prompt, item.getId(),
            i -> getMainList().getList().stream().
            anyMatch(x -> ((IdName)x).getId().equals(i)));
    }
//----------------------------------------------------------
}
