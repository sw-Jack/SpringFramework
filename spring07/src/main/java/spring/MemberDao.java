package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
   
   private JdbcTemplate jdbcTemplate;
   
   public MemberDao(DataSource dataSource) {
      System.out.println("MemberDao객체 생성");
      // jdbcTemplate 객체에 DB 정보가 들어있는 DataSource 객체 dataSource 주입
      jdbcTemplate = new JdbcTemplate(dataSource);
   }
   
   //삽입
   public void insert(Member member) {
	   // select -> query / insert,update,delete -> update
	   KeyHolder keyHolder = new GeneratedKeyHolder();	// 옵션 ~
	   jdbcTemplate.update(
			   new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(
							"insert into member (ID, EMAIL, PASSWORD, NAME, REGDATE) " +
							"values (MEMBER_SEQ.nextval, ?, ?, ?, ?)",
							new String[] {"ID"});
					pstmt.setString(1, member.getEmail());
					pstmt.setString(2, member.getPassword());
					pstmt.setString(3, member.getName());
					pstmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
	

					return pstmt;
				}
			}, keyHolder);
	   Number keyValue = keyHolder.getKey();
	   member.setId(keyValue.longValue());
   }

   //조회
   // 중복 코드 처리 전
   /*
   public Member selectByEmail(String email) {
      List<Member> result = jdbcTemplate.query(
            "select * from MEMBER where EMAIL = ?", 
            new RowMapper<Member>() {
               @Override
               public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                  Member member = new Member(
                        rs.getString("EMAIL"),
                        rs.getString("PASSWORD"),
                        rs.getString("NAME"),
                        rs.getTimestamp("REGDATE"));
                  member.setId(rs.getLong("ID"));
                  return member;
               }
            }, email);
      return result.isEmpty() ? null : result.get(0);
   }
   */
   // 중복 코드 처리 후
   public Member selectByEmail(String email) {
	   List<Member> result = jdbcTemplate.query(
			   "select * from member where email=?",
			   new MemberRowMapper(), email);
	     return result.isEmpty() ? null : result.get(0);
			   
   }
   
   //수정(비밀번호 수정)
   public void update(Member member) {
      jdbcTemplate.update(
    		  "update member set name = ?, password = ? where email = ?",
    		  member.getName(),member.getPassword(),member.getEmail());
   }
   
   
   //삭제(탈퇴)
   
   
   
   
   //전체 조회
   // 중복 코드 처리 전
   /*
   public List<Member> selectAll(){
      List<Member> result = jdbcTemplate.query(
            "select * from MEMBER", 
            new RowMapper<Member>() {
               @Override
               public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                  Member member = new Member(
                        rs.getString("EMAIL"),
                        rs.getString("PASSWORD"),
                        rs.getString("NAME"),
                        rs.getTimestamp("REGDATE"));
                  member.setId(rs.getLong("ID"));
                  return member;
               }
            });
      return result;
   }
   */
   // 중복 코드 처리 후
   public List<Member> selectAll(){
	      List<Member> result = jdbcTemplate.query(
	            "select * from MEMBER", 
	      new MemberRowMapper());
	      return result;
   }
   
   
   public int count() {
	   // queryForObject : 결과가 하나만 나오는 경우에 유용, 결과값이 하나 이상 나오게 되면 에러
	   Integer cnt = jdbcTemplate.queryForObject(
			   "select count(*) from member", Integer.class);
	   return cnt;

   }
 
   
}