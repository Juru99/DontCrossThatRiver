package job;

import java.util.Random;

public class Thief extends Unemployed{
	
	public void Lupine() {
		int pocket=super.getMoney();
		super.setMoney(pocket);
		Random rnd=new Random();
		int lucky=rnd.nextInt(100)+1;

		
		
		if(lucky<=20) {
			pocket=0;
			super.setMoney(pocket);
			System.out.println("검거 당했습니다! 돈을 전부 뺏깁니다.");
		}
		else if(lucky<=30) {
			super.setMoney(pocket);
			System.out.println("휴~ 도주를 하였습니다. 돈은 유지합니다.");
		}else if(lucky>50) {
			lucky=lucky+150000000;
			super.setMoney(lucky);
			System.out.println("은행의 돈을 빼았었습니다! 1500만원을 습득하였습니다.");
		}else {
			System.out.println("잘못된 접근입니다.");
		} 
		//성공-50%(success) 검거-20%(judge) 도주-30%(pass)
	}
	
	
	
	

}
