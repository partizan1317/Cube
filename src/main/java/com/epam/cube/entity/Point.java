package com.epam.cube.entity;

public final class Point {

    private final double xCoordinate;
    private final double yCoordinate;
    private final double zCoordinate;

    public Point(){
        this.xCoordinate = 0;
        this.yCoordinate = 0;
        this.zCoordinate = 0;
    }

    public Point(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public double getZCoordinate() {
        return zCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Double.compare(point.xCoordinate, xCoordinate) == 0 && Double.compare(point.yCoordinate, yCoordinate) == 0
                && Double.compare(point.zCoordinate, zCoordinate) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int) xCoordinate;
        result = 31 * result + (int) yCoordinate;
        result = 31 * result + (int) zCoordinate;
        return result;
    }

    @Override
    public String toString() {
        return "Point {" + " x coordinate= " + xCoordinate + ", y coordinate= " + yCoordinate +
                ", z coordinate= " + zCoordinate;
    }
}
