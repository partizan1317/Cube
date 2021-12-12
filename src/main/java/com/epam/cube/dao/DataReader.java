package com.epam.cube.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataReader {

    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public DataReader() {
    }

    public List<String> read(String path) throws DataException {
        LOGGER.info("Started reading data from " + path);
        List<String> result = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                result.add(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception e){
            DataException dataException = new DataException(e.getMessage(), e);
            LOGGER.throwing(dataException);
            throw dataException;
        }
        return result;
    }
}
