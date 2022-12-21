package com.nekrutenko.repository;

public interface GenericImpl<T> {
    void save(T car);
    T[] getAll();
    T getById(String id);
    void delete(String id);


}
