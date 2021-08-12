package ru.major.speedometer;

public class Point {

    //у класса должны быть поля широта и долгота
    //должен быть метод который валидирует диапазон
    //должен быть конструктор который принимает строку вида "12.50,13.56", парсит ее и заполняет поля
    //должны быть геттеры которые возвращают широту и долготу
    private double lat;
    private double lng;

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public Point(String optionName) {
        this.lat = lat;
        this.lng = lng;
    }
}
