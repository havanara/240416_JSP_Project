package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatebaseBuilder;

public class CommentDAOImpl implements CommentDAO {
	private static final Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	private SqlSession sql;
	
	public CommentDAOImpl() {
		new DatebaseBuilder();
		sql = DatebaseBuilder.getFactory().openSession();
	}


	@Override
	public int insert(CommentVO cvo) {
		// TODO Auto-generated method stub
		int isOK = sql.insert("CommentMapper.post", cvo);
		if(isOK>0) {
			sql.commit();
		}
		return isOK;
	}


	@Override
	public List<CommentVO> selectList(int bno) {
		// TODO Auto-generated method stub
		return sql.selectList("CommentMapper.list", bno);
	}


	@Override
	public int update(CommentVO cvo) {
		// TODO Auto-generated method stub
		int isOK = sql.update("CommentMapper.modify", cvo);
		if(isOK>0) {
			sql.commit();
		}
		return isOK;
	}


	@Override
	public int delete(int cno) {
		// TODO Auto-generated method stub
		int isOK = sql.delete("CommentMapper.delete", cno);
		if(isOK>0) {
			sql.commit();
		}
		return isOK;
	}


	@Override
	public int removeAll(int bno) {
		// TODO Auto-generated method stub
		int isOK = sql.delete("CommentMapper.all", bno);
		if(isOK>=0) {
			sql.commit();
		}
		return isOK;
	}

}