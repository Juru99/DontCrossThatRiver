package job;

import java.util.Random;

public class ChickenBoss extends OfficeWorker{

	public void SuwonKingGalbi() {
		int pay=super.getMoney();
		Random rnd=new Random();
		int data=rnd.nextInt(100)+1;
		
		if(data==7) {
			pay=pay+3000000;
			super.setMoney(pay);//���� �ɰ� ���� ������; �غ��� ���� �ִ� �� Ȯ�� �ȵǸ� �������ε� ã��
			System.out.println("�����հ��� ����!");
		}else {
			System.out.println("�����հ��� ����!");
		}	
	}	
}
