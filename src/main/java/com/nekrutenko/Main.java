package com.nekrutenko;

import com.nekrutenko.model.Car;
import com.nekrutenko.model.PassengerCar;
import com.nekrutenko.model.Truck;
import com.nekrutenko.model.TypeCar;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.service.CarService;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());

        Car passengerCar = carService.createPassengerCar();
        Car truck = carService.createTruck();

        passengerCar.restore();
        truck.restore();

        boolean result = carService.carEquals(passengerCar, truck);
        System.out.println(result);

    }
}
