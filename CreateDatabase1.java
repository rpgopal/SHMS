/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.home;


//STEP 1. Import required packages
import java.sql.*;

/**
 *
 * @author rpg
 */
public class CreateDatabase1 {
// JDBC driver name and database URL

        static String DB_URL = "jdbc:mysql://localhost?autoReconnect=true&useSSL=false";
	static String USER = "root";
	static String PASS = "Gopal@9701403138";
       public static void main(String[] args) {
Connection conn = null;
Statement stmt = null;
try{
//STEP 2: Register JDBC driver
Class.forName("com.mysql.jdbc.Driver");
//STEP 3: Open a connection
System.out.println("Connecting to database...");
conn = DriverManager.getConnection(DB_URL, USER, PASS);
//STEP 4: Execute a query
System.out.println("Creating database...");
stmt = conn.createStatement();
String sql = "CREATE DATABASE devices";
stmt.executeUpdate(sql);
System.out.println("Database created successfully...");
}catch(SQLException se){
//Handle errors for JDBC
se.printStackTrace();
}catch(Exception e){
//Handle errors for Class.forName
e.printStackTrace();
}finally{
//finally block used to close resources
		try
		{
			if(stmt!=null)
			stmt.close();
		}
		catch(SQLException se2)
		{
		}// nothing we can do
		try
		{
			if(conn!=null)
			conn.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}//end finally try
	}//end try
        System.out.println("Goodbye!");

}
}