package com.nekrutenko;

import com.nekrutenko.model.Car;
import com.nekrutenko.service.CarService;
import com.nekrutenko.util.AlgorithmUtil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
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

        AlgorithmUtil algorithmUtil = new AlgorithmUtil();
        CarService carService = CarService.getInstance();
        carService.create(5);
        carService.printAll();
        Car[] sort = algorithmUtil.bubbleSort(carService.getAll());
        System.out.println("Sorted cars: " + Arrays.toString(sort));

        int findIndex = algorithmUtil.binarySearch(sort, sort[3], 0, sort.length);
        System.out.println("Index is : " + findIndex);

    }

}



