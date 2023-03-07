package controller;

import java.time.LocalDate;
import java.util.List;

import db.DataAccessException;
import model.Person;

public interface PersonCtrIF {

	List<Person> findAll() throws DataAccessException;

	Person findById(int id) throws DataAccessException;

	void updatePerson(Person p) throws DataAccessException;

}