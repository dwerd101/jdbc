package com.learning.dao;

import com.learning.model.City;
import com.learning.model.ListOfPeople;
import com.learning.model.TypeOfPeople;

import java.util.List;

public interface ListOfPeopleDao extends CrudDao<ListOfPeople, Long> {
    List<ListOfPeople> findAllCityAndTypeOfPeople( Long typeOfPeopleId);
    List<ListOfPeople> findByCityAndCountAndAllTypeOfPeople(Long cityId, Long count);

}
