package sample;

public class Greeter {
	private String format;	// 서식 저정
	
	public Greeter() {
		System.out.println("Greeter 생성됨 : " + this);
	}
	
	@Override
	public void finalize() {
		System.out.println("Greeter 소멸됨 : " + this);
	}
	
	// 서식 설정
	public void setFormat(String format) {
		this.format = format;
	}
	
	// 전달된 문자열을 서식에 적용하여 반환
	public String greet(String guest) {
		return String.format(format, guest);
	}
}
