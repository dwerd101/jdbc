package com.learning.model;

public class TypeOfPeople {
    private long id;
    private City cityId;
    private String nameType;
    private String language;

    public TypeOfPeople(long id, City cityId, String nameType, String language) {
        this.id = id;
        this.cityId = cityId;
        this.nameType = nameType;
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "TypeOfPeople{" +
                "id=" + id +
                ", cityId=" + cityId +
                ", nameType='" + nameType + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
