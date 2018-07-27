package test.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.cafe.dto.CafeCommentDto;
import test.mybatis.SqlMapConfig;

public class CafeCommentDao {
	private static CafeCommentDao dao;
	private static SqlSessionFactory factory;
	private CafeCommentDao() {}
	
	public static CafeCommentDao getInstance() {
		if(dao==null) {
			dao=new CafeCommentDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	// 댓글의 글 번호를 리턴해주는 메소드
	public int getSequence() {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int num = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession();
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			num = session.selectOne("cafeComment.getSequence");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return num;
	}
	
	// 댓글을 저장하는 메소드
	public boolean insert(CafeCommentDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.insert("cafeComment.insert", dto);
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
	
	// 해당 글의 댓글 목록을 가져오는 메소드
	public List<CafeCommentDto> getList(int ref_group){
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		List<CafeCommentDto> list=null;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession();
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			list = session.selectList("cafeComment.getList",ref_group);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
	
	// 댓글을 삭제해주는 메소드
	public boolean delete(int num) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.delete("cafeComment.delete",num);
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
	
	// 댓글을 수정해주는 메소드
	public boolean update(CafeCommentDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.update("cafeComment.update",dto);
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
}
