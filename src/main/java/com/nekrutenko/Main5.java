package com.nekrutenko;

import java.util.Arrays;
import java.util.Random;

public class Main5 {
    public static void main(String[] args) {
        maxElement();
        System.out.println("---------------");
        indexChange();
        System.out.println("---------------");
        growingArray();
        System.out.println("---------------");
        compareArrays();
        System.out.println("---------------");
        bubbleSort();
    }
    //Ex.1
    private static void maxElement() {
        int[] numbers = new int[12];
        int max = 0;
        int maxIindex = 0;
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-15, 15);
            if (max <= numbers[i]) {
                max = numbers[i];
                maxIindex = i;
            }
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("Max number is : " + max + ", index of max number is : " + maxIindex );
    }
    //Ex.2
    private static void indexChange() {
        int[] numbers = new int[8];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1, 10);
        }
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 1) {
                numbers[i] = 0;
            }
        }
        System.out.println("Changed array : ");
        System.out.println(Arrays.toString(numbers));
    }
    //Ex.3
    private static void growingArray() {
        int[] numbers = new int[4];
        Random random = new Random();
        boolean checking = true;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10, 99);
        }
        System.out.println(Arrays.toString(numbers));
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] <= numbers[i - 1]) {
                checking = false;
                break;
            }
        }
        if (checking) {
            System.out.println("The array is a strictly increasing sequence");
        } else {
            System.out.println("The array isn't a strictly increasing sequence");
        }
    }
    //Ex.4
    private static void compareArrays() {
        int[] numbers1 = new int[5];
        int[] numbers2 = new int[5];
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            numbers1[i] = random.nextInt(0, 5);
            numbers2[i] = random.nextInt(0, 5);
        }
        System.out.println(Arrays.toString(numbers1));
        System.out.println(Arrays.toString(numbers2));

        double averageValue1 = 0;
        double averageValue2 = 0;
        for (int i = 0; i < 5; i++) {
            averageValue1 += numbers1[i];
            averageValue2 += numbers2[i];
        }
        averageValue1 /= 5;
        averageValue2 /= 5;

        if (averageValue1 > averageValue2) {
            System.out.println("Average value of the first array (" + averageValue1 + ") bigger than average value " +
                    "second array (" + averageValue2 + ")");
        } else if (averageValue1 < averageValue2) {
            System.out.println("Average value of the first array (" + averageValue1 + ") less than average value " +
                    "second array (" + averageValue2 + ")");
        } else {
            System.out.println("Average value of arrays are equal (" + averageValue1 + ")");
        }
    }
    //Ex.5
    private static void bubbleSort() {
        final Random random = new Random();
        final int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                int firstNumber = numbers[i];
                int secondNumber = numbers[i + 1];
                if (firstNumber > secondNumber) {
                    int temp = firstNumber;
                    firstNumber = secondNumber;
                    secondNumber = temp;
                    flag = true;
                }
                numbers[i] = firstNumber;
                numbers[i + 1] = secondNumber;
            }
        }
        System.out.println("Buuble sorted array : ");
        System.out.println(Arrays.toString(numbers));
    }
}
