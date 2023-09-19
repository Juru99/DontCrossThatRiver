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
	String jobName= "����"; //�̹��� ������ �Ʒ� selLbl�� �� �̸�
	JLabel jobLbl = new JLabel("<���� ����>");
	JLabel selLbl = new JLabel(jobName); //�̹��� ������ �Ʒ��� ���̺�
	JButton jobBtn = new JButton(new ImageIcon("imgs/solider.png")); // ���ι�ư �̹���
	JButton back = new JButton(new ImageIcon("imgs/backbtn.png")); // �ڷΰ��� ��ư �̹���
	MainStarts value; // MainStartsŬ������ ��ü�� ���� �����ϱ� ����
	
	public ArmyJobScreen(MainStarts value1) {
		this.value = value1; // ArmyJobScreen�� �����ڿ� �ִ� ������� ��Ƽ� MainStartsŬ���� ��ü�� ����
    	int Lx=160, Ly=70, Lw=200, Lh=50; //<��������>�� ��ġ
    	int Bx=180,By=180,Bw=90,Bh=90; //���ι�ư�� ��ġ
    	int Sx=210,Sy=270,Sw=90,Sh=30; // ���ζ��� ��ġ
    	int Kx=30, Ky=30, Kw=70,Kh=70; // �ڷΰ����ư�� ��ġ
    	
        add(jobLbl); add(selLbl); add(jobBtn); add(back);             
        back.addActionListener(l);  jobBtn.addActionListener(l);
          
        setLayout(null);
        jobLbl.setBounds(Lx, Ly, Lw, Lh); jobBtn.setBounds(Bx, By, Bw, Bh);
        selLbl.setBounds(Sx, Sy, Sw, Sh); back.setBounds(Kx, Ky, Kw, Kh); 
        jobBtn.setBorderPainted(false); jobBtn.setContentAreaFilled(false); 
        jobBtn.setFocusPainted(false);
        back.setBorderPainted(false); back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        //��ư���� ������ ĥ���� ����, ��ư���� ���빰 ĥ���� ����, ��ư������ �� �׵θ� �� ����
    	jobLbl.setFont(new Font("���� ���",Font.BOLD,25));
	}
	
	ActionListener l = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == jobBtn) value.Change("Sergeant"); 
			//jobBtn ��ư��ü�� ���� �׼��� ���ٸ� MainStartsŬ������ ��ü�� ���� Sergeant�� �ٲپ� ����
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