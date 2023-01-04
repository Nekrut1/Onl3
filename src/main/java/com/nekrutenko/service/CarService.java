package com.nekrutenko.service;

import com.nekrutenko.exception.UserInputException;
import com.nekrutenko.model.*;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.util.RandomGenerator;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class CarService {
    private final CarArrayRepository carArrayRepository;
    private final Random random = new Random();
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private TypeCar type;
    private static CarService instance;

    public CarService(CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }

    public static CarService getInstance() {
        if (instance == null) {
            instance = new CarService(CarArrayRepository.getInstance());
        }
        return instance;
    }

    public static CarService getInstance(CarArrayRepository repository) {
        if (instance == null) {
            instance = new CarService(repository);
        }
        return instance;
    }

    public void printManufacturerAndCount(Car car) {
        Optional.ofNullable(car).ifPresent(x -> {
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
        Optional.ofNullable(car).ifPresentOrElse(x -> print(x),
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
        System.out.printf("{Id: %s; Engine: %s; Color: %s; Count: %d, Price: %d$}%n",
                car.getId(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
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

    public Map<String, Integer> getCountFromManufacturer(List<Car> cars) {
        Map<String, Integer> map = new HashMap<>();
        for (Car car : cars) {
            String manufacturer = car.getManufacturer();
            map.computeIfPresent(manufacturer, (key, value) -> value + car.getCount());
            map.putIfAbsent(manufacturer, car.getCount());
        }
        return map;
    }

    public Map<Integer, ArrayList<Car>> getEngineFromCar(List<Car> cars) {
        Map<Integer, ArrayList<Car>> map = new HashMap<>();
        for (Car car : cars) {
            map.putIfAbsent(car.getEngine().getPower(), new ArrayList<>());
            map.get(car.getEngine().getPower()).add(car);
        }
        return map;
    }

    public void findManufacturerByPrice(List<Car> cars) {
        cars.stream().
                filter(car -> car.getPrice() > 15_000).
                forEach(car -> System.out.printf("Manufacturer is: %s, and price is: %s%n",
                        car.getManufacturer(), car.getPrice()));
    }

    public void countSum(List<Car> cars) {
        int sum = cars.stream().
                map(Car::getCount)
                .reduce(0, Integer::sum);
        System.out.println("Sum of counting cars is: " + sum);
    }

    public Map<String, TypeCar> mapToMap(List<Car> cars) {
        LinkedHashMap<String, TypeCar> sort = cars.stream()
                .sorted(Comparator.comparing(Car::getManufacturer))
                .distinct()
                .collect(Collectors.toMap(Car::getId, Car::getType, (x, y) -> x, LinkedHashMap::new));
        System.out.println("Sorted cars by manufacturer: " + sort);
        return sort;
    }

    public String statistic(List<Car> cars) {
        String info = cars.stream()
                .mapToInt(Car::getPrice)
                .summaryStatistics()
                .toString();
        System.out.println(info);
        return info;
    }

    public boolean priceCheck(List<Car> cars, int price) {
        boolean result = cars.stream().
                mapToInt(Car::getPrice).
                allMatch((value -> value > price));
        System.out.println(result);
        return result;
    }

    public Map<Color, Integer> innerList(List<List<Car>> listCars, int price) {
        return listCars.stream().
                flatMap(Collection::stream).
                sorted(Comparator.comparing(Car::getColor)).
                distinct().
                peek(System.out::println).
                filter(v -> v.getPrice() > price).
                collect(Collectors.toMap(Car::getColor, Car::getCount, (x, y) -> x, LinkedHashMap::new));

    }

    public Car mapToObject(Map<String, Object> objectMap) {
        Function<Map<String, Object>, Car> function = (mapper -> {
            if (mapper.get("type") == TypeCar.CAR) {
                return new PassengerCar();
            } else if (mapper.get("type") == TypeCar.TRUCK) {
                return new Truck();
            } else {
                throw new NullPointerException("Type of car not exist");
            }

        });

        return function.andThen(x -> {
                    x.setManufacturer((String) objectMap.get("manufacturer"));
                    x.setColor((Color) objectMap.get("color"));
                    x.setCount((int) objectMap.get("count"));
                    x.setPrice((int) objectMap.get("price"));
                    return x;
                })
                .apply(objectMap);
    }

}
