package com.nekrutenko.container;

import com.nekrutenko.model.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodeForTree<T extends Car> {
    T car;
    NodeForTree<T> left;
    NodeForTree<T> right;

    public NodeForTree(T car, NodeForTree<T> left, NodeForTree<T> right) {
        this.car = car;
        this.left = left;
        this.right = right;
    }
}
