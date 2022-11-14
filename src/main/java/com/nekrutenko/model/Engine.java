package com.nekrutenko.model;

import java.util.Random;

public class Engine {
    private final Random random = new Random();
    private int power = random.nextInt(0,1000);
    private String type;

    public Engine() {
    }

    public Engine(int power, String type) {
        this.power = power;
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
