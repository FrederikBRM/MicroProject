package controller;

import java.util.List;

import db.DataAccessException;
import db.PersonDBIF;
import model.Person;

public class PersonCtrl implements PersonCtrIF {
	private PersonDBIF personDB;
	
	@Override
	public List<Person> findAll() throws DataAccessException {
		return personDB.findAll();
	}

	@Override
	public Person findById(int id) throws DataAccessException {
		return personDB.findById(id);
	}

	@Override
	public boolean updatePerson(Person p) throws DataAccessException {
		return personDB.update(p);
	}

}
