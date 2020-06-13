package com.learning.dao;

import com.learning.jdbc.connection.ConnectionDataBaseFactory;
import com.learning.model.City;
import com.learning.model.ListOfPeople;
import com.learning.model.TypeOfPeople;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListOfPeopleDaoImpl implements ListOfPeopleDao {
    private Connection connection;
    //language=SQL
    private final String SQL_FIND_ALL_CITY_AND_TYPE_OF_PEOPLE = "select id, city_id\n" +
            "from list_of_people\n" +
            "where type_of_people_id=?";

    //language=SQL
    private final String SQL_FIND_BY_CITY_AND_COUNT_AND_ALL_TYPE_OF_PEOPLE = "select id,  city_id, count, " +
            "type_of_people_id\n" +
            "from list_of_people\n" +
            "where count=? and city_id=?";

    /**
     * Вывести информацию обо всех городах, в которых проживают жители
     * выбранного типа.
     * @param typeOfPeopleId parameter value
     * @return a {@code List<TypeOfPeople>} containing the elements
     */
    @Override
    public List<ListOfPeople> findAllCityAndTypeOfPeople( Long typeOfPeopleId) {
        try {

        List<ListOfPeople> listOfPeopleList = new ArrayList<>();
            connection = ConnectionDataBaseFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_CITY_AND_TYPE_OF_PEOPLE);
            preparedStatement.setLong(1,typeOfPeopleId);;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long listOfPeopleId = resultSet.getLong(1);
                long id = resultSet.getLong("city_id");
                City city = new CityDaoImpl().findById(id);
                    ListOfPeople listOfPeople = new ListOfPeople(listOfPeopleId,city);
                    listOfPeopleList.add(listOfPeople);
                }

            return listOfPeopleList;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    /**
     * Вывести информацию о городе с заданным количеством населения
     * и всех типах жителей, в нем проживающих.
     * @param cityId parameter value
     * @param count parameter value
     * @return a {@code List<TypeOfPeople>} containing the elements
     */
    @Override
    public List<ListOfPeople> findByCityAndCountAndAllTypeOfPeople(Long cityId, Long count) {
        try {
            List<ListOfPeople> listOfPeopleList = new ArrayList<>();
            connection = ConnectionDataBaseFactory.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(SQL_FIND_BY_CITY_AND_COUNT_AND_ALL_TYPE_OF_PEOPLE);
            preparedStatement.setLong(1,count);
            preparedStatement.setLong(2, cityId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())  {
                Long id = resultSet.getLong(1);
                Long findByCityId = resultSet.getLong(2);
                Long countOfPeople = resultSet.getLong(3);
                Long typeOfPeopleId = resultSet.getLong(4);

                City city = new CityDaoImpl().findById(findByCityId);
                TypeOfPeople typeOfPeople = new TypeOfPeopleDaoImpl().findById(typeOfPeopleId);
                ListOfPeople listOfPeople = new ListOfPeople(id,city, typeOfPeople,countOfPeople);
                listOfPeopleList.add(listOfPeople);
            }
            return listOfPeopleList;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(ListOfPeople model) {

    }

    @Override
    public void update(ListOfPeople model, Long aLong) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void findAll(List<ListOfPeople> model) {

    }

    @Override
    public ListOfPeople findById(Long aLong) {
        return null;
    }


}
