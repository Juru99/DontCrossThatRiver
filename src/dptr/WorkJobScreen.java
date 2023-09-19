package dptr;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import job.ChickenBoss;
import job.HighStudent;
import job.Professor;

public class WorkJobScreen extends JPanel {
	String [] jobName = {"치킨집사장","교수"};
	String [] jobEng = {"ChickenWork","ProfessorWork"};
	String [] imageName = {"chickenOwner.png","professor.png"};
	JButton back = new JButton(new ImageIcon("imgs/backbtn.png"));
	JButton[] jobBtns = new JButton[2];
	JLabel[] selLbl = new JLabel[2];
	JLabel jobLbl = new JLabel("<직업 선택>");			
	MainStarts values;
	static Object Player;
	public WorkJobScreen(MainStarts value1) {
		this.values = value1;
    	int Lx=160, Ly=70, Lw=200, Lh=50;
    	int Bx=130,By=180,Bw=90,Bh=90,up=0;
    	int Sx=150,Sy=270,Sw=90,Sh=30;
    	int Kx=30, Ky=30, Kw=70,Kh=70;
    	
        add(jobLbl); add(back);
		for (int i = 0; i < jobBtns.length; i++) {
            jobBtns[i] = new JButton(new ImageIcon("imgs/"+imageName[i]));
            selLbl[i] = new JLabel(jobName[i]);           
            add(jobBtns[i]);
            add(selLbl[i]);
			jobBtns[i].addActionListener(l);
		}		
		back.addActionListener(l);
		
		setLayout(null);
    	back.setBounds(Kx, Ky, Kw, Kh);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        jobLbl.setBounds(Lx, Ly, Lw, Lh);
    	for (int i = 0; i < jobBtns.length; i++) {
    		jobBtns[i].setBounds(Bx+up, By, Bw, Bh); selLbl[i].setBounds(Sx+up, Sy, Sw, Sh);   		    		
    		jobBtns[i].setBorderPainted(false); jobBtns[i].setContentAreaFilled(false); 
    		jobBtns[i].setFocusPainted(false);
            up=up+100;
		}
    	jobLbl.setFont(new Font("맑은 고딕",Font.BOLD,25));
	}
	
	ActionListener l = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < jobBtns.length; i++) {
				if(e.getSource() == jobBtns[i]) values.Change(jobEng[i]);
				if(e.getSource() == back) values.Change("back");
				if(e.getSource() == jobBtns[0]) Player = new ChickenBoss();
				if(e.getSource() == jobBtns[1]) Player = new Professor();
			}
		}
	};
}