package ru.major.speedometer;


public class Calculating {

    public Result calculating(Point point, Integer timeInSeconds) {

        double length = Math.sqrt(Math.pow(point.getLat(), 2) + Math.pow(point.getLng(), 2)) * 100;
        double timeInHours = (double) timeInSeconds / 60 / 60;
        int speedInHours = (int) (length / timeInHours);

        return new Result(length,speedInHours);

    }
}
