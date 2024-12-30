package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class util {
	private final String driverName = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/home?serverTimezone=UTC";
	private final String user = "root";
	private final String pass = "4177";

	private static util instance = new util();
	
	private util() {
		try {
			Class.forName(driverName);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static util getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,pass);
	}
	
	public void close(AutoCloseable... closeables) {
		for(AutoCloseable c : closeables) {
			if(c != null) {
				try {
					c.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}


