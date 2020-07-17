package com.miazina.hw8.tasks;

import java.util.Arrays;
import java.util.Random;

public class TaskWithRandom {
    int[] randomNumbers;
    static int countTitles = 0;

    public TaskWithRandom() {
        randomNumbers = new Random()
                .ints(15, -100, 100)
                .toArray();
    }

    public void printResults() {
        printTitle("Generated numbers:");
        printNumbers(randomNumbers);

        printTitle("Minimum number");
        System.out.println(getMin());

        printTitle("Maximum number");
        System.out.println(getMax());

        printTitle("Odd numbers");
        printNumbers(getEvenNumbers());

        printTitle("Numbers increased by 10");
        printNumbers(getIncreasedNumbers(10));
    }

    private void printTitle(String title) {
        countTitles++;

        System.out.printf("\n\n2.%d %s\n", countTitles, title);
        System.out.println("-------");
    }

    private void printNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    private int getMin() {
        return Arrays.stream(randomNumbers)
                .min()
                .orElse(0);
    }

    private int getMax() {
        return Arrays.stream(randomNumbers)
                .max()
                .orElse(0);
    }

    private int[] getEvenNumbers() {
        return Arrays.stream(randomNumbers)
                .filter(x -> x % 2 == 0)
                .toArray();
    }

    private int[] getIncreasedNumbers(int factor) {
        return Arrays.stream(randomNumbers)
                .map(x -> x + factor)
                .toArray();
    }
}
