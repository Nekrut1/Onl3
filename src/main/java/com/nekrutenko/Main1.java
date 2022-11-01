package com.nekrutenko;

import java.util.Random;

public class Main1 {
    public static void main(String[] args) {
        //Ex.1
        int sideAB = (int) ((Math.random() * 10) + 1);
        int sideBC = (int) ((Math.random() * 10) + 1);
        int sideAC = (int) ((Math.random() * 10) + 1);


        if ((sideAB + sideBC <= sideAC) || (sideAB + sideAC <= sideBC) || (sideBC + sideAC <= sideAB)) {
            System.out.println("A triangle with sides " + sideAB + " " + sideBC + " " + sideAC + " " + "can't be constructed");
        } else {
            double p = ((sideAB + sideBC + sideAC) / 2.0);
            double s = Math.sqrt(p * (p - sideAB) * (p - sideBC) * (p - sideAC));
            System.out.println("Area of triangle is " + s + " and sides are equal: " + sideAB + " " + sideBC + " " + sideAC);
        }
        //Ex.2

        Random random = new Random();
        int first = random.nextInt(100);
        int second = random.nextInt(100);
        int third = random.nextInt(100);
        System.out.println("Three numbers generated: " + first + " " + second + " " + third);


        int min = Math.abs(first) < Math.abs(second) ? Math.abs(first) : Math.abs(second);
        min = Math.abs(min) < Math.abs(third) ? Math.abs(min) : Math.abs(third);
        System.out.println("The lowest number is: " + min);

        //Ex.3

        int randomNumber = random.nextInt();
        if (randomNumber %2 == 0) {
            System.out.println(randomNumber + " : is even number ");
        } else {
            System.out.println(randomNumber + " : is not even number ");
        }

        //Ex.4


        int decimalNumber = random.nextInt();
        String binaryNumber = "1111111111111111111111111111111";
        if (decimalNumber < 0) {
            System.out.println("Number must be positive");
        } else {
            System.out.println("Decimal number " + decimalNumber + " is equal to a binary number " + toBinary(decimalNumber));
        }
    }

    public static String toBinary(int decimalNumber) {
        String binaryNumber = "";
        if (decimalNumber <= 0) {
            return binaryNumber;
        }

        while (decimalNumber != 0) {
            binaryNumber = decimalNumber % 2 + binaryNumber;
            decimalNumber = decimalNumber / 2;
        }
        return binaryNumber;

    }
}
