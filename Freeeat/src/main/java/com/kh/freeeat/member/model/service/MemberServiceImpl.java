package com.kh.freeeat.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.freeeat.member.model.dao.MemberDao;
import com.kh.freeeat.member.model.vo.Member;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired //의존성을 주입한다. =>
	private SqlSessionTemplate sqlSession; 
	
	
	@Override
	public Member loginMember(Member m) {
		
		return memberDao.loginMember(sqlSession,m);
	}

	@Override
	public int insertMember(Member m) {
		
		return memberDao.insertMember(sqlSession,m);
	}

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int idCheck(String checkId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nickNameCheck(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

}
