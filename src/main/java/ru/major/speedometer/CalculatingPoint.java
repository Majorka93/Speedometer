package ru.major.speedometer;

public class CalculatingPoint extends Point {


    public CalculatingPoint(String optionName) {
        super(optionName);
    }

    public void minus(Point point) {

        setLat(getLat() - point.getLat());
        setLng(getLng() - point.getLng());


    }
}



