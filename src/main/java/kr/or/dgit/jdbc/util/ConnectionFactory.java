package kr.or.dgit.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final ConnectionFactory instance = new ConnectionFactory();
	
	public static Connection getinstance(){
		return instance.createConnection();
		
	}

	private Connection createConnection() {
		Connection connection = null;
		try{
		String url = "jdbc:mysql://localhost:3306/mybatis";
		String user = "user_mybatis";
		String password = "rootroot";
		connection = DriverManager.getConnection(url, user, password);
		}catch (SQLException e){
			System.err.printf("Error: Unable to Connection DataBase");
		}
		return connection;
	}
	
	private ConnectionFactory(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.printf("MYSQL Driver not Found!");
			System.exit(-1);
		}
	}
}
