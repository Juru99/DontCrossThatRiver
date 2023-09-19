package dptr;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainScreen extends JPanel {
	JButton gameStart = new JButton("게임시작");
	JButton loadBtn = new JButton("불러오기");
	MainStarts value;
	public MainScreen(MainStarts value1) {
		this.value = value1;
		int x=0, y=190, width=180, height=50;
		int xx=0, yy=250,ww=180, hh=50;
		add(gameStart); add(loadBtn);
		gameStart.addActionListener(l);
		loadBtn.addActionListener(l);
		
        setLayout(null);
        gameStart.setBounds(x, y, width, height);
        gameStart.setBorderPainted(false); gameStart.setFocusPainted(false);
        gameStart.setContentAreaFilled(false);
        gameStart.setFont(new Font("휴먼 매직체",Font.BOLD,20));
        
        loadBtn.setBounds(xx, yy, ww, hh);
        loadBtn.setBorderPainted(false); loadBtn.setFocusPainted(false);
        loadBtn.setContentAreaFilled(false);
        loadBtn.setFont(new Font("휴먼 매직체",Font.BOLD,20));
	}
	ActionListener l = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == gameStart) value.Change("SelJob");
			if(e.getSource() == loadBtn) {
				if(saveFile.OutStream.strjob != null){
					value.Change("Load");
				}
				else {
					System.out.println("불러올 데이터가 없습니다");
				}
			
			}
		}
	};
	
	public void paintComponent(Graphics g) {
    	Dimension d = getSize();
    	ImageIcon image = new ImageIcon("imgs/MainImage.jpg");
    	g.drawImage(image.getImage(),0,0,d.width,d.height,null);
    }
}
