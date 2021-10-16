package ru.major.speedometer;

public class Result {

    private double length;
    private int speed;

    public Result(double length, int speed) {
        this.length = length;
        this.speed = speed;
    }

    public double getLength() {
        return length;

    }

    public int getSpeed() {
        return speed;
    }
}
