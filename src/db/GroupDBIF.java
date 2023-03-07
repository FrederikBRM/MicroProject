package db;

import java.util.List;

import model.Group;

public interface GroupDBIF {
	List<Group> findAll() throws DataAccessException;
	Group findById(int id) throws DataAccessException;


}

