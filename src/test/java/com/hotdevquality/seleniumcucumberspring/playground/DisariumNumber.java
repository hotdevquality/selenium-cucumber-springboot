package com.hotdevquality.test;

public class DisariumNumber {
    /* For example, consider following numbers.
    11 + 32 + 53 = 1 + 9 + 125 = 135

    81 + 92 = 8 + 81 = 89

    11 + 72 + 53 = 1 + 49 + 125 = 175

    51 + 12 + 83 = 5 + 1 + 512 = 518
     */
    public static void main(String[] args) {
        System.out.println("134 is disarium number " + isDisarium(134));
        System.out.println("135 is disarium number " + isDisarium(135));
        System.out.println("136 is disarium number " + isDisarium(136));
    }

    static boolean isDisarium(int originalNumber)
    {
        //Total number of digits
        int numberOfDigits = Integer.toString(originalNumber).length();

        int sumOfDigits = 0; // Initialize sum of terms
        int tempNum = originalNumber;
        while (tempNum!=0)
        {
            // Get the rightmost digit
            int currentDigit = tempNum % 10;

            // powering according to the positions and adding to sumOfDigits
            sumOfDigits = (int) (sumOfDigits + Math.pow(currentDigit, numberOfDigits--));
            tempNum = tempNum/10;
        }

        // If sum is same as number, then number is
        return (sumOfDigits == originalNumber);
    }
}
