package com.nekrutenko.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;
@Getter
@Setter
public class Car {
    private final String id;
    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;

    public Car() {
        this.id = UUID.randomUUID().toString();
    }
    public Car(Color color) {
        this.color = color;
        this.id = UUID.randomUUID().toString();
    }
    public Car(String manufacturer, Engine engine, Color color, String id) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.id = UUID.randomUUID().toString();
        Random random = new Random();
        this.count = random.nextInt(0,2);
        this.price = random.nextInt(10_000, 100_000);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s",id, color);
    }
}
