package com.epam.cube.logic;

import com.epam.cube.entity.CoordinatePlane;
import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CubeCalculator {

    private static final Logger LOGGER = LogManager.getLogger(CubeCreator.class);

    public double calculateVolume(Cube cube){
        LOGGER.info("Started calculating the volume of the " + cube.toString());
        double result = Math.pow(cube.getLine(),3);
        LOGGER.info("Calculated the volume of " + cube + ": " + result);
        return result;
    }

    public double calculateSurfaceArea(Cube cube){
        LOGGER.info("Started calculating the surface area of the " + cube.toString());
        double result = Math.pow(cube.getLine(),2) * 6;
        LOGGER.info("Calculated the surface area of the " + cube + ": " + result);
        return result;
    }

    public double calculateTheRatioOfVolumesDividedByCoordinatePlane(Cube cube, CoordinatePlane plane){
        LOGGER.info("Started calculating the ratio of volumes of " + cube.toString() + " divided by " +
                plane.toString() + " plane");
        if (!isCrossingTheCoordinatePlane(cube, plane)){
            return 0;
        }
        Point point = cube.getPoint();
        double distanceFromPointToPlane = Math.abs(distanceFromPlane(plane, point));
        double line = cube.getLine();
        double lesserHalfCubeLine = line - distanceFromPointToPlane;
        double lesserHalCubeVolume = Math.pow(lesserHalfCubeLine, 3);
        double ratio = lesserHalCubeVolume / (calculateVolume(cube) - lesserHalCubeVolume);
        LOGGER.info("Calculated the ratio of volumes of " + cube + " divided by " + plane + " plane: " + ratio);
        return ratio;
    }

    private double distanceFromPlane(CoordinatePlane plane, Point point){
        switch(plane){
            case XY:
                return point.getZCoordinate();
            case YZ:
                return point.getXCoordinate();
            case XZ:
                return point.getYCoordinate();
        }
        return 0;
    }

    public boolean isAValidCube(Cube cube) {
        return cube.getLine() > 0;
    }

    public boolean isCrossingTheCoordinatePlane(Cube cube, CoordinatePlane plane) {
        LOGGER.info("Started calculating whether " + cube.toString() + " is crossing the " + plane.toString() + " plane");
        Point point = cube.getPoint();
        double coordinate = distanceFromPlane(plane, point);
        double line = cube.getLine();
        boolean isCrossing = Math.abs(coordinate) <= line;
        LOGGER.info("Calculated whether " + cube + " is crossing the " + plane + " plane: " + isCrossing);
        return isCrossing;
    }

}
