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
		personCtrl = new PersonCtrl();
		return personCtrl.findAll();
	}

	@Override
	public Person pickPerson(int id) throws DataAccessException {
		personCtrl = new PersonCtrl();
		p = personCtrl.findById(id);
		return p;
	}

	@Override
	public List<Group> showGroups() throws DataAccessException {
		groupCtrl = new GroupCtrl();
		return groupCtrl.findAll();
	}

	@Override
	public boolean pickNewGroup(int id) throws DataAccessException {
		groupCtrl = new GroupCtrl();
		groupCtrl.findById(id);
		boolean succes = personCtrl.updatePerson(p);
		return succes;
	}

}
