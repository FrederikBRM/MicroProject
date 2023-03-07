package controller;

import java.util.List;

import db.DataAccessException;
import model.Group;
import model.Person;

public class PersonGroupCtrl implements PersonGroupCtrIF {
	private Person p;
	private PersonCtrIF personCtrl;
	private GroupCtrIF groupCtrl;

	public PersonGroupCtrl() {
		groupCtrl = new GroupCtrl();
	}
	
	@Override
	public List<Person> showPersons() throws DataAccessException {
		return personCtrl.findAll();
	}

	@Override
	public Person pickPerson(int id) throws DataAccessException {
		p = personCtrl.findById(id);
		return p;
	}

	@Override
	public List<Group> showGroups() throws DataAccessException {
		return groupCtrl.findAll();
	}

	@Override
	public boolean pickNewGroup(int id) throws DataAccessException {
		Group group = groupCtrl.findById(id);
		p.setGroup(group);
		return personCtrl.updatePerson(p);
	
	}

}
