package dptr;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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

public class StockInfo extends JPanel implements Runnable,Tip{
	//JPanel stockPan = new JPanel();
	String [] stockName = {"삼성엔지니어링","두산중공업","미래에셋대우","KT","유한양행","LG전자"};
	String [] stockEname = {"samsung","dusan","daewu","kt","yuhan","lg"};
	JButton[] stockBtns = new JButton[6];
	String [] btnEng = {"Refresh","Ability","Home","Stock","Interest","River"};	
	String [] imageName = {"refresh.png","ability.png","home.png",
			"stock.png","invester1.png","OneRiver.png"};
	JLabel timerLbl = new JLabel();
	JLabel tipLbl = new JLabel();
	JButton [] mainBtns = new JButton[6];
	private String[] strTip= {"짜잔 절대라는 건 없군요!","한강물은 정말 찹니다","개미는 뚠뚠 오늘도 뚠뚠",
			"과연 분산투자가 답일까요?","박스권을 확인하세요","충동적인 매매는 금물입니다.","뉴스에 과민반응하지 마세요."};
	

	MainStarts values;
	public StockInfo(MainStarts value1) {
		this.values = value1;
	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x=50 , y=100 , w=150 , h=50; 
		int ax=250 , ay=100 , aw=150 , ah=50;
	    int ww=500,hh=500,xx=((d.width-w)/2)+500,yy=((d.height-h)/2)-100;
	    int Lx=370, Ly=0, Lw=200, Lh=30;
    	int Bx=0,By=362,Bw=121,Bh=100,up2=0;
    	int cx=0,cy=0,cw=90,ch=30,up=0;
	    
    	MainGame Time = new MainGame(timerLbl);
		Thread my = new Thread(Time);
		my.start();	TT();
		
		add(timerLbl); add(tipLbl);	
		//add(stockPan);
		for (int i = 0; i < mainBtns.length; i++) {
            mainBtns[i] = new JButton(new ImageIcon("imgs/"+imageName[i]));
            add(mainBtns[i]);
			mainBtns[i].addActionListener(l);
		}
		
		for(int i=0; i<stockBtns.length; i++) {
			stockBtns[i] = new JButton(stockName[i]);
			add(stockBtns[i]);
			stockBtns[i].addActionListener(l);
		}
		for (int i = 0; i < mainBtns.length-4; i++) {
			mainBtns[i].setBounds(cx+up, cy, cw, ch);
			up = up+200;
		}
		for (int i = 2; i < mainBtns.length; i++) {
    		mainBtns[i].setBounds(Bx+up2, By, Bw, Bh);
    		up2=up2+121;
		}
		for (int i = 0; i < mainBtns.length; i++) {
			mainBtns[i].setBorderPainted(false);
			mainBtns[i].setContentAreaFilled(false);
		}
		setLayout(null);
		setBounds(x, y, 450, 390);
		for(int i=0; i<stockBtns.length; i++) {
			if(i % 2 == 0) {
			stockBtns[i].setBounds(x, y, w, h);
			y=y+90;
			}
			if(i % 2 == 1) {
			stockBtns[i].setBounds(ax, ay, aw, ah);
			ay=ay+90;
			}
		}
	       //setTitle("주식정보"); setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	       setBounds(xx, yy, ww, hh); setVisible(true);
	       timerLbl.setBounds(Lx, Ly, Lw, Lh);
	       timerLbl.setFont(new Font("맑은 고딕",Font.BOLD,25));
	}
	public StockInfo(JLabel value) {
		this.timerLbl = value;
	}
	
	ActionListener l = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < btnEng.length; i++){
				if(e.getSource() == mainBtns[i]) {
					values.Change(btnEng[i]);
				}
			}
			for (int i = 0; i < stockBtns.length; i++) {
				if(e.getSource() == stockBtns[i]) {
					values.OpenStock(stockEname[i]);
				}
			}
		}
	};
	@Override
	public void run() {
		int hour,min,sec;
		String TimeString;
		Calendar c;
		
		while (true) {
			c = Calendar.getInstance();		
			hour = c.get(Calendar.HOUR);
			min = c.get(Calendar.MINUTE);
			sec = c.get(Calendar.SECOND);
			TimeString = hour+":"+min+":"+sec;			
			timerLbl.setText(TimeString);
			
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
	@Override
	public void TT() {
		Timer timer = new Timer();
		Random rnd=new Random();
		TimerTask task = new TimerTask() {
				@Override
				public void run() {
					tipLbl.setText(strTip[rnd.nextInt(strTip.length)]);
				}
		};
		timer.schedule(task, 1000,3000);
		
    	tipLbl.setBounds(0,40,400,80);
    	tipLbl.setFont(new Font("맑은 고딕",Font.BOLD,20));
	}
	
}