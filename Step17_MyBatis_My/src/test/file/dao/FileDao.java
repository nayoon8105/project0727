package test.file.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.file.dto.FileDto;
import test.mybatis.SqlMapConfig;

public class FileDao {
	private static FileDao dao;
	private static SqlSessionFactory factory;
	private FileDao() {}
	public static FileDao getInstance() {
		if(dao==null) {
			dao=new FileDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	// 파일 정보를 저장하는 메소드
	public boolean insert(FileDto dto) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.insert("file.insert", dto);
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
	// 파일 다운로드 횟수를 증가시키는 메소드
	public boolean addDownCount(int num) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			flag = session.update("file.addDownCount", num);
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
			flag = session.delete("file.delete", num);
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
	// 하나의 파일 정보를 리턴해주는 메소드
	public FileDto getData(int num) {
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		FileDto dto=null;
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession(true);
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			dto = session.selectOne("file.getData",num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return dto;
	}
	// 파일 목록을 리턴하는 메소드
	public List<FileDto> getList(FileDto dto){
		// DB에 작업을 할 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session = null;
		List<FileDto> list=new ArrayList<>();
		try {
			// .openSession(auto Commit 여부)
			session = factory.openSession();
			// .insert("mapper 이름 . sql 아이디", 파라미터)
			list = session.selectList("file.getList",dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
	// 전체 row의 갯수를 리턴하는 메소드
	public int getCount() {
		SqlSession session=null;
		int count=0;
		try {
			session=factory.openSession();
			count=session.selectOne("file.getCount");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
}
