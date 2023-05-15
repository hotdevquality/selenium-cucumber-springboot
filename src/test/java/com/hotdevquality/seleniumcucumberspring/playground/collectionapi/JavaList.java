package com.hotdevquality.seleniumcucumberspring.playground.collectionapi;

import java.util.ArrayList;
import java.util.List;

public class JavaList {
    public static void main(String[] args) {
        // creating a list
        List<String> fruits = new ArrayList<>();

        // Adding elements in the List
        fruits.add("mango");
        fruits.add("orange");
        fruits.add("grapes");

        for ( String fruit : fruits ) {
            System.out.println(fruit);
        }
    }
}
