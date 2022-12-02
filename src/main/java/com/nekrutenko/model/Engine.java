package com.nekrutenko.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Engine {
    private final Random random = new Random();
    private int power = random.nextInt(1,1000);
    private String type;

    public Engine() {
    }
    public Engine(int power, String type) {
        this.power = power;
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "power=" + power +
                ", type='" + "auto" + '\'' +
                '}';
    }
}
