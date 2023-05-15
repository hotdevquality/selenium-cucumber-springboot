package com.hotdevquality.test;

public class ReverseCharAndWordPositionRemain {
    /*
    Example:
    Original string : how to do in java
    Reversed string : woh ot od ni avaj
     */
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Original string : ");
//
//        String originalStr = scanner.nextLine();
//        scanner.close();

        String originalStr = "how to do in java";

        String words[] = originalStr.split("\\s");
        String reversedString = "";

        for (int i = 0; i < words.length; i++)
        {
            String word = words[i];
            String reverseWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            reversedString = reversedString + reverseWord + " ";
        }

        // Displaying the string after reverse
        System.out.print("Reversed string : " + reversedString);
    }



}
