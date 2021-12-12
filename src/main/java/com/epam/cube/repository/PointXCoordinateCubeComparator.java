package com.epam.cube.repository;

import com.epam.cube.entity.CubeObservable;
import com.epam.cube.entity.Point;

import java.util.Comparator;

public class PointXCoordinateCubeComparator implements Comparator<CubeObservable> {
    @Override
    public int compare(CubeObservable firstCubeObservable, CubeObservable secondCubeObservable) {
        Point firstPoint = firstCubeObservable.getPoint();
        Point secondPoint = secondCubeObservable.getPoint();
        double firstXCoordinate = firstPoint.getXCoordinate();
        double secondXCoordinate = secondPoint.getXCoordinate();
        return Double.compare(firstXCoordinate,secondXCoordinate);
    }
}
