package com.nekrutenko.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerCar extends Car implements CountRestore {
    private int passengerCount;

    public PassengerCar() {
    }

    public PassengerCar(String manufacturer, Engine engine, Color color, TypeCar type) {
        super(manufacturer, engine, color, type);
        this.passengerCount = passengerCount;
    }

    @Override
    public void restore() {
        setCount(100);
        System.out.println("Changed count is : " + getCount());
    }
}
