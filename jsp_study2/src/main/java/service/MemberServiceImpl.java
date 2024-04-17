package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}
	
	@Override
	public int register(MemberVO mvo) {
		log.info("insert service");
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO getLogin(MemberVO mvo) {
		log.info("login service");
		return mdao.getLogin(mvo);
	}

	@Override
	public List<MemberVO> getList() {
		log.info("list service");
		return mdao.getList();
	}

	@Override
	public MemberVO getModify(String id) {
		log.info("modify service");
		return mdao.getModify(id);
	}

	@Override
	public int update(MemberVO mvo) {
		log.info("update service");
		return mdao.update(mvo);
	}

	@Override
	public int delete(String id) {
		log.info("delete service");
		return mdao.delete(id);
	}

}