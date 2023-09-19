package dptr;

import job.*;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JobScreen extends JPanel {
	static Object Player;
	String [] jobName = {"학생","직장인","백수","군인"};
	String [] jobEng = {"Student","Worker","Jobless","Soldier"};
	String [] imageName = {"student.png","officeworker.png","jobless.png","solider.png"};
	JLabel jobLbl = new JLabel("<직업 선택>"); 
	JLabel[] selLbl = new JLabel[4]; 
	JButton[] jobBtns = new JButton[4]; 
	MainStarts values;
	static int pmoney;
    static int pju;
	public JobScreen(MainStarts value1) {
		this.values = value1;
		int Lx=160, Ly=70, Lw=200, Lh=50;
    	int Bx=40,By=180,Bw=90,Bh=90,up=0;
    	int Sx=70,Sy=270,Sw=90,Sh=30;
    	//int money=0;
		add(jobLbl);
		for(int i = 0; i < jobBtns.length ; i++) {
			selLbl[i] = new JLabel(jobName[i]);
			jobBtns[i] = new JButton(new ImageIcon("imgs/"+imageName[i]));
			add(jobBtns[i]);
			add(selLbl[i]);
			jobBtns[i].addActionListener(l);
		}
		
		setLayout(null);
    	jobLbl.setBounds(Lx, Ly, Lw, Lh);
    	for (int i = 0; i < jobBtns.length; i++) {
    		jobBtns[i].setBounds(Bx+up, By, Bw, Bh); selLbl[i].setBounds(Sx+up, Sy, Sw, Sh);
    		jobBtns[i].setBorderPainted(false); jobBtns[i].setContentAreaFilled(false);
    		jobBtns[i].setFocusPainted(false);

    		up=up+100;  //일정하게 위치값 증가   
		}
        jobLbl.setFont(new Font("맑은 고딕",Font.BOLD,25));
       
    }
	
	ActionListener l = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < jobBtns.length; i++) {
				if(e.getSource() == jobBtns[i]) values.Change(jobEng[i]);
			}
			if(e.getSource() == jobBtns[0]) Player=new Student();
			if(e.getSource() == jobBtns[1]) Player=new OfficeWorker();
			if(e.getSource() == jobBtns[2]) Player=new Homeless();
			if(e.getSource() == jobBtns[3]) Player=new Soldier();
		}
	};
}