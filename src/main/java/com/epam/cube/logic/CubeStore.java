package com.epam.cube.logic;

import com.epam.cube.entity.CubeObservable;
import com.epam.cube.entity.Parameters;

import java.util.HashMap;
import java.util.Map;

public class CubeStore implements Observer<CubeObservable> {

    private static CubeStore INSTANCE;

    private final CubeCalculator calculator = new CubeCalculator();

    private final Map<Integer, Parameters> parameters = new HashMap<>();

    @Override
    public void update(CubeObservable cube) {
        double volume = calculator.calculateVolume(cube);
        double surfaceArea = calculator.calculateSurfaceArea(cube);
        parameters.put(cube.getId(),new Parameters(volume,surfaceArea));
    }

    public Parameters get(Object key) {
        return parameters.get(key);
    }

    public static CubeStore getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CubeStore();
        }
        return INSTANCE;
    }
}
