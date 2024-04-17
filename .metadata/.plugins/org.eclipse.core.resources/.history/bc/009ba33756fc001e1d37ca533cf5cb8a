package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info("insert service");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("list service");
		return bdao.selectList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("datail service");
		return bdao.selectOne(bno);
	}

	@Override
	public BoardVO getModify(int bno) {
		log.info("modify service");
		return bdao.selectOne(bno);
	}

	@Override
	public int update(BoardVO bvo) {
		log.info("update service");
		return bdao.update(bvo);
	}

}
