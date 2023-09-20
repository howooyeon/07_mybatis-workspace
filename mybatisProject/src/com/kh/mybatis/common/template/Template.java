package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	/*
	 * 기존 JDBC
	 * 
	 * public static Connection getConnection(){
	 * 		// driver.properties 파일 읽어들여서 
	 * 		// 해당 DB와 접속된 Connection 객체 생성해서 반환
	 * }
	 * 
	 * public static void close(JDBC용 객체){
	 * 		// 전달받은 JDBC용 객체를 반납시키는 구문
	 * }
	 * 
	 * public static void commit|rollback(Conn){
	 * 		// 트랜젝션 처리
	 * }
	 * 
	 */
	
	//  마이바티스 
	
	public static SqlSession getSqlSession() {
		
		// mybatis-config.xml 파일을 읽어들여서
		// 해당 DB와 접속된 SqlSession 객체 생성해서 반환
		SqlSession sqlSession = null;
		
		// SqlSession 생성하기 위ㅐ헛 => SqlSessionFactory 필요
		// SqlSessioFactory 생성하기 위해서 => SqlSessionFactoryBuilder 필요
		
		String resource = "/mybatis-config.xml";
		
		
		try {
			// 파일이라 io예외 날 수 있어서 예외처리 뭐 대충 읽어들이라는 코드
			InputStream stream = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false); // false 비워도 안비워도 됨 자동커밋 안함
								// openSession() : 기본값은 false
								// openSession(boolean flag) : 자동커밋 여부 (true하겠다, false면 안하겠다) => 개발자가 autoCommit 여부를 직접 설정함
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
		
	}
		
}
