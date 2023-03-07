package controller;

import java.sql.SQLException;
import java.util.List;

import db.DataAccessException;
import model.Group;
import model.Person;

public interface PersonGroupCtrIF {

	List<Person> showPersons() throws DataAccessException;

	Person pickPerson(int id) throws DataAccessException;

	List<Group> showGroups() throws DataAccessException;

	boolean pickNewGroup(int gid) throws DataAccessException;

}