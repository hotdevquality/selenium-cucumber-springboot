package com.hotdevquality.test.palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromeUsingJavaUtilQueue {
    public static void main(String[] args) {
        System.out.print("Enter any string : ");
        Scanner in = new Scanner(System.in);
        String origString = in.nextLine();

        Queue<Character> queue = new LinkedList<>();

        for (int i = origString.length()-1; i >=0; i--) {
            queue.add(origString.charAt(i));
        }

        String reverseString = "";

        //Pop all chars from stack one by one and build reverse string
        while (!queue.isEmpty()) {
            reverseString = reverseString + queue.remove();
        }

        //Check palindrome string
        if (origString.equals(reverseString)) {
            System.out.println("String is a palindrome.");
        } else {
            System.out.println("String is not a palindrome.");
        }
    }
}
