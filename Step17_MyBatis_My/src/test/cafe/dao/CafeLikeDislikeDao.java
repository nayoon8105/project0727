package test.cafe.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.cafe.dto.CafeLikeDislikeDto;
import test.mybatis.SqlMapConfig;

public class CafeLikeDislikeDao {
	private static CafeLikeDislikeDao dao;
	private static SqlSessionFactory factory;
	private CafeLikeDislikeDao() {}
	
	// 자신의 참조값을 리턴해주는 메소드
	public static CafeLikeDislikeDao getInstance() {
		if(dao==null) {
			dao=new CafeLikeDislikeDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	// 좋아요 누른 글 번호와 아이디를 추가해주는 메소드
	public boolean Insert(CafeLikeDislikeDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.insert("cafeLikeDislike.insert", dto);
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
	
	// 유저가 좋아요와 싫어요를 누른 이력이 있는지, 뭘 눌렀는지를 반환해주는 메소드
	public int isClicked(CafeLikeDislikeDto dto) {
		System.out.println("id값 : "+dto.getId() + " num 값 : "+dto.getNum() + "isLike 값 : "+dto.getIsLike());
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int isLike=0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			System.out.println("isClicked의 sql문 실해 전!!! : "+isLike);
			isLike = session.selectOne("cafeLikeDislike.isClicked", dto);
			System.out.println("isClicked의 sql문 실해 후!!! : "+isLike);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return isLike;
	}
	
	// 좋아요 싫어요를 취소하는 경우
	public boolean cancel(CafeLikeDislikeDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.delete("cafeLikeDislike.cancel",dto);
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
	
	// 해당 글의 좋아요수를 반환해주는 메소드
	public int totalLike(int num) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int totalLike = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			totalLike = session.selectOne("cafeLikeDislike.totalLike",num);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return totalLike;
	}
	
	// 해당 글의 싫어요수를 반환해주는 메소드
	public int totalDislike(int num) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int totalDislike = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			totalDislike = session.selectOne("cafeLikeDislike.totalDislike",num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return totalDislike;
	}
}
