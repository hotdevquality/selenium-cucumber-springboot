package com.hotdevquality.test;

import java.util.Scanner;

public class CalculateAverageNumber {
    /* pseudo-code
    Step 1 : Start

    Step 2 : sum = 0, i = 0, average = 0, count = 0

    Step 3 : i = i + 2

    Step 4 : sum = sum + i, count = count + 1

    Step 5 : if i <= 10 then go to on step 3, else go to on step 6

    Step 6 : average = sum/count

    Step 7 : Display "average"

    Step 8 : Stop
     */
    public static void main(String[] args) {
        System.out.println("How many numbers do you want to enter?");
        Scanner scanner = new Scanner(System.in);
        //this is number of input values user will provide in console
        int count = scanner.nextInt();

        double[] array = new double[count];
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter input number " + (i + 1) + ": ");
            array[i] = scanner.nextDouble();
        }
        scanner.close();

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }

        //Get the average here
        double average = sum / count;

        System.out.format("The average is: %.2f", average);
    }
}
