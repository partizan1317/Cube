package com.epam.cube.logic;

import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;
import sun.rmi.runtime.Log;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CubeCreator {

    private static final Logger LOGGER = LogManager.getLogger(CubeCreator.class);

    private static final String DELIMITER = " ";

    public  CubeCreator() {
    }

    public Cube create(String line) {
        LOGGER.info("Started creating a Cube from string: " + line);
        String [] splitLines = line.split(DELIMITER);
        double cubeLine = Double.parseDouble(splitLines[0]);
        double xCoordinate = Double.parseDouble(splitLines[1]);
        double yCoordinate = Double.parseDouble(splitLines[2]);
        double zCoordinate = Double.parseDouble(splitLines[3]);
        Cube createdCube = new Cube(cubeLine, new Point(xCoordinate, yCoordinate, zCoordinate));
        LOGGER.info("A Cube from string '" + line + "' is " + createdCube);
        return createdCube;
    }
}
