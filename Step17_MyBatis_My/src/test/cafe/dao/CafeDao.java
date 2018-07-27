package test.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.cafe.dto.CafeDto;
import test.mybatis.SqlMapConfig;

public class CafeDao {
	private static CafeDao dao;
	private static SqlSessionFactory factory;
	private CafeDao() {}
	
	// 자신의 참조값을 리턴해주는 메소드
	public static CafeDao getInstance() {
		if(dao==null) {
			dao=new CafeDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	// 새 글을 저장하는 메소드
	public boolean insert(CafeDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.insert("cafe.insert", dto);
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
	
	// 글 정보를 삭제하는 메소드
	public boolean delete(int num) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.delete("cafe.delete", num);
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
	
	// 글 정보를 수정하는 메소드
	public boolean update(CafeDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.insert("cafe.update", dto);
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
	
	// 조회수를 올려주는 메소드
	public void addViewCount(int num) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			session.update("cafe.addViewCount", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	// 글의 갯수를 리턴하는 메소드
	public int getCount(CafeDto dto) {
		SqlSession session=null;
		int count=0;
		try {
			session=factory.openSession();
			count=session.selectOne("cafe.getCount",dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	// 글 하나의 정보를 리턴하는 메소드
	public CafeDto getData(CafeDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		CafeDto resultDto=null;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession();
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			resultDto=session.selectOne("cafe.getData",dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return resultDto;
	}
	
	// 글 목록을 리턴하는 메소드
	public List<CafeDto> getList(CafeDto dto){
		SqlSession session=null;
		List<CafeDto> list=null;
		try {
			session=factory.openSession();
			/*
			 * 	페이징 처리를 염두에 둔 CafeMapper.xml 작성하기
			 */
			list=session.selectList("cafe.getList",dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
