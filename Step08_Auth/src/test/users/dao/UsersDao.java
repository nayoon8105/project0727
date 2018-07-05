package test.users.dao;

public class UsersDao {
	private static UsersDao dao;
	private UsersDao() {}
	//UsersDao 객체의 참조값을 리턴해주는 static 메소드 
	public static UsersDao getInstance() {
		if(dao==null) {
			dao=new UsersDao();
		}
		return dao;
	}
	
}
