package com.ssafit.model.service;

import java.util.List;

import com.ssafit.model.dto.Member;

public interface MemberService {
	// 클럽 아이디로 조회 - 해당 클럽의 가입중, 가입 요청중인 유저 전체 조회
	public List<Member> getMemberByClubId(int clubId);
	
	// 유저(매니저) 아이디로 조회 - 해당 매니저가 관리하는 클럽의 가입 요청 목록 조회
	public List<Member> getClubRegistList(String userId);

	// 클럽 아이디, 유저 아이디로 조회 - 해당 클럽에 해당 유저가 가입중인지, 가입 요청중인지, 미가입 상태인지 조회
	public String getMember(int clubId, String userId);

	// 가입 요청 추가
	public boolean applyMember(int clubId, String userId);

	// 가입 요청 수락
	public boolean approveMember(int clubId, String userId);

	// 가입 요청 삭제(거절)
	public boolean declineMember(int clubId, String userId);
}
