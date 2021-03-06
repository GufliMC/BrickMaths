package com.guflimc.brick.maths.api.geo;

public interface Point {

    double x();

    double y();

    double z();

    default int blockX() {
        return (int) x();
    }

    default int blockY() {
        return (int) y();
    }

    default int blockZ() {
        return (int) z();
    }

    Point withX(double x);

    Point withY(double y);

    Point withZ(double z);

    default double distance(Point other) {
        double diffX = x() - other.x();
        double diffY = y() - other.y();
        double diffZ = z() - other.z();
        return Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);
    }

    default Point addX(double x) {
        return withX(x() + x);
    }

    default Point addY(double y) {
        return withY(y() + y);
    }

    default Point addZ(double z) {
        return withZ(z() + z);
    }

    Point scale(double v);

    Point add(double x, double y, double z);

    Point add(Point other);
}
