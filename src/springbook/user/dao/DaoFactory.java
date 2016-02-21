package springbook.user.dao;

/**
 * 객체의 생성 방법 결정 및 오브젝트 Return 
 * @author kr052855
 */

public class DaoFactory {
	
	public UserDao userDao(){
//		ConnectionMaker connectionMaker = new DConnectionMaker();
//		UserDao userDao = new UserDao(connectionMaker);
//		
//		return userDao;
		
		return new UserDao(connectionMaker());
	}
	
	public ConnectionMaker connectionMaker(){
		return new DConnectionMaker();
	}
	
}
