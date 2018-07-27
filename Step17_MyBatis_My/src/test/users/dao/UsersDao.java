package test.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.users.dto.UsersDto;

public class UsersDao {
	private static UsersDao dao;
	private static SqlSessionFactory factory;
	private UsersDao() {}
	// UsersDao 객체의 참조값을 리턴해주는 static 메소드
	public static UsersDao getInstance() {
		if(dao==null) {
			dao=new UsersDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	// 인자로 전달된 회원정보가 유효한지 여부를 리턴하는 메소드
	public boolean isValid(UsersDto dto) {
		SqlSession session=null;
		String result=null;
		try {
			session=factory.openSession();
			result=session.selectOne("users.isValid",dto);
			// dto에 담긴 아이디, 비밀번호가 유효한 정보이면 result는 null이 X
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if(result==null) {
			return false;
		} else {
			return true;
		}
	}
	// 인자로 전달되는 아이디가 사용가능한지 여부를 리턴해주는 메소드
	public boolean canUseId(String inputId) {
		SqlSession session=null;
		String result=null;
		try {
			// sqlSession 객체의 참조값 얻어오기
			session=factory.openSession();
			result=session.selectOne("users.isExist", inputId); // 아이디가 존재하지 않으면 null.
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		if(result==null) { // select 된 결과가 없으면 아이디 사용 가능
			return true;
		} else {
			return false;
		}
	}
	// 회원 정보를 db에 저장하는 메소드
	public boolean insert(UsersDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.insert("users.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean update(UsersDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		String nayoon="nayoon";
		nayoon.length();
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.insert("users.update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean delete(String id) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.delete("users.delete", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	public UsersDto getData(String id) {
		SqlSession session=null;
		UsersDto dto=null;
		try {
			session=factory.openSession();
			/*
			 * 	Mapper namespace : users
			 * 	sql id : getData
			 * 	parametertype : String
			 * 	resultType : test.users.dto.UsersDto
			 * 
			 * 	select 된 row 가 하나인 경우는 .selectOne()
			 * 	select 된 row 가 여러개인 경우는 .selectList()
			 */
			dto=session.selectOne("users.getData","id");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}
	public List<UsersDto> getList(){
		SqlSession session=null;
		List<UsersDto> list=new ArrayList<>();
		try {
			session=factory.openSession();
			list=session.selectList("users.getList");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
