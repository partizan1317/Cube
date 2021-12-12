package com.epam.cube.logic;

public interface Observer<T> {

    void update(T event);
}
