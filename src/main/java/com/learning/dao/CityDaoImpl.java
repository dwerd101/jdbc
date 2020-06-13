package com.learning.dao;

import com.learning.jdbc.connection.ConnectionDataBaseFactory;
import com.learning.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CityDaoImpl implements CityDao {
    private Connection connection;


    //language=SQL
    private final String SQL_FIND_BY_ID = "select *\n" +
            "from city\n" +
            "where id = ?";


    @Override
    public void save(City model) {

    }

    @Override
    public void update(City model, Long aLong) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<City> findAll(List<City> model) {
        return null;
    }

    @Override
    public City findById(Long Long) {
        try {
            connection = ConnectionDataBaseFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setLong(1,Long);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Long cityId =  resultSet.getLong(1);
                String cityName = resultSet.getString(2);
                Long yearOfFoundation = resultSet.getLong(3);
                Long square = resultSet.getLong(4);
                return new City(cityId,cityName,yearOfFoundation,square);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return null;
    }
}
