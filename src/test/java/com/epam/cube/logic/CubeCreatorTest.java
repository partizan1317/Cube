package com.epam.cube.logic;

import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class CubeCreatorTest {

    private static final String VALID_LINE = "4.0 1.0 2.0 3.0";

    private final CubeCreator cubeCreator = new CubeCreator();

    @Test
    public void testCreateShouldCreateCubeWhenDataIsValid() {
        //given
        Cube expectedCube = new Cube(4.0, new Point(1.0,2.0,3.0));
        //when
        Cube createdCube = cubeCreator.create(VALID_LINE);
        //then
        Assert.assertEquals(expectedCube, createdCube);
    }
}

