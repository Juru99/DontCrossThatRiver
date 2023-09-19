package job;

public class Landlord extends Unemployed {
	public Landlord() {
		super.setMoney(500000000);
	}
	
	
	public void NopainGetmoney() {

		int pay=super.getMoney();
		pay=pay+10000000;
		super.setMoney(pay);
		System.out.println("천만원 입금^^b");
	}
	
}
