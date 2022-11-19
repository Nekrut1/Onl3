package com.nekrutenko.model;

import java.util.Random;
import java.util.UUID;

public class Car {
    private final String id;
    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;


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
    public String getId() {
        return id;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s",id, color);
    }
}
