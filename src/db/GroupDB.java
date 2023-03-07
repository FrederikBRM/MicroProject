package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Group;

public class GroupDB implements GroupDBIF {
	private static final String selectAllQ = "selcet id, name, description from group";
	private static final String selectByIDQ = selectAllQ + " where id =?";
	private PreparedStatement selectAll;
	private PreparedStatement selectByID;
	
	
	public GroupDB() throws SQLException {
		selectAll = DBConnection.getInstance().getConnection().prepareStatement(selectAllQ);
		selectByID = DBConnection.getInstance().getConnection().prepareStatement(selectByIDQ);
	}
	
	

	@Override
	public List<Group> findAll() throws DataAccessException {
		try {
			ResultSet rs = selectAll.executeQuery();
			List<Group> res = buildObjects(rs);
			return res;
		}catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Couldn't find all");
			throw he;
		}
	}
	
	private List<Group> buildObjects(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<Group> res = new ArrayList<>();
		while(rs.next()) {
			res.addAll(buildObjects(rs));
			
		}
		
		return res;
	}



	@Override
	public Group findById(int id) throws DataAccessException{
		try {
			selectByID.setInt(1, id);
			ResultSet rs = selectByID.executeQuery();
			Group g = null;
			if(rs.next()) {
				g = buildObject(rs);
			}
			return g;
		}catch (SQLException e) {
			throw new DataAccessException(e, "Couldn't find by the id = " + id);
		}
	}



	private Group buildObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Group g = new Group(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
		return g;
	}
	
	
	
}
