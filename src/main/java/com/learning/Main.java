package com.learning;

import com.learning.dao.ListOfPeopleDaoImpl;
import com.learning.dao.TypeOfPeopleDaoImpl;
import com.learning.model.ListOfPeople;
import com.learning.model.TypeOfPeople;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Если  не правильно напишем данные, то вернет пустоту
		//Первый запрос
	List<TypeOfPeople> typeOfPeopleList = new TypeOfPeopleDaoImpl().findByCityAndLanguage(1L,"Russian");
	typeOfPeopleList.forEach(System.out::println);
		System.out.println("-----");
		//Второй запрос
	List<ListOfPeople> listOfPeopleList = new ListOfPeopleDaoImpl().findAllCityAndTypeOfPeople(1L);
	listOfPeopleList.forEach(System.out::println);
		System.out.println("-----");
		//Третий запрос
	List<ListOfPeople> listOfPeopleListTwo = new ListOfPeopleDaoImpl().findByCityAndCountAndAllTypeOfPeople(1L,100000L);
	listOfPeopleListTwo.forEach(System.out::println);
		System.out.println("-----");
		//Четвертый запрос
	TypeOfPeople typeOfPeople = new TypeOfPeopleDaoImpl().findByMinCount();
		System.out.println(typeOfPeople);
    }
}
