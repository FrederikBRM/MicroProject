package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDB {




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
}

