package com.nekrutenko.container;

import com.nekrutenko.model.Car;
import lombok.Getter;


@Getter
public class CarTree<T extends Car> {
    private final NodeForTree<T> root;

    public CarTree(T car) {
        this.root = new NodeForTree<>(car, null, null);
    }


    public void add(NodeForTree<T> node, T car) {
        if (node == null) {
            node = root;
        }
        if (car.getCount() < node.car.getCount()) {
            if (node.left == null) {
                node.left = new NodeForTree<>(car, null, null);
                return;
            } else {
                add(node.left, car);
            }
        }
        if (car.getCount() > node.car.getCount()) {
            if (node.right == null) {
                node.right = new NodeForTree<T>(car, null, null);
            } else {
                add(node.right, car);
            }
        }
    }

    public void printInfo(NodeForTree<T> startNode) {
        if (startNode != null) {
            printInfo(startNode.left);
            System.out.println(startNode.car);
            printInfo(startNode.right);
        }
    }

    public int sum(NodeForTree<T> startNode) {
        int x;
        int y;
        if (startNode != null) {
            x = startNode.right != null ? sum(startNode.right) : 0;
            y = startNode.left != null ? sum(startNode.left) : 0;
            return x + y + startNode.car.getCount();
        }
        return 0;
    }
}

