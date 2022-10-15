package homework4;

import java.util.*;
import java.util.function.BiConsumer;

public class TelephoneBook {

    HashMap<String, List<String>> telephoneBook = new HashMap<>();
    List<String> telephoneNumber = new ArrayList<>();

    public void add(String name, String telephone) {

        if (telephoneBook.containsKey(name)) {
            telephoneBook.get(name).add(telephone);
        } else {
            telephoneBook.put(name, new ArrayList<>());
            telephoneBook.get(name).add(telephone);
        }

    }

    public void get(String name) {
        if (telephoneBook.containsKey(name)) {
            System.out.printf("Name: %s | tel.number: %s", name, telephoneBook.get(name));
        } else {
            System.out.println("Error, there is no such name in this book. Make sure that input is correct");
        }

    }

}
