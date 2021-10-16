package ru.major.speedometer;

public class Point {

    private double lat;
    private double lng;

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Point(String optionName) {

        String[] points = optionName.split(",");
        this.lat = Double.parseDouble(points[0]);
        this.lng = Double.parseDouble(points[1]);

    }

    public boolean isInRange() {

        if (-90 <= lat && lat <= 90 && -180 <= lng && lng <= 180) {
            return true;

        }

        return false;
    }
}
