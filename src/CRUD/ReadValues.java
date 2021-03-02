package CRUD;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import common.DB_Connection;
import common.User_Bean;

public class ReadValues {
	
	public static void main(String args[]) {
		ReadValues obj_read_values = new ReadValues();
		obj_read_values.get_values();
	}

	public List<User_Bean> get_values() {
		 // first create an object of the db connection class
        DB_Connection obj_DB_Connection = new DB_Connection();

        // Connectin => connection id from java.sql
        Connection connection = obj_DB_Connection.get_connection();
        
        
        //we are going to have prepare statement => each values are going to use prepare statement.setString
        PreparedStatement ps = null;  //from java.sql
        
        ResultSet rs = null;
        
        List<User_Bean> list = new ArrayList<User_Bean>();
        
        try {
        	 String query = "select * from userlist";
             ps = connection.prepareStatement(query);
             rs = ps.executeQuery();
             
             //iterate the result set to get each value
             
             while(rs.next()) {
            	 /*
            	 System.out.println(rs.getString("user_id"));
            	 System.out.println(rs.getString("user_name"));
            	 System.out.println(rs.getString("email"));
            	 System.out.println(rs.getString("mobile"));
            	 */
            	 
            	 //we have to get all these values into single object and take that object to the frontend
            	 
            	 User_Bean obj_user_bean = new User_Bean();
            	 
            	 obj_user_bean.setUser_id(rs.getInt("user_id"));
            	 obj_user_bean.setUser_name(rs.getString("user_name"));
            	 obj_user_bean.setEmail(rs.getString("email"));
            	 obj_user_bean.setMobile(rs.getString("mobile"));
            	 
            	 list.add(obj_user_bean);
            	 
             }
             
        }catch(Exception e) {
        	System.out.println(e);
        }
        return list;
       
  
	}
	
}
