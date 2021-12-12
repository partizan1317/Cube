package com.epam.cube.repository;

import com.epam.cube.entity.CubeObservable;
import com.epam.cube.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CubeRepositoryImplTest {
    private static final CubeObservable BALL1 = new CubeObservable(new Point(1.0, 1.0, 1.0), 1,1);
    private static final CubeObservable BALL2=new CubeObservable(new Point(1.0, 1.0, 1.0), 2,2);

    @Test
    public void testQueryShouldReturnCubeWhenCubeFitsSpecification() {
        //given
        CubeRepositoryImpl ballRepository = new CubeRepositoryImpl();
        ballRepository.add(BALL1);
        CubeSpecification specification = Mockito.mock(CubeSpecification.class);
        Mockito.when(specification.specified(BALL1)).thenReturn(true);
        List<CubeObservable> expectedQuery = Arrays.asList(BALL1);
        //when
        List<CubeObservable> actualQuery = ballRepository.query(specification);
        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testQueryShouldNotReturnCubeWhenCubeDoesNotFitSpecification() {
        //given
        CubeRepositoryImpl ballRepository = new CubeRepositoryImpl();
        ballRepository.add(BALL1);
        CubeSpecification specification = Mockito.mock(CubeSpecification.class);
        Mockito.when(specification.specified(BALL1)).thenReturn(false);
        List<CubeObservable> expectedQuery = new ArrayList<>();
        //when
        List<CubeObservable> actualQuery = ballRepository.query(specification);
        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testSortShouldSortWhenComparatorComparesByLine() {
        //given
        CubeRepositoryImpl ballRepository = new CubeRepositoryImpl();
        ballRepository.add(BALL2);
        ballRepository.add(BALL1);
        Comparator<CubeObservable> comparatorMock=Mockito.mock(Comparator.class);
        Mockito.when(comparatorMock.compare(BALL1, BALL2)).thenReturn(-1);
        List<CubeObservable> expectedSorted = Arrays.asList(BALL1, BALL2);
        //when
        List<CubeObservable> actualSorted = ballRepository.sort(comparatorMock);
        //then
        Assert.assertEquals(expectedSorted, actualSorted);
    }
}
