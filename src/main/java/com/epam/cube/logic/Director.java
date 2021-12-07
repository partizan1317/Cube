package com.epam.cube.logic;

import com.epam.cube.dao.DataException;
import com.epam.cube.dao.DataReader;
import com.epam.cube.entity.Cube;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Director {

    private static final Logger LOGGER = LogManager.getLogger(Director.class);

    private final DataReader reader;
    private final CubeValidator validator;
    private final CubeCreator creator;

    public Director(DataReader reader, CubeValidator validator, CubeCreator creator){
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Cube> read(String path) {
        LOGGER.info("Started reading balls from file: " + path);
        List<Cube> cubes = new ArrayList<>();
        try {
            for(String line: reader.read(path)){
                if (validator.isValidLine(line)){
                    Cube cube = creator.create(line);
                    cubes.add(cube);
                }
            }
        }
        catch (DataException e) {
            LOGGER.error("Caught " + e);
        }
        return cubes;
    }


}
