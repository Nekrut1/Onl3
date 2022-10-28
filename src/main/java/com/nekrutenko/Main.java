package com.nekrutenko;

public class Main {
    public static void main(String[] args) {
        String name = "Vladyslav Nekrutenko";
        System.out.println(name);

        System.out.println("-------------------");

        int i = 0;
        int y = 5;
        do { System.out.println(i + " Step," + "value " + y);
            i++;
            y+=2;
        }
        while (i <= 10);

        System.out.println("-------------------");

            for (int j = 0; j <= 10; j++) {
                if (j == 3) {
                    continue;
                }
                if (j == 6) {
                    break;
                }
                System.out.println(j + " Step");

            }

        }
    }

