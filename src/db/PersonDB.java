package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Group;
import model.Person;

public class PersonDB implements PersonDBIF {
	private static final String findAllQ =
			"select id, name, email, phone, birth_date, groups_id from persons";
	private static final String findByIdQ =
			findAllQ + " where id = ?";
	private static final String updateQ = 
			"update persons set name = ?, email = ?, phone = ? , birth_date = ?, groups_id = ? where id = ?";
	private PreparedStatement findAll, findById, update;

	public PersonDB() throws DataAccessException {
		try {
			findAll = DBConnection.getInstance().getConnection()
					.prepareStatement(findAllQ);
			findById = DBConnection.getInstance().getConnection()
					.prepareStatement(findByIdQ);
			update = DBConnection.getInstance().getConnection()
					.prepareStatement(updateQ);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	
	@Override
	public List<Person> findAll() throws DataAccessException {
		ResultSet rs;
		try {
			rs = findAll.executeQuery();
			List<Person> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not retrieve all persons");
		}
	}

	@Override
	public Person findById(int id) throws DataAccessException {
		try {
			findById.setInt(1, id);
			ResultSet rs = findById.executeQuery();
			Person p = null;
			if(rs.next()) {
				p = buildObject(rs);
			}
			return p;
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find by id = " + id);
		}
	}

	@Override
	public boolean update(Person p) throws DataAccessException {
		final int id = p.getId();
		final String name = p.getName();
		final String email = p.getEmail();
		final String phone = p.getPhone();
		final LocalDate birthDate = p.getBirthDate();
		final int groupId = p.getGroup().getId();
		try {
			//update person set 
			//name = ?, email = ?, phone = ? , 
			//birth_date = ?, groups_id = ? where id = ?"
			update.setString(1, name);
			update.setString(2, email);
			update.setString(3, phone);
			update.setDate(4, java.sql.Date.valueOf(birthDate));
			update.setInt(5, groupId);
			update.setInt(6, id);
			update.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not update person where id = " + id);
		}
	      

	}

	private Person buildObject(ResultSet rs) throws SQLException {
		Person p = new Person(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("email"),
				rs.getString("phone"),
				rs.getDate("birth_date").toLocalDate(),
				new Group(rs.getInt("groups_id"), null, null)
				);
		return p;
	}

	private List<Person> buildObjects(ResultSet rs) throws SQLException {
		List<Person> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildObject(rs));
		}
		return res;
	}

}