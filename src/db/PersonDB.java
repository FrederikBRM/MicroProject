package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Person;

public class PersonDB implements PersonDBIF{
	private static final String findAllQ = "select id, name, email, phone, birth_date, groups_id FROM persons";
	private static final String findByIdQ = findAllQ + " where id =?";
	private static final String updateQ = findByIdQ + "set groups_id";
	private PreparedStatement findAll;
	private PreparedStatement findByID;
	private PreparedStatement update;



public String findAllQ() throws DataAccessException{
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultset = null;
	
	try {
		connection = DriverManager.getConnection("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s;encrypt=false");
		statement = connection.prepareStatement("SELECT * FROM persons");
		resultset = statement.executeQuery();
		
		StringBuilder stringbuilder = new StringBuilder();
		while (resultset.next()) {
			int id = resultset.getInt("id");
			String name = resultset.getString("name");
			int age = resultset.getInt("age");
			String email = resultset.getString("email");
			
			  stringbuilder.append(id).append(": ").append(name).append(" (").append(age).append(") - ").append(email).append("\n");
			  
		}

        return stringbuilder.toString();
    } catch (SQLException e) {
        throw new DataAccessException(e, "Error while accessing the database");
    } finally {
        try {
            if (resultset != null) {
                resultset.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new DataAccessException(e, "Error while closing the database resources");
        }
        }
    }

@Override
public List<Person> findAll() throws DataAccessException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Person findById(int id) throws DataAccessException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean update(Person p) throws DataAccessException {
	// TODO Auto-generated method stub
	return false;
}
}

