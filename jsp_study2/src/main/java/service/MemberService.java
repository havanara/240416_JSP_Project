package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {

	int register(MemberVO mvo);

	MemberVO getLogin(MemberVO mvo);

	List<MemberVO> getList();

	MemberVO getModify(String id);

	int update(MemberVO mvo);

	int delete(String id);


}