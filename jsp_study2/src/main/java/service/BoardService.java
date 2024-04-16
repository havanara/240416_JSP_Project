package service;

import java.util.List;

import domain.BoardVO;

public interface BoardService {

	int insert(BoardVO bvo);

	List<BoardVO> getList();

	BoardVO getDetail(int bno);

	BoardVO getModify(int bno);

	int update(BoardVO bvo);

}
