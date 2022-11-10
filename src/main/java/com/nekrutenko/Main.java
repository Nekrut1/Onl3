package com.nekrutenko;

import com.nekrutenko.model.Car;
import com.nekrutenko.service.CarService;

public class Main {
    public static void main(String[] args) {
        Car firstCar = CarService.create();
        Car secondCar = CarService.create();
        Car thirdCar = CarService.create();

        CarService.print(firstCar);
        CarService.print(secondCar);
        CarService.print(thirdCar);
    }
}
