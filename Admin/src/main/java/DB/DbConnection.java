package DB;
import java.sql.*;


public class DbConnection 
{
	public static Connection CreateConnection() 
	{
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/web_dienthoai";
		String username = "root";
		String password = "11062003cong";
		
		try 
		{
			//load driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//tao ket noi 
			conn = DriverManager.getConnection(url,username,password);
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}

