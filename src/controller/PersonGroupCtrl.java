package controller;

import java.util.List;

import db.DataAccessException;
import model.Group;
import model.Person;

public class PersonGroupCtrl implements PersonGroupCtrIF {
	private Person p;
	private PersonCtrIF pPIF;
	private GroupCtrIF gPIF;
	
	
	@Override
	public List<Person> showPersons() throws DataAccessException {
		return pPIF.findAll();
	}

	@Override
	public Person pickPerson(int id) throws DataAccessException {
		return pPIF.findById(id);
	}

	@Override
	public List<Group> showGroups() throws DataAccessException {
		return gPIF.findAll();
	}

	@Override
	public boolean pickNewGroup(int id) throws DataAccessException {
		gPIF.findById(id);
		boolean succes = pPIF.updatePerson(p);
		return succes;
	}

}
