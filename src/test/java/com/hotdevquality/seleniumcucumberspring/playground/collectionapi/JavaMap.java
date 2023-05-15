package com.hotdevquality.seleniumcucumberspring.playground.collectionapi;

import java.util.HashMap;
import java.util.Map;

public class JavaMap {
    public static void main(String[] args) {
        // Creating object of Map interface
        Map<Integer, String> map = new HashMap<Integer, String>();

        // Adding Elements using Map
        map.put(100, "Adelade");
        map.put(101, "Vlad");
        map.put(102, "Rahmon");

        for (Map.Entry m : map.entrySet()) {
            System.out.println(
                    m.getKey() +" | "+m.getValue()
            );
        }
    }
}
