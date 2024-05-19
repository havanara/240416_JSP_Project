package domain;

public class CommentVO {
	private int cno; //댓글 순번
	private int bno; //게시글 순번
	private String writer; //댓글 작성자
	private String content; //댓글 내용
	private String regdate; //댓글 작성일
	
	public CommentVO() {}

	public CommentVO(int cno, String writer, String content) {
		//post
		this.cno = cno;
		this.writer = writer;
		this.content = content;
	}
	public CommentVO(int cno, String content) {
		//modify
		this.cno = cno;
		this.content = content;

	}
	public CommentVO(int cno, int bno, String writer, String content, String regdate) {
		//all
		this(cno,writer,content);
		this.bno = bno;
		this.regdate = regdate;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CommentVO [cno=" + cno + ", bno=" + bno + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + "]";
	}
	
}
