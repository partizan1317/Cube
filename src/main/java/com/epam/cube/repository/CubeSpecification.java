package com.epam.cube.repository;

import com.epam.cube.entity.CubeObservable;

public interface CubeSpecification {

    boolean specified(CubeObservable cubeObservable);
}
