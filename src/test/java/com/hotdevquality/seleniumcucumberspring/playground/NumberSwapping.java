package com.hotdevquality.test;

public class NumberSwapping {

    public static void main(String[] args) {
        int x = 100;
        int y = 200;

        //Swapping in steps
        x = x + y;    //x = 100 + 200 = 300
        y = x - y;    //y = 300 - 200 = 100
        x = x - y;    //x = 300 - 100 = 200

        //Verify swapped values
        System.out.println("x = " + x + " and y = " + y);
    }
}
