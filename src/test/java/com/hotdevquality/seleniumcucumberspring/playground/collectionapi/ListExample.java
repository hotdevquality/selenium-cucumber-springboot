package com.hotdevquality.seleniumcucumberspring.playground.collectionapi;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // Create list
        List<String> names = new ArrayList<>();

        // Adding element to the list
        names.add("Emma");
        names.add("Adele");
        names.add("Aria");
        names.add("Ally");

        // loop and print all element in the List
        for (String name : names) {
            System.out.println(name);
        }

    }
}
