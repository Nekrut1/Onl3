package com.nekrutenko.util;

import com.nekrutenko.model.Color;
import com.nekrutenko.model.TypeCar;

import java.util.Random;

public class RandomGenerator {
    private final Random random = new Random();

    public int randomNumber() {
        return random.nextInt(0, 11);
    }

    public Color getRandomColor() {
        Color[] values = Color.values();
        int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    public TypeCar getRandomCarType() {
        TypeCar[] types = TypeCar.values();
        int randomType = random.nextInt(types.length);
        return types[randomType];
    }

    public String getRandomString() {
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
