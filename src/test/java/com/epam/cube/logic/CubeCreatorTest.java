package com.epam.cube.logic;

import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class CubeCreatorTest {

    private static final String VALID_LINE = "1.0 2.0 3.0 4.0";
    private static final String INVALID_LINE = "1.0 2.0 3.0 -4.0";

    private final CubeCreator creator = new CubeCreator();

    @Test
    public void testCreateShouldCreateCubeWhenDataIsValid() {
        //given
        Cube expectedCube = new Cube(new Point(1.0,2.0,3.0),4.0);
        //when
        Cube createdCube = creator.create(VALID_LINE);
        //then
        Assert.assertEquals(expectedCube, createdCube);
    }

    @Test
    public void testCreateShouldCreateCubeWhenDataIsInvalid() {
        //given
        Cube expectedCube = new Cube(new Point(1.0,2.0,3.0),-4.0);
        //when
        Cube createdCube = creator.create(INVALID_LINE);
        //then
        Assert.assertEquals(expectedCube, createdCube);
    }
}