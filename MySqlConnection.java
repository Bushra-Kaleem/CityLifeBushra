package myPack;
import java.sql.*;
public class MySqlConnection {
	static Connection cn=null;
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/batch1";
	static String user="root";
	static String pass="bushra";
	
	public static Connection getCn() throws Exception{
		Class.forName(driver);
		cn=DriverManager.getConnection(url,user,pass);
		return cn;
	}
}