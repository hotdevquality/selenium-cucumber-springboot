package com.hotdevquality.test.palindrome;

import java.util.Scanner;

public class PalindromeUsingStringBuilder {
    public static void main(String[] args) {
        System.out.print("Enter any string : ");
        Scanner in = new Scanner(System.in);

        //Original string
        String origString = in.nextLine();

        //Reverse string
        String reverseString = new StringBuilder(origString).reverse().toString();

        // Check palindrome string
        if (origString.equals(reverseString)) {
            System.out.println("String is a palindrome.");
        } else {
            System.out.println("String is not a palindrome.");
        }
    }
}
