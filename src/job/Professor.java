package job;

import java.util.Random;

public class Professor extends OfficeWorker{

	public void NobelPrize() {
		int pay=super.getMoney();
		Random rnd=new Random();
		int data=rnd.nextInt(100)+1;
		
		if(data==1) { 
			pay=pay+100000000;
			super.setMoney(pay);
			System.out.println("노벨상 성공!");
		}else {
			System.out.println("노벨상 실패!");
		}

	}
	
	
	
}
