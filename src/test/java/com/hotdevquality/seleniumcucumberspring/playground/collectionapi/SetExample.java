package com.hotdevquality.seleniumcucumberspring.playground.collectionapi;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {

        // creating HashSet implementation using Set interface
        Set<String> veg = new HashSet<>();

        // Adding element to the Set
        veg.add("Ginger");
        veg.add("Garlic");
        veg.add("Onion");
        veg.add("Ginger");

        // print element in a Set does not required loop implementation
        System.out.println(veg);
    }
}
