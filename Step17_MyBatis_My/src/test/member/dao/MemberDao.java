package test.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.member.dto.MemberDto;
import test.mybatis.SqlMapConfig;

public class MemberDao {
	// sql 문은 xml에서 정의하여 분리한다!!!
	
	// static 필드
	private static MemberDao dao;
	private static SqlSessionFactory factory; // dao 에서의 의존 객체
	// 생성자
	private MemberDao() {}
	// MemberDao 객체를 리턴해주는 static 멤버 메소드
	public static MemberDao getInstance() {
		if(dao==null) {
			dao=new MemberDao();
			factory=SqlMapConfig.getSqlSession(); // factory의 참조값 얻기
		}
		return dao;
	}
	// 회원 정보를 저장하는 메소드
	public boolean insert(MemberDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session=null;
		int flag=0;
		try {
			// .openSession(auto Commit 여부)
			session=factory.openSession(true); // factory를 통해 session의 참조값 얻기
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag=session.insert("member.insert",dto);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		if(flag>0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean update(MemberDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.update("member.update", dto);
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
	public boolean delete(int num) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.delete("member.delete", num);
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
	public MemberDto getData(int num) {
		SqlSession session = null;
		MemberDto dto=null;
		try {
			session=factory.openSession(); // select는 commit이 필요없으니까 true 안 해도 됨
			/*
			 *	Mapper의 namespace : member
			 *  sql의 id : getData
			 *  parameterType : int
			 *  resultType : MemberDto
			 */
			dto=session.selectOne("member.getData", num); 
			// 그때 그때 다른 타입을 리턴해 줌. 어떤 타입을 리턴해 줄지는 mapper에 정의해 놔야
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}
	public List<MemberDto> getList(){
		SqlSession session=null;
		List<MemberDto> list=null;
		try {
			session=factory.openSession();
			/*
			 * 	Mapper의 namespace : member
			 * 	sql의 id : getList
			 * 	parameterType : X
			 * 	resultType : MemberDto
			 */
			list=session.selectList("member.getList"); // List 타입을 select 해 주니까 list의 제네릭 타입을 resultType으로
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
