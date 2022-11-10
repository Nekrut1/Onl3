package com.nekrutenko.service;

import com.nekrutenko.model.Car;

import java.util.Random;

public class CarService {
    public Car create() {
        return new Car(getRandomString(), getRandomString(), getRandomString());
    }
    public  void print(Car car) {
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
}
