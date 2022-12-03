package com.nekrutenko.service;

import com.nekrutenko.model.Car;
import com.nekrutenko.model.TypeCar;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.util.RandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarServiceTest {

    private CarService target;
    private CarArrayRepository repository;
    private RandomGenerator randomGenerator;
    private Car car;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(CarArrayRepository.class);
        target = new CarService(repository);
        randomGenerator = Mockito.mock(RandomGenerator.class);

    }

    @Test
    void createTest() {
        Assertions.assertDoesNotThrow(() -> target.create());
    }

   /* @Test
    void createZero() {
        int expected = 0;
        Mockito.when(randomGenerator.randomNumber()).thenReturn(0);
        Assertions.assertEquals(0, target.createCar());
    }
    */


    @Test
    void createRandom() {
        int expected = 5;
        Mockito.when(randomGenerator.randomNumber()).thenReturn(5);
        int actual = randomGenerator.randomNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createRandomIncorrect() {
        int expected = -1;
        Mockito.when(randomGenerator.randomNumber()).thenReturn(-1);
        int actual = randomGenerator.randomNumber();
        Assertions.assertEquals(expected, actual);
    }
   /* @Test
    void createCar() {
        Car car = target.createCar();
        Assertions.assertNotNull(car);
        Assertions.assertNotNull(car.getId());
    }*/

    @Test
    void printAll() {
        Assertions.assertDoesNotThrow(() -> target.printAll());
    }

    @Test
    void printAllNotNull() {
        Car car = new Car();
        Assertions.assertNotNull(car);
    }

    @Test
    void print() {
        Assertions.assertDoesNotThrow(() -> target.print(car));
    }

    @Test
    void printNotNull() {
        Car car = new Car();
        Assertions.assertNotNull(car);
    }

    @Test
    void getAll() {
        Assertions.assertDoesNotThrow(() -> target.getAll());
    }

    @Test
    void getAllNotNull() {
        Car car = new Car();
        Assertions.assertNotNull(car);
    }

    @Test
    void findIdIncorrectNullId() {
        String id = null;
        Car car = target.find(id);
        Assertions.assertNull(car);
    }

    @Test
    void findIdIncorrectEmptyId() {
        String id = "";
        Car car = target.find(id);
        Assertions.assertNull(car);
    }

    @Test
    void findNotFound() {
        String id = "123";
        Mockito.when(repository.getById("123")).thenReturn(null);

        Car car = target.find(id);
        Assertions.assertNull(car);

    }

    @Test
    void find() {
        Car expected = new Car();
        String id = "123";
        Mockito.when(repository.getById("123")).thenReturn(expected);
        Car actual = target.find(id);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteNullId() {
        target.delete(null);
        Assertions.assertNull(car);
    }

    @Test
    void deleteEmptyId() {
        String id = "";
        target.delete(id);
        Assertions.assertNull(car);
    }

    @Test
    void deleteIdNotFound() {
        String id = "123";
        Mockito.when(repository.getById("123")).thenReturn(null);
        target.delete(id);
        Assertions.assertNull(car);
    }

    @Test
    void changeRandomColor() {
        String id = "123";
        Assertions.assertDoesNotThrow(() -> target.changeRandomColor(id));
    }

    @Test
    void changeRandomColorIncorrectIdNull() {
        String id = null;
        Assertions.assertDoesNotThrow(() -> target.changeRandomColor(id));
    }

    @Test
    void checkNotThrow() {
        Assertions.assertDoesNotThrow(() -> target.check(target.createCar(TypeCar.CAR)));
    }

    @Test
    void checkInputNull() {
        Assertions.assertDoesNotThrow(() -> CarService.check(null));
    }







}
