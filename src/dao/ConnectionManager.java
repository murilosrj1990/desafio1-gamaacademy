package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static ConnectionManager conexaoUtil;
	private final String server= "localhost";
	private final String dialect= "mysql";
	private final String port= "3306";
	private final String database= "teste";
	private final String options = "?useTimezone=true&serverTimezone=UTC";
	private final String user = "root";
	private final String password = "toor";

	public static ConnectionManager getInstance() {
	    if (conexaoUtil == null) {
	       conexaoUtil = new ConnectionManager();
	    }
	    return conexaoUtil;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection( getURLDatabase() , user , password );
		
	}
	
	private String getURLDatabase() {
		return "jdbc:"+dialect+"://"+server+":"+port+"/"+database+options;
	}
	
	public static void main(String [] args) {
	try {	
		System.out.println(getInstance().getConnection());
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}