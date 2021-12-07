package com.epam.cube.entity;

public class Cube {

    private final Point point;
    private final double line;

    public Cube() {
        point = new Point();
        line = 0;
    }

    public Cube(double line, Point point) {
        this.line = line;
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public double getLine() {
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
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
