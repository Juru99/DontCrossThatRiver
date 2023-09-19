package job;

public class Unemployed extends Job {
	
	private int testMoney;
	
	
	
	public int getTestMoney() {
		return testMoney;
	}



	public void setTestMoney(int testMoney) {
		this.testMoney = testMoney;
	}


	public void Unemployed1() {
		super.setMoney(this.getTestMoney()); 
	}	
}
