package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO getLogin(MemberVO mvo);

	List<MemberVO> getList();

	MemberVO getModify(String id);

	int update(MemberVO mvo);

	int delete(String id);

}
