package com.epam.cube.logic;

import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeCreator {

    private static final Logger LOGGER = LogManager.getLogger(CubeCreator.class);

    private static final String DELIMITER = " ";

    public Cube create(String line) {
        LOGGER.info("Started creating a Cube from string: " + line);
        String [] splitLines = line.split(DELIMITER);
        double xCoordinate = Double.parseDouble(splitLines[0]);
        double yCoordinate = Double.parseDouble(splitLines[1]);
        double zCoordinate = Double.parseDouble(splitLines[2]);
        double cubeLine = Double.parseDouble(splitLines[3]);
        Cube createdCube = new Cube(new Point(xCoordinate, yCoordinate, zCoordinate), cubeLine);
        LOGGER.info("A Cube from string '" + line + "' is " + createdCube);
        return createdCube;
    }
}
