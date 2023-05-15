package com.hotdevquality.seleniumcucumberspring.playground.collectionapi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedListTest {

    public static void main(String[] args) {

        // create ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Tim");
        arrayList.add("Vijay");
        arrayList.add("Tim");
        arrayList.add("Ajay");

        // create LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("James");
        linkedList.add("Serena");
        linkedList.add("Swati");
        linkedList.add("Junaid");

        System.out.println("ArrayList: " +  arrayList);
        System.out.println("LinkedList: " + linkedList);
    }
}
