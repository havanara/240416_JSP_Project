package repository;

import java.util.List;

import domain.CommentVO;

public interface CommentDAO {

	int insert(CommentVO cvo);

	List<CommentVO> selectList(int bno);

	int update(CommentVO cvo);

	int delete(int cno);

	int removeAll(int bno);

}
