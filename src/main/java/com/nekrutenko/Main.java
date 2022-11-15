package com.nekrutenko;

import com.nekrutenko.model.Car;
import com.nekrutenko.model.Engine;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.service.CarService;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());

        Car firstCar = carService.create();
        carService.printAll();

        System.out.println(carService.find(firstCar.getId()));

        carService.create(3);
        carService.printAll();

        carService.delete(firstCar.getId());
        carService.printAll();

        Car[] all = carService.getAll();
        Car car = all[0];
        carService.changeRandomColor(car.getId());
        System.out.println(carService.find(car.getId()));

        Car secondCar = carService.createFirstExercise();
        Car thirdCar = carService.createFirstExercise();
        carService.print(secondCar);
        carService.print(thirdCar);
        CarService.check(secondCar);
        CarService.check(thirdCar);

    }
}
