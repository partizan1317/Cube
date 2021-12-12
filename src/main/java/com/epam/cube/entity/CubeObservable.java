package com.epam.cube.entity;

import com.epam.cube.logic.Observable;
import com.epam.cube.logic.Observer;

import java.util.ArrayList;
import java.util.List;

public class CubeObservable extends Cube implements Observable<CubeObservable> {
    private final Integer id;
    private final List<Observer<CubeObservable>> observerList = new ArrayList<>();

    public CubeObservable(Point point, double line, Integer id) {
        super(point,line);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setPoint(Point point) {
        super.setPoint(point);
        notifyObservers();
    }

    @Override
    public void setLine(double line) {
        super.setLine(line);
        notifyObservers();
    }

    @Override
    public void attach(Observer<CubeObservable> observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer<CubeObservable> observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<CubeObservable> observer : observerList) {
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CubeObservable that = (CubeObservable) o;
        return id == that.id && observerList.equals(that.observerList);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + super.hashCode();
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "CubeIdentifiable{" +
                "id=" + id +
                ", observerList=" + observerList +
                '}';
    }
}
