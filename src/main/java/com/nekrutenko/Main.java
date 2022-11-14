package com.nekrutenko;

import com.nekrutenko.model.Car;
import com.nekrutenko.service.CarService;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();
        Car firstCar = carService.create();
        Car secondCar = carService.create();
        Car thirdCar = carService.create();

        carService.print(firstCar);
        carService.print(secondCar);
        carService.print(thirdCar);

        CarService.check(firstCar);
        CarService.check(secondCar);
        CarService.check(thirdCar);
    }
}
