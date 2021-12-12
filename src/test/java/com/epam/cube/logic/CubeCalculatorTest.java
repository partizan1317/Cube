package com.epam.cube.logic;

import com.epam.cube.entity.CoordinatePlane;
import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class CubeCalculatorTest {

    private final CubeCalculator calculator = new CubeCalculator();
    private static final double DELTA = 0.001;

    @Test
    public void testCalculateSurfaceAreaShouldCalculateWhenCubeIsValid() {
        //given
        Cube cube = new Cube(new Point(0,0,0), 3);
        //when
        double surfaceArea = calculator.calculateSurfaceArea(cube);
        //then
        Assert.assertEquals(54, surfaceArea, DELTA);
    }

    @Test
    public void testCalculateVolumeShouldCalculateWhenCubeIsValid() {
        //given
        Cube cube = new Cube(new Point(0,0,0), 3);
        //when
        double volume = calculator.calculateVolume(cube);
        //then
        Assert.assertEquals(27, volume, DELTA);
    }

    @Test
    public void testCalculateTheRatioOfVolumesDividedByCoordinatePlaneShouldCalculateWhenCubeCrossesThePlane() {
        //given
        Cube cube = new Cube(new Point(3, -2, 3), 4);
        double expectedRatio = 0.142857;
        //when
        double actualRatio = calculator.calculateTheRatioOfVolumesDividedByCoordinatePlane(cube, CoordinatePlane.XZ);
        //then
        Assert.assertEquals(expectedRatio, actualRatio, DELTA);
    }

    @Test
    public void testCalculateTheRatioOfVolumesDividedByCoordinatePlaneShouldReturnZeroWhenCubeDoesNotCrossThePlane() {
        //given
        Cube cube = new Cube(new Point(5, 5 , 5), 4);
        //when
        double ratio = calculator.calculateTheRatioOfVolumesDividedByCoordinatePlane(cube, CoordinatePlane.XZ);
        //then
        Assert.assertEquals(0, ratio, DELTA);
    }

    @Test
    public void testIsCrossingTheCoordinatePlaneShouldReturnTrueWhenCubeIsCrossingThePlane() {
        //given
        Cube cube = new Cube(new Point(2,2,2),3);
        //when
        boolean isCrossingPlane = calculator.isCrossingTheCoordinatePlane(cube, CoordinatePlane.XZ);
        //then
        Assert.assertTrue(isCrossingPlane);
    }

    @Test
    public void testIsCrossingTheCoordinatePlaneShouldReturnFalseWhenCubeIsNotCrossingThePlane() {
        //given
        Cube cube = new Cube(new Point(2,2,2),1);
        //when
        boolean isCrossingPlane = calculator.isCrossingTheCoordinatePlane(cube, CoordinatePlane.XY);
        //then
        Assert.assertFalse(isCrossingPlane);
    }

    @Test
    public void testIsAValidBallShouldReturnTrueWhenCubeIsValid() {
        //given
        Cube cube = new Cube(new Point(2,2,2),1);
        //when
        boolean isValid = calculator.isAValidCube(cube);
        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void testIsAValidBallShouldReturnTrueWhenCubeIsInvalid() {
        //given
        Cube cube = new Cube(new Point(2,2,2),0);
        //when
        boolean isValid = calculator.isAValidCube(cube);
        //then
        Assert.assertFalse(isValid);
    }

}
