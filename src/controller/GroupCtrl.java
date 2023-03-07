package controller;

import java.util.List;

import db.DataAccessException;
import db.GroupDBIF;
import model.Group;

public class GroupCtrl implements GroupCtrIF {
	private GroupDBIF groupDB;
	
	@Override
	public List<Group> findAll() throws DataAccessException {
		return groupDB.findAll();
	}

	@Override
	public Group findById(int id) throws DataAccessException {
		return groupDB.findById(id);
	}

}
