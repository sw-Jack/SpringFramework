package board.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("BoardVo")
public class BoardVo {
	private int seq;
	
	@Length(min=2, max=5, message = "제목은 2자 이상, 5이하")
	private String title;
	
	@NotEmpty(message = "내용을 입력하세요.")
	private String content;
	
	@NotEmpty(message = "내용을 입력하세요.")
	private String writer;
	
	private int password;
	private Timestamp regDate;
	private int readCnt;
	
	public BoardVo(String title, String content, String writer, int password) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
	}

	public BoardVo() {}

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

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	@Override
	public String toString() {
		return "BoardVo [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", password=" + password + ", regDate=" + regDate + ", readCnt=" + readCnt + "]";
	}

	
}
