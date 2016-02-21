package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

/**
 * 1. Refactoring - 중복 제거 : getConnection() 메소드 추출 (extract method)
 * 2. 상속을 통한 UserDao 확장 - Template Method
 * 3. 클래스 분리 - SimpleConnectionMaker
 * 4. Interface를 통한 DB Connection 분리
 *  
 * @author kr052855
 *
 */

public class UserDao {
	
	/**
	 * 1. SimpleConnectionMaker를 통한 DB 연결
	 * 2. Interface를 통한 DB 연결
	 * 3. UserDao 클라이언트를 통한 Connection Class의 분리
	 */
	
	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker){
//		connectionMaker = new DConnectionMaker();
		this.connectionMaker = connectionMaker;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException{
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springtobi", "chai", "gg931127");
//		Connection c = getConnection();
		
		/**
		 * SimpleConnectionMaker 적용
		 */
		
//		Connection c = simpleConnectionMaker.makeNewConnection();
		
		/**
		 * ConnectionMaker 적용
		 */
		
		Connection c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement("insert into users (id, name, password) values (?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get (String id) throws ClassNotFoundException, SQLException{
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springtobi", "chai", "gg931127");
//		Connection c = getConnection();
		
		/**
		 * SimpleConnectionMaker 적용
		 */
		
//		Connection c = simpleConnectionMaker.makeNewConnection();
		
		/**
		 * ConnectionMaker 적용
		 */
		
		Connection c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
//	public Connection getConnection() throws ClassNotFoundException, SQLException{
//		
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springtobi", "chai", "gg931127");
//		
//		return c;
//		
//	}
	
//	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
	
}
