package com.nekrutenko.util;

import com.nekrutenko.model.Car;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.service.CarService;

public class AlgorithmUtil {

    public Car[] bubbleSort(Car[] cars) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < cars.length - 1; i++) {
                Car firstCar = cars[i];
                Car secondCar = cars[i + 1];
                if ((cars[i].getId().compareTo(cars[i + 1].getId())) > 0) {
                    Car temp = firstCar;
                    firstCar = secondCar;
                    secondCar = temp;
                    flag = true;
                }
                cars[i] = firstCar;
                cars[i + 1] = secondCar;
            }
        }
        return cars;
    }

    public int binarySearch(Car[] cars, Car car, int firstElement, int lastElement) {
        int middle = firstElement + (lastElement - firstElement) / 2;
        int compare = car.getId().compareTo(cars[middle].getId());
        if (compare == 0) {
            return middle;
        } else if (compare < 0) {
            return binarySearch(cars, car, firstElement, middle - 1);
        } else {
            return binarySearch(cars, car, middle + 1, lastElement);
        }
    }

}