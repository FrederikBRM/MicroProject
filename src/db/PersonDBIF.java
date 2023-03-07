package db;

import java.time.LocalDate;
import java.util.List;

import model.Person;

public interface PersonDBIF {
	List<Person> findAll() throws DataAccessException;
	Person findById(int id) throws DataAccessException;
	void update(Person p) throws DataAccessException;
}
