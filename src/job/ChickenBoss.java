package job;

import java.util.Random;

public class ChickenBoss extends OfficeWorker{

	public void SuwonKingGalbi() {
		int pay=super.getMoney();
		Random rnd=new Random();
		int data=rnd.nextInt(100)+1;
		
		if(data==7) {
			pay=pay+3000000;
			super.setMoney(pay);//문제 될거 같음 ㅇㅅㅇ; 해보고 문제 있는 지 확인 안되면 동적바인딩 찾기
			System.out.println("수원왕갈비 성공!");
		}else {
			System.out.println("수원왕갈비 실패!");
		}	
	}	
}
