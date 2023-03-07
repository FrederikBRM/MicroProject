package controller;

import java.sql.SQLException;
import java.util.List;

import db.DataAccessException;
import db.GroupDB;
import db.GroupDBIF;
import model.Group;

public class GroupCtrl implements GroupCtrIF {
	private GroupDBIF groupDB;
	
	public GroupCtrl() {
		try {
			groupDB = (GroupDBIF) new GroupDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Group> findAll() throws DataAccessException {
		return groupDB.findAll();
	}

	@Override
	public Group findById(int id) throws DataAccessException {
		return groupDB.findById(id);
	}

}
