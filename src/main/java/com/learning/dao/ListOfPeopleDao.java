package com.learning.dao;


import com.learning.model.ListOfPeople;

import java.util.List;

public interface ListOfPeopleDao extends CrudDao<ListOfPeople, Long> {
    List<ListOfPeople> findAllCityAndTypeOfPeople( Long typeOfPeopleId);
    List<ListOfPeople> findByCityAndCountAndAllTypeOfPeople(Long cityId, Long count);

}
