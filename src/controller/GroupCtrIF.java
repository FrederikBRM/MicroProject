package controller;

import java.util.List;

import db.DataAccessException;
import model.Group;

public interface GroupCtrIF {

	List<Group> findAll() throws DataAccessException;

	Group findById(int id) throws DataAccessException;

}