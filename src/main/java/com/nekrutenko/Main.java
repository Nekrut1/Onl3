package com.nekrutenko;

import com.nekrutenko.model.Car;
import com.nekrutenko.model.Engine;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.service.CarService;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());

        int countCars = carService.create();
        System.out.println(countCars);


    }
}
