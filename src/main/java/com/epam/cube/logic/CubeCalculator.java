package com.epam.cube.logic;

import com.epam.cube.entity.Cube;

import java.util.logging.LogManager;

public class CubeCalculator {

    private static final Logger LOGGER = LogManager.getLogger(CubeCreator.class);

    public CubeCalculator() {
    }

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

}
