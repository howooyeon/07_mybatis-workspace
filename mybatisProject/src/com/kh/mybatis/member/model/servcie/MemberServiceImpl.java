package com.kh.mybatis.member.model.servcie;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao mDao = new MemberDao();

	@Override
	public int insertMember(Member m) {
		/*
		 * Connection conn = JDBCTemplate.getConnection();
		 * int result = new MemberDao().insertMember(conn, m);
		 * 
		 * if(result > 0){
		 * 		JDBCTemplate.commit(conn);
		 * } else {
		 * 		JDBCTemplate.rollback(conn);
		 * }
		 * 
		 * JDBCTemplate.close(conn);
		 * 
		 * return result;
		 * 
		 */
		//!!!!!!!!!!!!!!!!!!!!제일 핵심코드!!!!!!!!!!!!!!!!!!!
		// 자료형 변수명 = getSqlSession이 template에 드감
		SqlSession sqlSession = Template.getSqlSession();
		// 이때 mybatis-config.xml 문서 읽어들임
		// 이때 등록시킨 mapper.xml 문서들도 다 읽어들여짐
		
		int result = mDao.insertMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		} // 자동커밋이 안되기 때문에 else문 안 써도 된다.
		
		sqlSession.close();
		
		return result;
		
	}

	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		Member loginMember = mDao.loginMember(sqlSession, m);
		sqlSession.close();		
		return loginMember;
	}

	@Override
	public int updateMember(Member m) {
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		return 0;
	}
	
}