package dptr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HanRiver extends JPanel{
	MainStarts value;
	River getRiver=new River();
	String showTemp=getRiver.Crawlering();
	ImageIcon icon;
	double doubleTemp=Double.parseDouble(showTemp);
	String comment="";
	JLabel riverTemp;
	JLabel titleTemp=new JLabel("Han.River Temp",JLabel.CENTER);
	JButton back = new JButton(new ImageIcon("imgs/backbtn.png"));
	
	//JScrollPane realback=new JScrollPane(background);
	
	

	 public void paintComponent(Graphics g) {
         g.drawImage(icon.getImage(), 0, 0, null);
         setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
         super.paintComponent(g);
     }
	 
	public HanRiver(MainStarts value1) {
		this.value = value1;
		int Kx=400, Ky=370, Kw=70,Kh=70;
	        //��� Panel ������ �������������� ����      
		if(doubleTemp>20) {
			icon=new ImageIcon("imgs/HotRiver.jpg");
			comment="���� �Ѱ��� ������! �ø��� ������ ���ھ��!";
			riverTemp=new JLabel("<html><head><style>p{margin:0 auto;}.temp{text-align:center;}."
					+ "test{font-size:12px;}</style></head><body><p class=temp>"+showTemp+"��C"+""
							+ "</p><p class=test>"+comment+"</p></body></html>",JLabel.CENTER);
		}else if(doubleTemp>10) {
			icon=new ImageIcon("imgs/CoolRiver.jpg");
			comment="������ �ʹ� �ÿ��ؿ�! �����ص� �ǰھ��!";
			riverTemp=new JLabel("<html><head><style>p{margin:0 auto;}."
					+ "temp{text-align:center;}.test{font-size:12px;}</style></head><body><p class=temp>"+showTemp+"��C"+
					"</p><p class=test>"+comment+"</p></body></html>",JLabel.CENTER);
		}else {
			icon=new ImageIcon("imgs/ColdRiver.jpg");
			comment="������ �ſ� ��׿�.. ���� ����ɷ���!";
			riverTemp=new JLabel("<html><head><style>p{margin:0 auto;}."
					+ "temp{text-align:center;}.test{font-size:12px;}</style></head><body><p class=temp>"+showTemp+"��C"+
					"</p><p class=test>"+comment+"</p></body></html>",JLabel.CENTER);
		}
		add(back); back.addActionListener(l);
		back.setBounds(Kx, Ky, Kw, Kh); 
		titleTemp.setForeground(new Color(255,255,255));
		titleTemp.setFont(new Font("���� ���",Font.PLAIN,20));
		setLayout(new BorderLayout());
		riverTemp.setForeground(new Color(255,255,255));
		riverTemp.setFont(new Font("���� ���",Font.PLAIN,20));
		add(titleTemp,"North");
		add(riverTemp,"Center");	
	}
	ActionListener l = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == back) value.Change("Refresh");			
		}
	};
}
