package com.nekrutenko.action;

import com.nekrutenko.service.CarService;

import java.io.IOException;

public interface Action {
    CarService CAR_SERVICE = CarService.getInstance();

    void execute();
}
