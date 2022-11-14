package com.nekrutenko.service;

import com.nekrutenko.model.Car;
import com.nekrutenko.model.Color;
import com.nekrutenko.model.Engine;

import java.util.Random;

public class CarService {
    private final Random random = new Random();

    public Car create() {
        return new Car(getRandomString(), new Engine(), getRandomColor());
    }
    public void print(Car car) {
        System.out.printf("{Manufacturer: %s; Engine: %s; Color: %s; Count: %d, Price: %d$}%n",
                car.getManufacturer(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
    }
    private String getRandomString() {
        int lenght = 8;
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < lenght; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            builder.append(randomChar);
        }
        return builder.toString();
    }

    private Color getRandomColor() {
        Color[] values = Color.values();
        int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    public static void check(Car car) {
        if(car.getCount() > 0 && car.getEngine().getPower() > 200) {
            System.out.println("Car is ready to sell");
        } else if (car.getCount() < 1 && car.getEngine().getPower() <= 200) {
            System.out.println("They isn't any car and less power, than we need");
        } else if (car.getCount() < 1) {
            System.out.println("No car");
        } else if (car.getEngine().getPower() <= 200) {
            System.out.println("Power less, than 200");
        }
    }
}
