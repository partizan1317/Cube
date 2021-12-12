package com.epam.cube.logic;

import java.util.regex.Pattern;

public class CubeValidator {

    private static final String CUBE_LINE_REGEX = "\\d+\\.\\d+( (-)?\\d+\\.\\d+){3}";

    public boolean isValidLine(String line){
        return Pattern.matches(CUBE_LINE_REGEX, line);
    }
}
