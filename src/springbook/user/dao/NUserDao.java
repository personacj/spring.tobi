package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {

	public NUserDao(ConnectionMaker connectionMaker) {
		super(connectionMaker);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public Connection getConnection() throws ClassNotFoundException, SQLException {
//		
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springtobi", "chai", "gg931127");
//		
//		return c;
//	}
	

}
