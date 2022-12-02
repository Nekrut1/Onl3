package com.nekrutenko.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Truck extends Car implements CountRestore {
    private int loadCapacity;

    public Truck() {
    }

    public Truck(String manufacturer, Engine engine, Color color, TypeCar type) {
        super(manufacturer, engine, color, type);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void restore() {
        setCount(50);
        System.out.println("Changed count is : " + getCount());
    }
}
