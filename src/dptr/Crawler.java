package dptr;

public class Crawler {//�� �������� �ּҸ� �����ϴ� ũ�ѷ� Ŭ����
	private String destination; //������ URL�� ������ ���ڿ�
	
	private String itemserial; //���� �ڵ带 ������ ���ڿ�
	
	public String getItemserial() {
		return itemserial;
	}

	public void setItemserial(String itemserial) {
		this.itemserial = itemserial;
	}

	
	public Crawler() {}//�Ű������� ���� �����ڸ� �������� ������ �Ű������� �ִ� �����ڸ� ����� �� ����.

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
