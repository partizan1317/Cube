package com.epam.cube.repository;

import com.epam.cube.entity.CubeObservable;

import java.util.Comparator;
import java.util.List;

public interface CubeRepository {

    void add(CubeObservable cubeObservable);

    void delete(CubeObservable cubeObservable);

    void update(CubeObservable cubeObservable);

    List<CubeObservable> query(CubeSpecification cubeSpecification);

    List<CubeObservable> sort(Comparator<CubeObservable> comparator);
}
