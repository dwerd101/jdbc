package com.learning.dao;

import com.learning.model.TypeOfPeople;

import java.util.List;

public interface TypeOfPeopleDao extends CrudDao<TypeOfPeople, Long> {
    List<TypeOfPeople> findByCityAndLanguage(Long id, String language);
     TypeOfPeople findByMinCount();

}
