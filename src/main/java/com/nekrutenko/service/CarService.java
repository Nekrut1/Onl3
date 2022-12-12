package com.nekrutenko.service;

import com.nekrutenko.exception.UserInputException;
import com.nekrutenko.model.*;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.util.RandomGenerator;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class CarService {
    private final CarArrayRepository carArrayRepository;
    private final Random random = new Random();
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private TypeCar type;

    public CarService(CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }


    public void printManufacturerAndCount(Car car) {
        Optional<Car> carOptional = Optional.ofNullable(car);
        carOptional.ifPresent(x -> {
            System.out.printf("Manufacturer: %s, count = %d%n", x.getManufacturer(), x.getCount());
        });
    }

    public void printColor(Car car) {
        Optional<Car> carOptional = Optional.ofNullable(car);
        Car carNew = carOptional.orElse(createCar(TypeCar.CAR));
        System.out.println("Color is: " + carNew.getColor());
    }

    public void checkCount(Car car) throws UserInputException {
        Optional<Car> carOptional = Optional.ofNullable(car);
        Car filterCar = carOptional.filter(x -> {
            return x.getCount() > 10;
        }).orElseThrow(UserInputException::new);
        System.out.printf("Manufacturer: %s, count = %d%n", filterCar.getManufacturer(), filterCar.getCount());
    }

    public void printEngineInfo(Car car) {
        Optional<Car> carOptional = Optional.ofNullable(Optional.ofNullable(car).orElseGet(() -> {
            System.out.println("New random car was created");
            return createNewRandomCar();
        }));
        carOptional.map(engine -> {
            return engine.getEngine().getPower();
        }).ifPresent(power -> System.out.println("Engine power : " + power));
    }

    public void printInfo(Car car) {
        Optional<Car> carOptional = Optional.ofNullable(car);
        carOptional.ifPresentOrElse(x -> print(x),
                () -> print(createNewRandomCar()));
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

    public Car createCar(TypeCar type) {
        if (type.equals(TypeCar.CAR)) {
            return createPassengerCar();
        } else if (type.equals(TypeCar.TRUCK)) {
            return createTruck();
        }
        throw new IllegalArgumentException();
    }

    public Car createNewRandomCar() {
        return createCar(randomGenerator.getRandomCarType());
    }

    public void create(int count) {
        for (int i = 0; i < count; i++) {
            carArrayRepository.save(createCar(randomGenerator.getRandomCarType()));
        }
    }

    public Car createPassengerCar() {
        Car passengerCar = new PassengerCar(randomGenerator.getRandomString(), new Engine(),
                randomGenerator.getRandomColor(), randomGenerator.getRandomCarType());
        carArrayRepository.save(passengerCar);
        return passengerCar;
    }

    public Car createTruck() {
        Car truck = new Truck(randomGenerator.getRandomString(), new Engine(),
                randomGenerator.getRandomColor(), randomGenerator.getRandomCarType());
        carArrayRepository.save(truck);
        return truck;
    }

    public boolean carEquals(Car firstCar, Car secondCar) {
        if (firstCar.getType().equals(secondCar.getType()) && firstCar.hashCode() == secondCar.hashCode()) {
            return firstCar.equals(secondCar);
        } else {
            return false;
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
