package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	
	private static ConnectionManager conexaoUtil;
	private final static String server= "localhost";
	private final static String dialect= "mysql";
	private final static String port= "3306";
	private final static String database= "teste";
	private final static String options = "?useTimezone=true&serverTimezone=UTC";
	private final static String user = "root";
	private final static String password = "toor";

	public static ConnectionManager getInstance() {
	    if (conexaoUtil == null) {
	       conexaoUtil = new ConnectionManager();
	    }
	    return conexaoUtil;
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection( getURLDatabase() , user , password );
		
	}
	
	public static Statement getStatement() {
		try {
			Statement stmt = getConnection().createStatement();
			return stmt;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
	public static void executeUpdate(String sql) {		
		Statement stmt = getStatement();
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String sql){
		Statement stmt = getStatement();
		ResultSet res=null;
		try {
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	private static String getURLDatabase() {
		return "jdbc:"+dialect+"://"+server+":"+port+"/"+database+options;
	}
	
}