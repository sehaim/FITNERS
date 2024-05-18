package com.ssafit.model.dao;

import java.util.List;

import com.ssafit.model.dto.Member;

public interface MemberDao {

	// 클럽 아이디로 조회 - 해당 클럽의 가입중, 가입 요청중인 유저 전체 조회
	public List<Member> selectByclubId(int clubId);
	
	// 유저(매니저) 아이디로 조회 - 해당 매니저가 관리하는 클럽의 가입 요청 목록 조회
	public List<Member> selectClubRegistList(String userId);

	// 클럽 아이디, 유저 아이디로 조회 - 해당 클럽에 해당 유저가 가입중인지, 가입 요청중인지, 미가입 상태인지 조회
	public Member select(int clubId, String userId);

	// 가입 요청 추가
	public int insertMember(int clubId, String userId);

	// 가입 요청 수락
	public int updateMember(int clubId, String userId);

	// 가입 요청 삭제(거절)
	public int deleteMember(int clubId, String userId);

}
