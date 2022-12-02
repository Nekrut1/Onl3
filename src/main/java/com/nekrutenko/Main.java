package com.nekrutenko;

import com.nekrutenko.model.PassengerCar;
import com.nekrutenko.model.Truck;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.service.CarService;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());

        PassengerCar passengerCar = carService.createPassengerCar();
        Truck truck = carService.createTruck();

        passengerCar.restore();
        truck.restore();

       int countCars = carService.create();
       System.out.println(countCars);


    }
}
