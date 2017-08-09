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
public class PrintDatabase2{
// JDBC driver name and database URL

        static String DB_URL = "jdbc:mysql://localhost/complaints?autoReconnect=true&useSSL=false";
	static String USER = "root";
	static String PASS = "Gopal@9701403138";
      public static void main(String[] args) {
Connection conn = null;
Statement stmt = null;
try{
//STEP 2: Register JDBC driver
Class.forName("com.mysql.jdbc.Driver");
//STEP 3: Open a connection
System.out.println("Connecting to a selected database...");
conn = DriverManager.getConnection(DB_URL, USER, PASS);
System.out.println("Connected database successfully...");


//STEP 4: Execute a query
System.out.println("Creating statement...");
stmt = conn.createStatement();
// Extract records without any condition.
System.out.println("Fetching records without condition...");
String sql = "SELECT * FROM List";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
//Retrieve by column name
String Emailu = rs.getString("Emailu");
String Emaila = rs.getString("Emaila");
String complaint = rs.getString("complaint");
int status = rs.getInt("status");


//Display values
System.out.println(Emaila+Emailu+complaint+status);

}
rs.close();









/*//STEP 4: Execute a query
System.out.println("Creating table in given database...");
stmt = conn.createStatement();
String sql = "CREATE TABLE Customers" +
"(id INT NOT NULL, First VARCHAR(255),Last VARCHAR(255), Age INT NOT NULL"
 +",Number VARCHAR(255),Gender VARCHAR(255),DOB VARCHAR(255), Address "
 +"VARCHAR(255), Access VARCHAR(255), Email VARCHAR(255),Password VARCHAR(255),"
 +"Question VARCHAR(255), Answer VARCHAR(255))";
stmt.executeUpdate(sql);
System.out.println("Created table in given database...");*/
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