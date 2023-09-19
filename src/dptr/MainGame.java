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
	String [] btnsName = {"���ΰ�ħ","Ư���ɷ�","Ȩ","�ֽĽ���","��������","�Ѱ�"};
	String [] btnEng = {"Refresh","Ability","Home","Stock","Interest","River"};
	String [] imageName = {"refresh.png","ability.png","home.png",
	"stock.png","invester1.png","OneRiver.png"};
	JLabel timerLbl = new JLabel(); //���� �ð��� ����ִ� ��
	JLabel tipLbl = new JLabel(); //���� ����ִ� ��
	JLabel jobData = new JLabel();
	JLabel moneyData = new JLabel();
	JLabel juData = new JLabel();
	JButton [] mainBtns = new JButton[6];
	private String[] strTip= {"¥�� ������ �� ������!","�Ѱ����� ���� ���ϴ�","���̴� �Ӷ� ���õ� �Ӷ�",
	"���� �л����ڰ� ���ϱ��?","�ڽ����� Ȯ���ϼ���","�浿���� �ŸŴ� �ݹ��Դϴ�.","������ ���ι������� ������."};	
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
		TT(); //�������̽� Tip�� �߻�޼ҵ�
		add(timerLbl); add(tipLbl);
		for (int i = 0; i < mainBtns.length; i++) {
            mainBtns[i] = new JButton(new ImageIcon("imgs/"+imageName[i]));
            add(mainBtns[i]);
			mainBtns[i].addActionListener(l);
		}
		jobData = new JLabel();
		moneyData = new JLabel();
		juData = new JLabel();
		jobData.setText("����:      " + saveFile.OutStream.inline[0]);
		moneyData.setText("���� �ݾ�: " + saveFile.OutStream.inline[1]);
		//juData.setText(saveFile.OutStream.inline[2]);// �迭�� ��������� ���ܼ� ���ľ���
			
		
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
    	timerLbl.setFont(new Font("���� ���",Font.BOLD,25));	  		
    	
    	jobData.setBounds(Jx, Jy, Jw, Jh);
    	moneyData.setBounds(Jx, Jy+20, Jw, Jh);
    	juData.setBounds(Jx, Jy+40, Jw, Jh);
	}
	
	public MainGame(JLabel value) {
		this.timerLbl = value;
	}
   	int iii=0; // �����Ƽ Ƚ�� ����
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
			c = Calendar.getInstance();	//�ý����� ��¥�� �ð������� �޾ƿ� �� �ִ� �޼ҵ�	
			hour = c.get(Calendar.HOUR);
			min = c.get(Calendar.MINUTE);
			sec = c.get(Calendar.SECOND);
			TimeString = hour+":"+min+":"+sec;			
			timerLbl.setText(TimeString); 
			
			try {
				Thread.sleep(1000); //1���ֱ�� ����
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
	
	@Override
	public void TT() {
		Timer timer = new Timer();
		Random rnd=new Random(); //���� �������� �߰� ���� ����
		TimerTask task = new TimerTask() {
				@Override
				public void run() {
					tipLbl.setText(strTip[rnd.nextInt(strTip.length)]); 
					//nextInt�� ��Ʈ���ڷḦ �Է¹��� �� ���
				}
		};
		timer.schedule(task, 1000,3000); 
		//schedule(Ÿ�̸��� ������ ������ �� �ִ� TimerTask,1�� ��� ,3�ʸ��� run()�� �����Ͽ� ���� �޾ƿ�)
		
    	tipLbl.setBounds(0,40,400,50);
    	tipLbl.setFont(new Font("���� ���",Font.BOLD,20));
	}
}