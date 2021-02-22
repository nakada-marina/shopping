package commonUtils;
import java.sql.*;

public class ConnectionUtils{
	
	private static Connection con;
	private static final String URL = "jdbc:mysql://localhost:3306/shopping?useSSL=false";
	private final String USER = "root";
	private final String PASSWORD = "penpeN00";

	public Connection getConnection() throws SQLException{
		
//		if(con == null){
			return con = DriverManager.getConnection(URL, USER, PASSWORD);
//			} else {
//				con.close();
//			}
		
//		return con;
	}
	
}