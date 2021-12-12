package com.epam.cube.entity;

public class Cube {

    private Point point;
    private double line;

    public Cube() {
        point = new Point();
        line = 0;
    }

    public Cube(Point point, double line) {
        this.point = point;
        this.line = line;
    }

    public Point getPoint() {
        return point;
    }

    public double getLine() {
        return line;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setLine(double line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cube cube = (Cube) o;
        return Double.compare(cube.line, line) == 0 && point.equals(cube.point);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + point.hashCode();
        result = 31 * result + (int) line;
        return result;
    }

    @Override
    public String toString() {
        return "Cube {" + " point= " + point + ", line= " + line + "}";
    }

}
