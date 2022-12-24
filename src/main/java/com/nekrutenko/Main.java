package com.nekrutenko;

import com.nekrutenko.container.CarList;
import com.nekrutenko.model.Car;
import com.nekrutenko.service.CarService;

public class Main {
    public static void main(String[] args) {

        CarService carService = CarService.getInstance();
        CarList<Car> carList = new CarList<>();
        Car car = carService.createNewRandomCar();
        Car car1 = carService.createNewRandomCar();
        Car car2 = carService.createNewRandomCar();
        Car car3 = carService.createNewRandomCar();
        Car car4 = carService.createNewRandomCar();

        carList.addFirstCar(car);
        carList.addFirstCar(car1);
        carList.addFirstCar(car2);
        carList.addFirstCar(car3);
        carList.printInfo();
        System.out.println("Add Last car: " + car4);
        carList.addLastCar(car4);
        carList.printInfo();
        System.out.println("Insert car by number 3: " + car);
        carList.insertCarByNumber(3, car);
        carList.printInfo();
        System.out.println("Find position by number:" + car2);
        int position = carList.findNumber(car2);
        System.out.println(position);
        System.out.println("Delete car from position " + car);
        carList.deleteByPosition(position + 1);
        carList.printInfo();
        System.out.println("Sum of counts: ");
        System.out.println(carList.sumOfCounts());
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





