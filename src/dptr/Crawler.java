package dptr;

public class Crawler {//웹 페이지의 주소를 저장하는 크롤러 클래스
	private String destination; //목적지 URL을 저장한 문자열
	
	private String itemserial; //종목 코드를 저장한 문자열
	
	public String getItemserial() {
		return itemserial;
	}

	public void setItemserial(String itemserial) {
		this.itemserial = itemserial;
	}

	
	public Crawler() {}//매개변수가 없는 생성자를 선언하지 않으면 매개변수가 있는 생성자를 사용할 수 없다.

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Crawler(String destination) {
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}
	
}
