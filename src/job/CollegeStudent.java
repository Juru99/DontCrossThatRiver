package job;

import java.util.Random;
public class CollegeStudent extends Student{

	public void scholarship() {
		int TempMoney=super.getMoney();
		Random rnd=new Random();
		
		int data=rnd.nextInt(10)+1;
	
		if(data==1) {
			TempMoney=TempMoney+2000000;
			super.setMoney(TempMoney);//문제 될거 같음 ㅇㅅㅇ; 해보고 문제 있는 지 확인 안되면 동적바인딩 찾기
			System.out.println("장학금 성공!");
		}else {
			System.out.println("장학금 실패!");
		}
	}
	
	
	/*public static void main(String[] args) {
		CollegeStudent std=new CollegeStudent();
		std.scholarship();
		System.out.println(std.getMoney());
	}*/
}
