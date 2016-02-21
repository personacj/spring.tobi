package springbook.user.dao;

import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ConnectionMaker connectionMaker = new DConnectionMaker();
		
//		UserDao dao = new UserDao(connectionMaker);
//		NUserDao dao = new NUserDao();
		
//		UserDao dao = new UserDao(connectionMaker);
		
		/**
		 * DaoFactory를 통한 Connection 생성 역할 및 책임 분리
		 */
		
		UserDao dao = new DaoFactory().userDao();
		
		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPassword("married");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " 조회 성공");
		
	}

}
