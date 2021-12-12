package com.epam.cube.repository;

import com.epam.cube.entity.CoordinatePlane;
import com.epam.cube.entity.CubeObservable;
import com.epam.cube.entity.Point;

public class DoesNotCrossPlaneCubeSpecification implements CubeSpecification {

    private final CoordinatePlane plane;

    public DoesNotCrossPlaneCubeSpecification(CoordinatePlane plane){
        this.plane = plane;
    }

    private double distanceFromPlane(CubeObservable cubeObservable){
        Point point = cubeObservable.getPoint();
        switch (plane) {
            case XY:
                return point.getZCoordinate();
            case YZ:
                return point.getXCoordinate();
            case XZ:
                return point.getYCoordinate();
        }
        return 0.0;
    }

    @Override
    public boolean specified(CubeObservable cubeObservable) {
        return distanceFromPlane(cubeObservable) > cubeObservable.getLine();
    }
}
