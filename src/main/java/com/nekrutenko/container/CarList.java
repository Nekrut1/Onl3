package com.nekrutenko.container;

import com.nekrutenko.model.Car;
import lombok.Getter;

import java.util.Iterator;

@Getter
public class CarList<T extends Car> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void addFirstCar(T car) {
        Node<T> newNode = new Node<>(car);
        if (first == null) {
            first = last = newNode;
            first.prev = null;
            last.next = null;
        } else {
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
            first.prev = null;
        }
        size++;
    }

    public void addLastCar(T car) {
        if (last == null) {
            addLastCar(car);
        } else {
            Node<T> newNode = new Node<>(car);
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            last.next = null;
            size++;
        }
    }

    public int findNumber(T car) {
        int ind = 0;
        boolean find = false;
        Node<T> cur = first;
        while (cur.next != null) {
            ind++;
            if (car.getId().equals(cur.getCar().getId())) {
                find = true;
                break;
            }
            cur = cur.next;
        }
        if (!find) {
            ind = -1;
        }
        return ind;
    }

    public void insertCarByNumber(int position, T car) {
        if (position <= 0) {
            addFirstCar(car);
        } else if (position >= size) {
            addLastCar(car);
        } else {
            Node<T> newNode = new Node<>(car);
            Node<T> current = first;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.prev.next = newNode;
            newNode.next = current;
            current.prev = newNode;

            size++;
        }
    }

    public void deleteByPosition(int position) {
        if (size > 0) {
            if (position <= 0) {
                Node<T> newFirst = first.next;
                first.next = null;
                first.prev = null;
                newFirst.prev = null;
                first = newFirst;
            } else if (position >= size) {
                Node<T> newLast = last.prev;
                last.next = null;
                last.prev = null;
                newLast.next = null;
                last = newLast;
            } else {
                Node<T> current = first;
                for (int i = 0; i < position; i++) {
                    current = current.next;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public int sumOfCounts() {
        Node<T> current = first;
        int count = 0;
        while (current.next != null) {
            count += current.getCar().getCount();
            current = current.next;
        }
        return count;
    }

    public void printInfo() {
        Node<T> current = first;
        if (first == null) {
            System.out.println("CarList is empty");
            return;
        }
        System.out.println("Current carlist are: ");
        while (current != null) {
            System.out.println(current.car.toString());
            current = current.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new myIterator<>(this);
    }

    class myIterator<T extends Car> implements Iterator<T> {
        Node<T> current;

        public myIterator(CarList<T> carList) {
            current = carList.first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T car = current.car;
            current = current.next;
            return car;
        }
    }
}

