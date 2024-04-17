package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatebaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	
	public MemberDAOImpl() {
		new DatebaseBuilder();
		sql = DatebaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		log.info("insert dao");
		int isOK = sql.insert("MemberMapper.insert", mvo);
		if(isOK>0) {
			sql.commit();
		}
		return isOK;
	}

	@Override
	public MemberVO getLogin(MemberVO mvo) {
		log.info("login dao");
		return sql.selectOne("MemberMapper.login", mvo);
	}

	@Override
	public List<MemberVO> getList() {
		log.info("list dao");
		return sql.selectList("MemberMapper.list");
	}

	@Override
	public MemberVO getModify(String id) {
		log.info("modify dao");
		return sql.selectOne("MemberMapper.modify", id);
	}

	@Override
	public int update(MemberVO mvo) {
		log.info("update dao");
		int isOK = sql.update("MemberMapper.update", mvo);
		if(isOK>0) {
			sql.commit();
		}
		return isOK;
	}

	@Override
	public int delete(String id) {
		log.info("delete dao");
		int isOK = sql.delete("MemberMapper.delete", id);
		if(isOK>0) {
			sql.commit();
		}
		return isOK;
	}

}
