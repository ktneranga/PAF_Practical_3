package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
	
	public static void main(String args[]) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		
		System.out.println(obj_DB_Connection.get_connection());
		
	}
	
	public Connection get_connection() {
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user","root", "");
			
		}catch(Exception e){
			//handle exception
			System.out.println(e);
		}
		return connection;
	}
}
