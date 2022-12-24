package com.nekrutenko.container;

import com.nekrutenko.model.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Node<T extends Car> {

    protected T car;
    protected Node<T> prev;
    protected Node<T> next;

    public Node(T car) {
        this.car = car;
    }
}
