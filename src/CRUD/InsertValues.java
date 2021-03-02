package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DB_Connection;

public class InsertValues {

    // create a new method
    public void insertValues(String user_name, String email, String mobile) {
        // first create an object of the db connection class
        DB_Connection obj_DB_Connection = new DB_Connection();

        // Connectin => connection id from java.sql
        Connection connection = obj_DB_Connection.get_connection();
        
      //we are going to have prepare statement => each values are going to use prepare statement.setString
        PreparedStatement ps = null;  //from java.sql
        
        String query = "INSERT INTO userlist(user_id, user_name, email, mobile) values(?,?,?,?)";
        
        try {
	    	//bind the connection with Prepared Statement
	        ps = connection.prepareStatement(query);
	        //set each value
	        ps.setInt(1, 0);
	        ps.setString(2, user_name);
	        ps.setString(3, email);
	        ps.setString(4, mobile);
	        
	        //function for executing the query
	        ps.executeUpdate();
	        
        }catch(Exception e) {
        	System.err.println(e);
        }

    }
}
