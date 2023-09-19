package dptr;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import job.*;
import saveFile.*;

public class MainGame extends JPanel implements Runnable,Tip{
	String [] btnsName = {"새로고침","특수능력","홈","주식시장","관심종목","한강"};
	String [] btnEng = {"Refresh","Ability","Home","Stock","Interest","River"};
	String [] imageName = {"refresh.png","ability.png","home.png",
	"stock.png","invester1.png","OneRiver.png"};
	JLabel timerLbl = new JLabel(); //현재 시간을 담고있는 라벨
	JLabel tipLbl = new JLabel(); //팁을 담고있는 라벨
	JLabel jobData = new JLabel();
	JLabel moneyData = new JLabel();
	JLabel juData = new JLabel();
	JButton [] mainBtns = new JButton[6];
	private String[] strTip= {"짜잔 절대라는 건 없군요!","한강물은 정말 찹니다","개미는 뚠뚠 오늘도 뚠뚠",
	"과연 분산투자가 답일까요?","박스권을 확인하세요","충동적인 매매는 금물입니다.","뉴스에 과민반응하지 마세요."};	
	MainStarts values;	

	public MainGame(MainStarts value1) {
		this.values = value1;
    	int Lx=370, Ly=0, Lw=200, Lh=30;
    	int Bx=0,By=362,Bw=121,Bh=100,up2=0;
    	int x=0,y=0,w=90,h=30,up=0;
    	int Jx=300, Jy=100, Jw=100, Jh=20;
 
		MainGame Time = new MainGame(timerLbl);
		Thread my = new Thread(Time); 
		my.start();	
		TT(); //인터페이스 Tip의 추상메소드
		add(timerLbl); add(tipLbl);
		for (int i = 0; i < mainBtns.length; i++) {
            mainBtns[i] = new JButton(new ImageIcon("imgs/"+imageName[i]));
            add(mainBtns[i]);
			mainBtns[i].addActionListener(l);
		}
		jobData = new JLabel();
		moneyData = new JLabel();
		juData = new JLabel();
		jobData.setText("직업:      " + saveFile.OutStream.inline[0]);
		moneyData.setText("보유 금액: " + saveFile.OutStream.inline[1]);
		//juData.setText(saveFile.OutStream.inline[2]);// 배열로 변경사항이 생겨서 고쳐야함
			
		
		add(juData); add(jobData); add(moneyData);

		setLayout(null);
		for (int i = 0; i < mainBtns.length-4; i++) {
			mainBtns[i].setBounds(x+up, y, w, h);
			up = up+200;
		}
		for (int i = 2; i < mainBtns.length; i++) {
    		mainBtns[i].setBounds(Bx+up2, By, Bw, Bh);
    		up2=up2+121;
		}
		for (int i = 0; i < mainBtns.length; i++) {
			mainBtns[i].setBorderPainted(false);
			mainBtns[i].setContentAreaFilled(false);
			mainBtns[i].setFocusPainted(false);
		}
        timerLbl.setBounds(Lx, Ly, Lw, Lh);
    	timerLbl.setFont(new Font("맑은 고딕",Font.BOLD,25));	  		
    	
    	jobData.setBounds(Jx, Jy, Jw, Jh);
    	moneyData.setBounds(Jx, Jy+20, Jw, Jh);
    	juData.setBounds(Jx, Jy+40, Jw, Jh);
	}
	
	public MainGame(JLabel value) {
		this.timerLbl = value;
	}
   	int iii=0; // 어빌리티 횟수 제한
	ActionListener l = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < btnEng.length; i++){
				if(e.getSource() == mainBtns[i]) {
	    		values.Change(btnEng[i]);
				}
			}
			if(e.getSource() == mainBtns[1] && iii<3) {
				new Ability().GoAbility();				
				iii++;
			}
		}
	};
	@Override
	public void run() {
		int hour,min,sec;
		String TimeString;
		Calendar c;
		
		while (true) {
			c = Calendar.getInstance();	//시스템의 날짜와 시간정보를 받아올 수 있는 메소드	
			hour = c.get(Calendar.HOUR);
			min = c.get(Calendar.MINUTE);
			sec = c.get(Calendar.SECOND);
			TimeString = hour+":"+min+":"+sec;			
			timerLbl.setText(TimeString); 
			
			try {
				Thread.sleep(1000); //1초주기로 실행
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
	
	@Override
	public void TT() {
		Timer timer = new Timer();
		Random rnd=new Random(); //팁을 랜덤으로 뜨게 해줄 변수
		TimerTask task = new TimerTask() {
				@Override
				public void run() {
					tipLbl.setText(strTip[rnd.nextInt(strTip.length)]); 
					//nextInt는 인트형자료를 입력받을 때 사용
				}
		};
		timer.schedule(task, 1000,3000); 
		//schedule(타이머의 내용을 보여줄 수 있는 TimerTask,1초 대기 ,3초마다 run()을 실행하여 값을 받아옴)
		
    	tipLbl.setBounds(0,40,400,50);
    	tipLbl.setFont(new Font("맑은 고딕",Font.BOLD,20));
	}
}