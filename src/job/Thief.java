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
			System.out.println("�˰� ���߽��ϴ�! ���� ���� ����ϴ�.");
		}
		else if(lucky<=30) {
			super.setMoney(pocket);
			System.out.println("��~ ���ָ� �Ͽ����ϴ�. ���� �����մϴ�.");
		}else if(lucky>50) {
			lucky=lucky+150000000;
			super.setMoney(lucky);
			System.out.println("������ ���� ���Ҿ����ϴ�! 1500������ �����Ͽ����ϴ�.");
		}else {
			System.out.println("�߸��� �����Դϴ�.");
		} 
		//����-50%(success) �˰�-20%(judge) ����-30%(pass)
	}
	
	
	
	

}
