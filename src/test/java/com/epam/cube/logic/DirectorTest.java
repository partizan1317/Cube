package com.epam.cube.logic;

import com.epam.cube.dao.DataException;
import com.epam.cube.dao.DataReader;
import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectorTest {

    private static final String TEST_PATH = "path";
    private static final String VALID_LINE1 = "1.0 2.0 3.0 4.0";
    private static final String VALID_LINE2 = "2.0 -3.0 4.0 5.0";
    private static final String INVALID_LINE = "1z.0 2.0 3.0 4.0";
    private static final Cube VALID_BALL1 = new Cube(new Point(1,2,3),4);
    private static final Cube VALID_BALL2 = new Cube(new Point(2,-3,4),5);

    @Test
    public void testReadShouldReadLinesWhenLinesAreValid() throws DataException {
        //given
        List<String> actualLines = Arrays.asList(VALID_LINE1, VALID_LINE2);
        DataReader reader = Mockito.mock(DataReader.class);
        Mockito.when(reader.read(TEST_PATH)).thenReturn(actualLines);
        CubeValidator validator = Mockito.mock(CubeValidator.class);
        Mockito.when(validator.isValidLine(VALID_LINE1)).thenReturn(true);
        Mockito.when(validator.isValidLine(VALID_LINE2)).thenReturn(true);
        CubeCreator creator = Mockito.mock(CubeCreator.class);
        Mockito.when(creator.create(VALID_LINE1)).thenReturn(VALID_BALL1);
        Mockito.when(creator.create(VALID_LINE2)).thenReturn(VALID_BALL2);
        Director director = new Director(reader, validator, creator);
        List<Cube> expectedBalls = Arrays.asList(VALID_BALL1, VALID_BALL2);
        //when
        List<Cube> actualBalls = director.read(TEST_PATH);
        //then
        Assert.assertEquals(expectedBalls, actualBalls);
    }

    @Test
    public void testReadShouldReadLinesWhenSomeLinesAreInvalid() throws DataException {
        //given
        List<String> actualLines = Arrays.asList(VALID_LINE1, INVALID_LINE, VALID_LINE2);
        DataReader reader = Mockito.mock(DataReader.class);
        Mockito.when(reader.read(TEST_PATH)).thenReturn(actualLines);
        CubeValidator validator = Mockito.mock(CubeValidator.class);
        Mockito.when(validator.isValidLine(VALID_LINE1)).thenReturn(true);
        Mockito.when(validator.isValidLine(INVALID_LINE)).thenReturn(false);
        Mockito.when(validator.isValidLine(VALID_LINE2)).thenReturn(true);
        CubeCreator creator = Mockito.mock(CubeCreator.class);
        Mockito.when(creator.create(VALID_LINE1)).thenReturn(VALID_BALL1);
        Mockito.when(creator.create(VALID_LINE2)).thenReturn(VALID_BALL2);
        Director director = new Director(reader, validator, creator);
        List<Cube> expectedBalls = Arrays.asList(VALID_BALL1, VALID_BALL2);
        //when
        List<Cube> readBalls = director.read(TEST_PATH);
        //then
        Assert.assertEquals(expectedBalls, readBalls);
    }
}