package dptr;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import job.*;
import saveFile.OutStream;


public class NoJobScreen extends JPanel {
	String [] jobName = {"µµµÏ","°Ç¹°ÁÖ","³ë¼÷ÀÚ"};
	String [] jobEng = {"Thief","BuildingOwner","Homeless"};
	String [] imageName = {"thief.png","buildingOwner.png","Homeless.png"};
	JButton back = new JButton(new ImageIcon("imgs/backbtn.png")); // Kx
	JButton[] jobBtns = new JButton[3];
	JLabel[] selLbl = new JLabel[3];
	JLabel jobLbl = new JLabel("<Á÷¾÷ ¼±ÅÃ>");
	MainStarts values;
	
	public NoJobScreen(MainStarts value1) {
		this.values = value1;
    	int Lx=160, Ly=70, Lw=200, Lh=50;
    	int Bx=90,By=180,Bw=90,Bh=90,up=0;
    	int Sx=110,Sy=270,Sw=90,Sh=30;
    	int Kx=30, Ky=30, Kw=70,Kh=70; 
    	
        add(jobLbl); add(back);
        for (int i = 0; i < jobBtns.length; i++) {
            jobBtns[i] = new JButton(new ImageIcon("imgs/"+imageName[i]));
            selLbl[i] = new JLabel(jobName[i]);
            add(jobBtns[i]); add(selLbl[i]);
			jobBtns[i].addActionListener(l);
		}        
        back.addActionListener(l);
        
        setLayout(null);
        jobLbl.setBounds(Lx, Ly, Lw, Lh); back.setBounds(Kx, Ky, Kw, Kh); 
        back.setBorderPainted(false); back.setContentAreaFilled(false);
    	for (int i = 0; i < jobBtns.length; i++) {
    		jobBtns[i].setBounds(Bx+up, By, Bw, Bh); selLbl[i].setBounds(Sx+up, Sy, Sw, Sh);
    		jobBtns[i].setBorderPainted(false); jobBtns[i].setContentAreaFilled(false);
    		jobBtns[i].setFocusPainted(false);
    		up=up+100;
		} 
    	jobLbl.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,25));
	}
	ActionListener l = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < jobBtns.length; i++) {
				if(e.getSource() == jobBtns[i]) values.Change(jobEng[i]);
				if(e.getSource() == back) values.Change("back");
			}
			if(e.getSource()==jobBtns[0]) {
				dptr.JobScreen.Player=new Thief();
				saveFile.OutStream.strjob="Thief";
				try {
					OutStream out=new OutStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getSource()==jobBtns[1]) {
				dptr.JobScreen.Player=new Landlord();
				saveFile.OutStream.strjob="Landlord";
				try {
					OutStream out=new OutStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getSource()==jobBtns[2]) {
				dptr.JobScreen.Player=new Unemployed();
				saveFile.OutStream.strjob="Unemployed";
				try {
					OutStream out=new OutStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};
}