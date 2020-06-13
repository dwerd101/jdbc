package com.learning.dao;


import com.learning.jdbc.connection.ConnectionDataBaseFactory;
import com.learning.model.City;
import com.learning.model.TypeOfPeople;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeOfPeopleDaoImpl implements TypeOfPeopleDao {

    private Connection connection;
    //language=SQL
    private final String SQL_FIND_BY_CITY_AND_LANGUAGE = "select *\n" +
            "from type_of_people\n" +
            "where city_id = ? and language_of_communication=?";
    //language=SQL
    private final String SQL_FIND_BY_ID = "select *\n" +
            "from type_of_people\n" +
            "where id=?";
    //language=SQL
    private final String SQL_FIND_MIN_COUNT = "select MIN(count)\n" +
            "from list_of_people";
    //language=SQL
    private final String SQL_FIND_BY_TYPE_OF_PEOPLE_AND_COUNT = "select type_of_people_id\n" +
            "from list_of_people\n" +
            "where count = ?";


    /**
     * Вывести информацию обо всех жителях заданного города, разговаривающих на заданном языке
     * @param id parameter value
     * @param language parameter value
     * @return a {@code List<TypeOfPeople>} containing the elements
     */
    @Override
    public List<TypeOfPeople> findByCityAndLanguage(Long id, String language) {
        try {
            List<TypeOfPeople> typeOfPeopleList = new ArrayList<>();
           connection = ConnectionDataBaseFactory.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_CITY_AND_LANGUAGE);
           preparedStatement.setLong(1,id);
           preparedStatement.setString(2,language);
           ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               long peopleId = resultSet.getLong(1);
               long cityIdFk = resultSet.getLong(2);
               String name = resultSet.getString(3);
               String languageOfCommunication = resultSet.getString(4);
               City city = new CityDaoImpl().findById(cityIdFk);
               TypeOfPeople typeOfPeople = new TypeOfPeople(peopleId, city, name,languageOfCommunication);
               typeOfPeopleList.add(typeOfPeople);
           }
           return typeOfPeopleList;
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Вывести информацию о самом древнем типе жителей
     * @return a TypeOfPeople object
     */
    @Override
    public TypeOfPeople findByMinCount() {
        try {
            connection = ConnectionDataBaseFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_MIN_COUNT);
            long count  =  0;
            if(resultSet.next()) count = resultSet.getLong(1);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_TYPE_OF_PEOPLE_AND_COUNT);
            preparedStatement.setLong(1,count);
            ResultSet resultSetTwo = preparedStatement.executeQuery();
            if (resultSetTwo.next()) {
                long typeOfPeopleId = resultSetTwo.getLong(1);
                TypeOfPeople typeOfPeople = new TypeOfPeopleDaoImpl().findById(typeOfPeopleId);
                return typeOfPeople;
            }


        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return null;
    }

    @Override
    public void save(TypeOfPeople model) {

    }

    @Override
    public void update(TypeOfPeople model, Long aLong) {

    }



    @Override
    public void delete(Long aLong) {

    }



    @Override
    public void findAll(List<TypeOfPeople> model) {

    }

    @Override
    public TypeOfPeople findById(Long aLong) {
        try {
            connection = ConnectionDataBaseFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setLong(1,aLong);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Long typeOfPeopleId =  resultSet.getLong(1);
                Long cityId = resultSet.getLong(2);
                String nameTypeOfPeople = resultSet.getString(3);
                String languageOfCommunication = resultSet.getString(4);
                City city = new CityDaoImpl().findById(cityId);
                return new TypeOfPeople(typeOfPeopleId,city,nameTypeOfPeople,languageOfCommunication);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return null;
    }
}
