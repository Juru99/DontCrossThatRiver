package job;

import java.util.Random;
public class CollegeStudent extends Student{

	public void scholarship() {
		int TempMoney=super.getMoney();
		Random rnd=new Random();
		
		int data=rnd.nextInt(10)+1;
	
		if(data==1) {
			TempMoney=TempMoney+2000000;
			super.setMoney(TempMoney);//���� �ɰ� ���� ������; �غ��� ���� �ִ� �� Ȯ�� �ȵǸ� �������ε� ã��
			System.out.println("���б� ����!");
		}else {
			System.out.println("���б� ����!");
		}
	}
	
	
	/*public static void main(String[] args) {
		CollegeStudent std=new CollegeStudent();
		std.scholarship();
		System.out.println(std.getMoney());
	}*/
}
