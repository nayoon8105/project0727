package test.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory; // 인터페이스
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	
	// static 맴버 필드로 SqlSessionFactory type 선언
	private static SqlSessionFactory sqlSession;
	// static 초기화. 최초 한 번 실행될때만 수행 됨. static 메소드 getSqlSession을 위한 초기화 작업을 함.
	static{
		// MyBatis 설정 xml 문서의 위치.(설정 정보) xml 파일을 읽어들여 초기화 설정을 함
		String resource="test/mybatis/Configuration.xml";
		try{
			Reader reader=Resources.getResourceAsReader(resource); // reader 객체로 설정 xml 문서 읽어들임
			// SqlSessionFactory 객체의 참조값을 얻어내서 맴버필드에 저장 -> single tone
			sqlSession=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("SqlSessionFactory 객체 생성 성공!");
		}catch(Exception e){
			e.printStackTrace(); // exception의 종류 알아보기. 어디서 어떤 오류가 났는지 알 수 있게 함
			System.out.println("SqlSessionFactory 객체 생성 실패!");
		}
	}
	// static 맴버 메소드. sqlSession 객체를 만들어서 return 해주는 목적
	public static SqlSessionFactory getSqlSession(){
		return sqlSession;
	}
}
