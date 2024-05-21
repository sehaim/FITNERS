package com.ssafit.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.model.dao.MemberDao;
import com.ssafit.model.dto.Member;
import com.ssafit.model.dto.MemberRegist;

@Service
public class MemberServiceImpl implements MemberService {

	private final String NONE = "NONE";
	private final String PROCEEDING = "PROCEEDING";
	private final String COMPLETE = "COMPLETED";

	private final MemberDao memberDao;

	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Transactional
	@Override
	public List<Member> getMemberByClubId(int clubId) {
		List<Member> list = memberDao.selectByclubId(clubId);
		return list;
	}

	@Transactional
	@Override
	public List<MemberRegist> getClubRegistList(String userId) {
		List<MemberRegist> list = memberDao.selectClubRegistList(userId);
		return list;
	}

	@Transactional
	@Override
	public String getMember(int clubId, String userId) {
		Member member = memberDao.select(clubId, userId);
		if (member == null) {
			return NONE;
		} else {
			if (!member.isAccess()) {
				return PROCEEDING;
			} else {
				return COMPLETE;
			}
		}
	}

	@Transactional
	@Override
	public boolean applyMember(int clubId, String userId) {
		if (memberDao.select(clubId, userId) != null) {
			return false;
		}

		memberDao.insertMember(clubId, userId);
		return true;
	}

	@Transactional
	@Override
	public boolean approveMember(int clubId, String userId) {
		if (memberDao.select(clubId, userId) == null || memberDao.select(clubId, userId).isAccess()) {
			return false;
		}

		memberDao.updateMember(clubId, userId);
		return true;
	}

	@Transactional
	@Override
	public boolean declineMember(int clubId, String userId) {
		if (memberDao.select(clubId, userId) == null || memberDao.select(clubId, userId).isAccess()) {
			return false;
		}

		memberDao.deleteMember(clubId, userId);
		return true;
	}

}
