package dptr;
import job.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import job.CollegeStudent;
import job.HighStudent;
import saveFile.OutStream;

public class ArmyJobScreen extends JPanel {
	String jobName= "군인"; //이미지 아이콘 아래 selLbl에 들어갈 이름
	JLabel jobLbl = new JLabel("<직업 선택>");
	JLabel selLbl = new JLabel(jobName); //이미지 아이콘 아래의 레이블
	JButton jobBtn = new JButton(new ImageIcon("imgs/solider.png")); // 군인버튼 이미지
	JButton back = new JButton(new ImageIcon("imgs/backbtn.png")); // 뒤로가기 버튼 이미지
	MainStarts value; // MainStarts클래스의 객체로 값을 전달하기 위함
	
	public ArmyJobScreen(MainStarts value1) {
		this.value = value1; // ArmyJobScreen의 생성자에 있는 내용들을 담아서 MainStarts클래스 객체에 전달
    	int Lx=160, Ly=70, Lw=200, Lh=50; //<직업선택>의 위치
    	int Bx=180,By=180,Bw=90,Bh=90; //군인버튼의 위치
    	int Sx=210,Sy=270,Sw=90,Sh=30; // 군인라벨의 위치
    	int Kx=30, Ky=30, Kw=70,Kh=70; // 뒤로가기버튼의 위치
    	
        add(jobLbl); add(selLbl); add(jobBtn); add(back);             
        back.addActionListener(l);  jobBtn.addActionListener(l);
          
        setLayout(null);
        jobLbl.setBounds(Lx, Ly, Lw, Lh); jobBtn.setBounds(Bx, By, Bw, Bh);
        selLbl.setBounds(Sx, Sy, Sw, Sh); back.setBounds(Kx, Ky, Kw, Kh); 
        jobBtn.setBorderPainted(false); jobBtn.setContentAreaFilled(false); 
        jobBtn.setFocusPainted(false);
        back.setBorderPainted(false); back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        //버튼들의 윤곽선 칠하지 않음, 버튼들의 내용물 칠하지 않음, 버튼눌렀을 때 테두리 안 생김
    	jobLbl.setFont(new Font("맑은 고딕",Font.BOLD,25));
	}
	
	ActionListener l = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == jobBtn) value.Change("Sergeant"); 
			//jobBtn 버튼객체와 누른 액션이 같다면 MainStarts클래스의 객체의 값을 Sergeant로 바꾸어 저장
			if(e.getSource() == back) value.Change("back");		
			if(e.getSource()==jobBtn) {
				dptr.JobScreen.Player=new Soldier();
				saveFile.OutStream.strjob="Soldier";
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