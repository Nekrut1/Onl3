package com.nekrutenko.container;

import com.nekrutenko.model.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class GreenericContainer<T extends Car> {
    private T car;
    private Random random = new Random();

    public GreenericContainer(T car) {
        this.car = car;
    }


    public void print() {
        System.out.println(car);
    }

    public void increaseCount() {
        int countIncrease = getRandom().nextInt(100, 300);
        car.setCount(car.getCount() + countIncrease);
    }

    public <V extends Number> void increaseCount(V number) {
        int countIncrease = car.getCount() + number.intValue();
        car.setCount(countIncrease);
    }
}