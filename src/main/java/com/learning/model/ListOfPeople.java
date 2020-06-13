package com.learning.model;

public class ListOfPeople {
    private long id;
    private City cityId;
    private TypeOfPeople typeOfPeopleId;
    private long count;

    public ListOfPeople(City cityId) {
        this.cityId = cityId;
    }

    public ListOfPeople(long id, City cityId, TypeOfPeople typeOfPeopleId, long count) {
        this.id = id;
        this.cityId = cityId;
        this.typeOfPeopleId = typeOfPeopleId;
        this.count = count;
    }

    public ListOfPeople(City cityId, TypeOfPeople typeOfPeopleId, long count) {
        this.cityId = cityId;
        this.typeOfPeopleId = typeOfPeopleId;
        this.count = count;
    }

    public ListOfPeople(long id, City cityId) {
        this.id=id;
        this.cityId=cityId;
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

    public TypeOfPeople getTypeOfPeopleId() {
        return typeOfPeopleId;
    }

    public void setTypeOfPeopleId(TypeOfPeople typeOfPeopleId) {
        this.typeOfPeopleId = typeOfPeopleId;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ListOfPeople{" +
                "id=" + id +
                ", cityId=" + cityId +
                ", typeOfPeopleId=" + typeOfPeopleId +
                ", count=" + count +
                '}';
    }
}
