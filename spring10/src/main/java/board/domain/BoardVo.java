package board.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("BoardVo")	// Mybatis에서 제공하는 Annotation
public class BoardVo {
	private int seq;
	private String title;
	private String content;
	private String writer;
	private int password;
	private Timestamp regDate;
	private int cnt;	// 조회수
	
	public BoardVo() {} // MyBatis 사용을 위한 디폴트 생성자 

	public BoardVo(String title, String content, String writer, int password) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
}
