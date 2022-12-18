package com.nekrutenko;

import com.nekrutenko.container.GreenericContainer;
import com.nekrutenko.model.Car;
import com.nekrutenko.service.CarService;
import com.nekrutenko.util.AlgorithmUtil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        CarService carService = CarService.getInstance();
        GreenericContainer<Car> container = new GreenericContainer<>(carService.createNewRandomCar());

        container.print();
        container.increaseCount();
        container.print();
        container.increaseCount(4.3);
        container.print();

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

    }

}



