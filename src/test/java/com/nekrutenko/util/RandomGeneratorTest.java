package com.nekrutenko.util;

import com.nekrutenko.model.Color;
import com.nekrutenko.repository.CarArrayRepository;
import com.nekrutenko.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {
    private RandomGenerator target;
    private int numberCars;

    @BeforeEach
    void setUp() {
        target = new RandomGenerator();
    }

    @Test
    void getRandomNumber() {
        Assertions.assertDoesNotThrow(() -> target.randomNumber());
    }

    @Test
    void getRandomNumberNull() {
        numberCars = target.randomNumber();
        assertNotNull(numberCars);
    }

    @Test
    void getRandomNumberWrongMinus() {
        numberCars = target.randomNumber();
        boolean incorrect = numberCars < 0;
        assertFalse(incorrect);
    }

    @Test
    void getRandomNumberWrongPlus() {
        numberCars = target.randomNumber();
        boolean Incorrect = numberCars > 10;
        assertFalse(Incorrect);
    }

    @Test
    void getRandomNumberWrongMinusNegative() {
        numberCars = target.randomNumber();
        boolean Incorrect = numberCars < 0;
        assertTrue(Incorrect);
    }

    @Test
    void getRandomNumberWrongPlusNegative() {
        numberCars = target.randomNumber();
        boolean Incorrect = numberCars > 10;
        assertTrue(Incorrect);
    }

    @Test
    void getRandomString() {
        String actual = target.getRandomString();
        Assertions.assertNotNull(actual);
    }



}