package springquiz;

public class VersionPrinter {
	private int majorVersion;
	private int minorVersion;
	
	public VersionPrinter(int majorVersion, int minorVersion) {
		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
	}
	
	public void print() {
		System.out.printf("프로그램 버전 %d.%d\n", majorVersion, minorVersion);
	}
}
