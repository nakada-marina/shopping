package commonUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils{

	private static Connection con;
	private static final String URL = "jdbc:mysql://localhost:3306/shopping?useSSL=false";
	private final String USER = "root";
	private final String PASSWORD = "penpeN00";

	public Connection getConnection() throws SQLException{

//		if(con == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return con = DriverManager.getConnection(URL, USER, PASSWORD);
//			} else {
//				con.close();
//			}

//		return con;
	}

}