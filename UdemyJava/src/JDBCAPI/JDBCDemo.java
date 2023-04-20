package JDBCAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/stk";
		int rowsAffected;
		try {
			
			//establish connection
			Connection conn = DriverManager.getConnection(url,"root","password");
			
			//create statement object to send to the database
			Statement statement = conn.createStatement();
			
			//Execute statement object, and store data in result set object
			//ResultSet resultSet = statement.executeQuery("select * from stk_project_member");
			//rowsAffected = statement.executeUpdate("insert into stk_project_member "
				//	+ "values(9,'P10001','chubh','Chief Engineer','A',51751,'A',curdate(),'2',curdate(),'2');");
			
			
			//delete
			//rowsAffected = statement.executeUpdate("delete from stk_project_member where id=7");
			
			//update
			rowsAffected = statement.executeUpdate("update stk_project_member set status='A' where id=4;");
					
			
			//process the result, select
			/*int idTotal = 0;
			while(resultSet.next()) {
				//System.out.println(resultSet.getString("user_login_name"));
				System.out.println(resultSet.getInt("id"));
				//idTotal = idTotal + resultSet.getInt("id");
				//idTotal = idTotal + Integer.parseInt(resultSet.getString("id"));
			}*/
			//System.out.println(idTotal);
			//insert
			//System.out.println("Executed an Insert statement rowsAffected :"+rowsAffected);
			
			//System.out.println("Executed an Delete statement rowsAffected :"+rowsAffected);
			
			System.out.println("Executed an update statement rowsAffected :"+rowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("Error while insertion");
			//System.out.println("Error while deleting");
			System.out.println("Error while updating");
		}

	}

}
