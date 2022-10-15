package homework4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TelephoneBook telephoneBook = new TelephoneBook();
        List<String> nameList = new ArrayList<>(Arrays.asList(
                "Pupa", "Lupa",
                "Skoopa", "Droopa",
                "Koopa", "Umpa",
                "Loompa", "Doompa",
                "Woompo", "Roompa",
                "Poopa", "Lupa",
                "Skoopa", "Koopa",
                "Koopa", "Umpa",
                "Loompa", "Doompa",
                "Doompa", "Roompa"
        ));

        HashMap<String, Integer> nameListMap = new HashMap<>();
        for (String name : nameList) {
            nameListMap.put(name, (nameListMap.get(name) == null) ? 1 : nameListMap.get(name) + 1);
        }
        System.out.println(nameListMap);

        telephoneBook.add("Max", "1");
        telephoneBook.add("Max", "2");
        telephoneBook.add("Max", "3");
        telephoneBook.add("David", "3");
        telephoneBook.add("Chloe", "131241");

        telephoneBook.get("Chloe");


    }
}
