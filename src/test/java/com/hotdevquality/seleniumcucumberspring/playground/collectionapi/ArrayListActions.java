package com.hotdevquality.seleniumcucumberspring.playground.collectionapi;

import java.util.ArrayList;

public class ArrayListActions {
    public static void main(String[] args) {

        // Different ways of constructing an ArrayList
        ArrayList<Integer> list1 = new ArrayList<Integer>(); // first method
        ArrayList<String> list2 = new ArrayList<String>(20); // second method
        ArrayList<Integer> list3 = new ArrayList<Integer>(list1); // third method

        // How to increase the current capacity of an ArrayList?
        ArrayList<String> list = new ArrayList<String>(); //now list can hold 10 elements (Default)

        for (String l : list) {
            System.out.println(l);
        }
        list.ensureCapacity(20);

        // How to decrease the current capacity of an ArrayList to the current size
        // Can reduce the current capacity to current size of an ArrayList
        list.trimToSize();
        System.out.println(list.isEmpty());
        // check given element is present in ArrayList
        list.contains("expectedValue");



    }
}
