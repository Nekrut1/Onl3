package com.nekrutenko;

import com.nekrutenko.container.CarTree;
import com.nekrutenko.model.Car;
import com.nekrutenko.model.Color;
import com.nekrutenko.model.Engine;
import com.nekrutenko.model.TypeCar;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.service.CarService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        CarService carService = CarService.getInstance();
        Car car = carService.createNewRandomCar();
        Car car1 = carService.createNewRandomCar();
        Car car2 = carService.createNewRandomCar();
        Car car3 = carService.createNewRandomCar();
        Car car4 = carService.createNewRandomCar();

        List<Car> cars = Arrays.asList(carService.getAll());
        System.out.println("Cars with price more tnan 15000 and they manufacturer:");
        carService.findManufacturerByPrice(cars);

        System.out.println("======".repeat(10));
        carService.countSum(cars);

        System.out.println("======".repeat(10));
        carService.statistic(cars);

        System.out.println("======".repeat(10));
        carService.priceCheck(cars, 12000);

        System.out.println("======".repeat(10));
        carService.mapToMap(cars);

        System.out.println("======".repeat(10));
        List<List<Car>> listsNew = new ArrayList<>();
        listsNew.add(cars);
        Map<Color, Integer> mapNew = carService.innerList(listsNew, 17500);
        System.out.println("======".repeat(10));
        System.out.println("Sorted by price and color: " + mapNew);

        Map<String, Object> map = new HashMap<>();
        map.put("type", TypeCar.CAR);
        map.put("manufacturer", car.getManufacturer());
        map.put("color", Color.GREEN);
        map.put("count", 5);
        map.put("price", 16_000);

        System.out.println("New car by Map:");
        Car carByMap = carService.mapToObject(map);
        carService.print(carByMap);

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





