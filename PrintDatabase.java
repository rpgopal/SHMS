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
public class PrintDatabase{
// JDBC driver name and database URL

        static String DB_URL = "jdbc:mysql://localhost/shms?autoReconnect=true&useSSL=false";
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
String sql = "SELECT * FROM Customers";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
//Retrieve by column name
int id=rs.getInt("id");
String First = rs.getString("First");
String Last = rs.getString("Last");
String Age = rs.getString("Age");
String Gender = rs.getString("Gender");
String Number = rs.getString("Number");
String DOB = rs.getString("DOB");
String Address = rs.getString("Address");
String Access = rs.getString("Access");
String Email = rs.getString("Email");
String Password = rs.getString("Password");
String Question = rs.getString("Question");
String Answer = rs.getString("Answer");


//Display values
System.out.println(id+First+Last+Age+Number+Gender+DOB+Address+Access+Email+Password+Question+Answer);

}
rs.close();

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