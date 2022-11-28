package com.nekrutenko.service;

import com.nekrutenko.model.Car;
import com.nekrutenko.model.Color;
import com.nekrutenko.model.Engine;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.util.RandomGenerator;

import javax.script.CompiledScript;
import java.util.Arrays;
import java.util.Random;

public class CarService {
    private final CarArrayRepository carArrayRepository;
    private final Random random = new Random();
    private final RandomGenerator randomGenerator = new RandomGenerator();

    public CarService(CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }
    public Car createCar() {
        return new Car(randomGenerator.getRandomString(), new Engine(), randomGenerator.getRandomColor(),
                randomGenerator.getRandomString());
    }

    public int create() {
        int count = randomGenerator.randomNumber();
        if (count == 0) {
            return -1;
        } else {
            create(count);
            printAll();
            return count;
        }
    }

    public void create(int count) {
        for (int i = 0; i < count; i++) {
            carArrayRepository.save(createCar());
        }
    }

    public void printAll() {
        Car[] all = carArrayRepository.getAll();
        System.out.println(Arrays.toString(all));
    }

    public Car[] getAll() {
        return carArrayRepository.getAll();
    }

    public Car find(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return carArrayRepository.getById(id);
    }
    public void delete(String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        carArrayRepository.delete(id);
    }

    public void changeRandomColor(String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        Car car = find(id);
        if (car == null) {
            return;
        }
        findAndChangeRandomColor(car);
    }

    private void findAndChangeRandomColor(Car car) {
        Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = randomGenerator.getRandomColor();
        } while (randomColor == color);
        carArrayRepository.updateColor(car.getId(), randomColor);
    }

    public void print(Car car) {
        System.out.printf("{Manufacturer: %s; Engine: %s; Color: %s; Count: %d, Price: %d$}%n",
                car.getManufacturer(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
    }

    public static void check(Car car) {
        if (car.getCount() > 0 && car.getEngine().getPower() > 200) {
            System.out.println("Car is ready to sell");
        } else if (car.getCount() < 1 && car.getEngine().getPower() <= 200) {
            System.out.println("They isn't any car and less power, than we need");
        } else if (car.getCount() < 1) {
            System.out.println("If count < 1 - no car");
        } else if (car.getEngine().getPower() <= 200) {
            System.out.println("Power less, than 200");
        }
    }
}
