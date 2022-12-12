package com.nekrutenko;

import com.nekrutenko.exception.UserInputException;
import com.nekrutenko.model.Car;
import com.nekrutenko.model.PassengerCar;
import com.nekrutenko.model.Truck;
import com.nekrutenko.model.TypeCar;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.service.CarService;

public class Main {
    public static void main(String[] args) throws UserInputException {
        CarService carService = new CarService(new CarArrayRepository());

        Car passengerCar = carService.createPassengerCar();
        Car truck = carService.createTruck();
        Car car = carService.createNewRandomCar();

        passengerCar.restore();
        truck.restore();

        carService.printManufacturerAndCount(null);
        carService.printManufacturerAndCount(car);

        carService.printColor(null);
        carService.printColor(car);

        car.setCount(11);
        carService.checkCount(car);
        try {
            car.setCount(5);
            carService.checkCount(car);
        } catch (UserInputException e) {
            e.printStackTrace();
            System.out.println("Count is less, than 10");
        }

        carService.printEngineInfo(null);
        carService.printEngineInfo(car);

        carService.printInfo(null);
        carService.printInfo(car);


    }
}
