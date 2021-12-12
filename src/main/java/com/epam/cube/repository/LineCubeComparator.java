package com.epam.cube.repository;

import com.epam.cube.entity.CubeObservable;

import java.util.Comparator;

public class LineCubeComparator implements Comparator<CubeObservable> {
    @Override
    public int compare(CubeObservable firstCubeObservable, CubeObservable secondCubeObservable) {
        double firstLine = firstCubeObservable.getLine();
        double secondLine = secondCubeObservable.getLine();
        return Double.compare(firstLine, secondLine);
    }
}
