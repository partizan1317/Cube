package com.epam.cube.repository;

import com.epam.cube.entity.CubeObservable;

public class IdCubeSpecification implements CubeSpecification {

    private final Integer id;

    public IdCubeSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(CubeObservable cubeObservable) {
        return cubeObservable.getId().equals(id);
    }
}
