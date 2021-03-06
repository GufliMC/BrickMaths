package com.guflimc.brick.maths.api.geo;

import org.jetbrains.annotations.Nullable;

public record Location(@Nullable String worldId, double x, double y, double z, float yaw,
                       float pitch) implements Position {

    public final static Location ZERO = new Location(null, 0, 0, 0, 0, 0);

    public Location(Position pos) {
        this(null, pos.x(), pos.y(), pos.z(), pos.yaw(), pos.pitch());
    }

    public Location(Point point) {
        this(null, point.x(), point.y(), point.z(), 0, 0);
    }

    public Location withPosition(Position position) {
        return new Location(worldId, position.x(), position.y(), position.z(), position.yaw(), position.pitch());
    }

    public Location withWorldId(String worldId) {
        return new Location(worldId, x, y, z, yaw, pitch);
    }

    @Override
    public Location withYaw(float yaw) {
        return new Location(worldId, x, y, z, yaw, pitch);
    }

    @Override
    public Location withPitch(float pitch) {
        return new Location(worldId, x, y, z, yaw, pitch);
    }

    @Override
    public Position withYawPitch(float yaw, float pitch) {
        return new Location(worldId, x, y, z, yaw, pitch);
    }

    @Override
    public Position withPoint(Point point) {
        return new Location(worldId, point.x(), point.y(), point.z(), yaw, pitch);
    }

    @Override
    public Location withX(double x) {
        return new Location(worldId, x, y, z, yaw, pitch);
    }

    @Override
    public Location withY(double y) {
        return new Location(worldId, x, y, z, yaw, pitch);
    }

    @Override
    public Location withZ(double z) {
        return new Location(worldId, x, y, z, yaw, pitch);
    }

    @Override
    public Location addX(double x) {
        return withX(x() + x);
    }

    @Override
    public Location addY(double y) {
        return withY(y() + y);
    }

    @Override
    public Location addZ(double z) {
        return withZ(z() + z);
    }

    @Override
    public Location scale(double v) {
        return new Location(worldId, x() * v, y() * v, z() * v, yaw, pitch);
    }

    @Override
    public Point add(double x, double y, double z) {
        return new Location(worldId, x() + x, y() + y, z() + z, yaw, pitch);
    }

    @Override
    public Point add(Point other) {
        return new Location(worldId, x() + other.x(), y() + other.y(), z() + other.z(), yaw, pitch);
    }
}
