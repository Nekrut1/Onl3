package com.nekrutenko;

import com.nekrutenko.container.CarTree;
import com.nekrutenko.model.Car;
import com.nekrutenko.model.Engine;
import com.nekrutenko.service.CarService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        CarService carService = CarService.getInstance();
        Car car = carService.createNewRandomCar();
        Car car1 = carService.createNewRandomCar();
        Car car2 = carService.createNewRandomCar();
        Car car3 = carService.createNewRandomCar();
        Car car4 = carService.createNewRandomCar();

        CarTree<Car> carTree = new CarTree<>(car);
        carTree.add(null, car1);
        carTree.add(null, car2);
        carTree.add(null, car3);
        carTree.add(null, car4);
        carTree.printInfo(carTree.getRoot());
        System.out.println("Sum of counts: " + carTree.sum(carTree.getRoot()));


        List<Car> cars = Arrays.asList(carService.getAll());
        Map<String, Integer> manufacturerMap = carService.getCountFromManufacturer(cars);
        System.out.println("Key is manufacturer and value is a count : " + manufacturerMap);
        Map<Engine, List<Car>> engineListMap = carService.getEngineFromCar(cars);
        System.out.println("Key is engine and value is a car : " + engineListMap);

    }
}


      /* Actions[] values = Actions.values();
        String[] names = mapActionToName(values);

        while (true) {
            final int userChoice = UserInput.menu(names);
            values[userChoice].execute();
        }
    }

    private static String[] mapActionToName(Actions[] values) {
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].getName();
        }
        return names;
    }*/





