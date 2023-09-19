package job;

public class Job {
	private int money;
	private int []ju=new int[6];
	
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

	public int[] getJu() {
		return ju;
	}

	public void setJu(int[] ju) {
		this.ju = ju;
	}
	
	public Job() {
		for(int i=0; i<ju.length; i++) {
			ju[i]=0;
		}
	}
	
	
}
