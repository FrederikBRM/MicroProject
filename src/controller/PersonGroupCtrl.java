package controller;

import java.util.List;

import db.DataAccessException;
import model.Group;
import model.Person;

public class PersonGroupCtrl implements PersonGroupCtrIF {
	private Person p;
	private PersonCtrIF personCtrl;
	private GroupCtrIF groupCtrl;
	
	
	@Override
	public List<Person> showPersons() throws DataAccessException {
		return personCtrl.findAll();
	}

	@Override
	public Person pickPerson(int id) throws DataAccessException {
		return personCtrl.findById(id);
	}

	@Override
	public List<Group> showGroups() throws DataAccessException {
		return groupCtrl.findAll();
	}

	@Override
	public boolean pickNewGroup(int id) throws DataAccessException {
		groupCtrl.findById(id);
		boolean succes = personCtrl.updatePerson(p);
		return succes;
	}

}
