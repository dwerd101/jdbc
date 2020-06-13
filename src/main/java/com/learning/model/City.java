package com.learning.model;

public class City {

    private long id;
    private String cityName;
    private long yearOfFoundation;
    private long square;

    public City(long id, String cityName, long yearOfFoundation, long square) {
        this.id = id;
        this.cityName = cityName;
        this.yearOfFoundation = yearOfFoundation;
        this.square = square;
    }

    public City(long id) {
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(long yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public long getSquare() {
        return square;
    }

    public void setSquare(long square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", square=" + square +
                '}';
    }
}
