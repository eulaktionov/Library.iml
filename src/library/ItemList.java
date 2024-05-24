package library;

import commands.Commands;

import java.util.ArrayList;
import java.util.List;

public class ItemList<T> {
//----------------------------------------------------------
    private List<T> list;

    public ItemList() { list = new ArrayList<>(); }

    public List<T> getList() { return list; }
    public void setList(List<T> list) { this.list = list; }

    public T get(int index) { return list.get(index); }
    public void set(T item, int index) { list.set(index, item); }

    public void println() { Commands.printList(list); }

    public void add(T item) {
        ((IdName)item).setId(list.isEmpty() ? 1 :
                ((IdName)(list.getLast())).getId() + 1);
        list.add(item);
    }

    public void remove(T item) { list.remove(item); }

    public T find(Integer id) {
        return (T) list.stream().
                filter(it -> ((IdName)it).getId().equals(id)).
                findFirst().orElse(null);
    }

    public ItemList<T> find(String namePart) {
        ItemList<T> result = new ItemList<>();
        result.setList(list.stream().
                filter(it -> ((IdName)it).getName().contains(namePart)).
                toList());
        return result;
    }
//----------------------------------------------------------
}
