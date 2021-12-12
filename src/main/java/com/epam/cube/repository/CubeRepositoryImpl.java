package com.epam.cube.repository;

import com.epam.cube.entity.CubeObservable;

import java.util.*;

public class CubeRepositoryImpl implements CubeRepository {

    Map<Integer,CubeObservable> cubes = new HashMap<>();

    @Override
    public void add(CubeObservable cubeObservable) {
        cubes.put(cubeObservable.getId(),cubeObservable);
    }

    @Override
    public void delete(CubeObservable cubeObservable) {
        cubes.remove(cubeObservable.getId());
    }

    @Override
    public void update(CubeObservable cubeObservable) {
        cubes.put(cubeObservable.getId(), cubeObservable);
    }

    @Override
    public List<CubeObservable> query(CubeSpecification cubeSpecification) {
        List<CubeObservable> result = new ArrayList<>();
        for (CubeObservable cube : cubes.values()) {
            if (cubeSpecification.specified(cube)) {
                result.add(cube);
            }
        }
        return result;
    }

    @Override
    public List<CubeObservable> sort(Comparator<CubeObservable> comparator) {
        List<CubeObservable> result = new ArrayList<>(cubes.values());
        result.sort(comparator);
        return result;
    }
}
