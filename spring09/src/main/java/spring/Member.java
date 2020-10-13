package spring;

import java.util.Date;

public class Member {
	private Long id;	//기본키 역할
	private String email;
	private String password;
	private String name;
	private Date regDate;
	
	public Member() {}	//마이바티스에서는 POJO기반으로 동작하므로 디폴트 생성자가 필요함
	
	public Member(
			String email, 
			String password, 
			String name, 
			Date regDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.regDate = regDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public boolean matchPassword(String pwd) {
		return this.password.equals(pwd);
	}
	
	//암호 변경 기능
	public void changePassword(String oldPassword, String newPassword) {
		if(!password.equals(oldPassword)) {
			throw new IdPasswordNotMatchingException();
		}
		this.password = newPassword;
	}
	
	//객체 설명을 반환 용도
	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", registerDate="
				+ regDate + "]";
	}
	
	
	
}
