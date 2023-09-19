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
         setOpaque(false); //그림을 표시하게 설정,투명하게 조절
         super.paintComponent(g);
     }
	 
	public HanRiver(MainStarts value1) {
		this.value = value1;
		int Kx=400, Ky=370, Kw=70,Kh=70;
	        //배경 Panel 생성후 컨텐츠페인으로 지정      
		if(doubleTemp>20) {
			icon=new ImageIcon("imgs/HotRiver.jpg");
			comment="오늘 한강은 더워요! 냉면을 먹으면 좋겠어요!";
			riverTemp=new JLabel("<html><head><style>p{margin:0 auto;}.temp{text-align:center;}."
					+ "test{font-size:12px;}</style></head><body><p class=temp>"+showTemp+"ºC"+""
							+ "</p><p class=test>"+comment+"</p></body></html>",JLabel.CENTER);
		}else if(doubleTemp>10) {
			icon=new ImageIcon("imgs/CoolRiver.jpg");
			comment="오늘은 너무 시원해요! 수영해도 되겠어요!";
			riverTemp=new JLabel("<html><head><style>p{margin:0 auto;}."
					+ "temp{text-align:center;}.test{font-size:12px;}</style></head><body><p class=temp>"+showTemp+"ºC"+
					"</p><p class=test>"+comment+"</p></body></html>",JLabel.CENTER);
		}else {
			icon=new ImageIcon("imgs/ColdRiver.jpg");
			comment="오늘은 매우 춥네요.. 들어가면 감기걸려요!";
			riverTemp=new JLabel("<html><head><style>p{margin:0 auto;}."
					+ "temp{text-align:center;}.test{font-size:12px;}</style></head><body><p class=temp>"+showTemp+"ºC"+
					"</p><p class=test>"+comment+"</p></body></html>",JLabel.CENTER);
		}
		add(back); back.addActionListener(l);
		back.setBounds(Kx, Ky, Kw, Kh); 
		titleTemp.setForeground(new Color(255,255,255));
		titleTemp.setFont(new Font("맑은 고딕",Font.PLAIN,20));
		setLayout(new BorderLayout());
		riverTemp.setForeground(new Color(255,255,255));
		riverTemp.setFont(new Font("맑은 고딕",Font.PLAIN,20));
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
