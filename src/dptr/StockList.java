package dptr;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StockList extends JFrame {
	private JButton [] tradeBtns = new JButton[2];
	private String [] tradeName = {"매수","매도"};
	private String [] crawlWhat = {"028050","034020","006800","030200","000100","066570"}; //주소에 쓸 종목코드
	public Object[][] rowData;			//다양한데이터 넣으려고 object
	public int count=0;			//2중포문쓰는용도 + 1차원값 2차원에 넣어줌
	private JFrame jFrame = new JFrame();
	private JPanel [] pans = new JPanel[2];
	public JTextField number = new JTextField("",5);
	String columnNames[]={ "날짜", "종가", "전일비", "시가","고가","저가","거래량" };
	public JTable jTable=new JTable();
	private static int p;

	public StockList() {
		
	}
	public StockList(int b) {	//MainStarts의 OpenStock함수에서 StockList(값)으로 객체 생성되면 전달된 인수로  버튼마다 크롤링 다르게 분리
		this.p = b;
		int x=0 ,y = 300 , width=30 , height = 30;
		
		JScrollPane jScollPane = new JScrollPane(InputValue());	//크롤링한 데이터를 테이블안에 넣어주는 함수
		ImageIcon icon = ImageTest();	//크롤링한 차트 이미지를 ImageIcon으로 리턴하는 함수
		JLabel imglbl = new JLabel(icon); //이미지 라벨에 삽입
		jFrame.add(jScollPane);
		pans[0] = new JPanel();	//차트가 들어갈 패널 상단에 위치
		pans[1] = new JPanel(); //매수 매도가 들어갈 패널 하단에 위치
		jFrame.add(pans[0],"North");
		jFrame.add(pans[1],"South");
		pans[1].add(number); //몇주 거래할건지 입력할 텍스트필드
		number.setBounds(0, 0, 100, 30);
		
		for(int i=0; i<tradeBtns.length; i++) {
			tradeBtns[i] = new JButton(tradeName[i]);
			pans[1].add(tradeBtns[i]);
			tradeBtns[i].addActionListener(l);
			tradeBtns[i].setBounds(x, y, width, height);
			x = x + 100;
			pans[i].setBackground(Color.WHITE);
		}
		
		pans[0].setBounds(x, y, width, height);
		pans[1].setBounds(x, y, 750, 100);
		pans[0].add(imglbl);
		//setLayout null; 깜박하고 안썻는데 위치 맘에들어서 냅뒀음
		jFrame.setBounds(0,0,750,510);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private ImageIcon ImageTest() {	//크롤링한 데이터를 테이블안에 넣어주는 함수
		ImageIcon img = new imageCrawler().searchImage(crawlWhat[p]);	//StockList(p)로 넘어온 p값으로  imageCrawler 클래스의 searchImage함수에 종목코드 전달
		return img;
	}

	private  JTable InputValue() {	//크롤링한 데이터를 테이블안에 넣어주는 함수
		String[] a=new Stock().Crawlering(crawlWhat[p]);	//크롤링한 데이터가 들어감
		rowData=new String[10][7];	//rowData 2차원배열 공간확보
  		for(int i=0; i<10; i++) { //크롤링한 데이터가 들어있는 a배열의 값을 2차원 배열 rowData에 삽입
			for(int j=0; j<7; j++) {			
				rowData[i][j]=a[count];
				count++;
			}
		}
  		
		jTable = new JTable(rowData, columnNames);
		
		return jTable;
	}
	ActionListener l = new ActionListener() {	//매수매도 버튼에 쓸 액션
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < tradeBtns.length; i++){
				if(isNumber(number.getText()) ) {	//정수인지 판별하는 함수 isNumber
					if(e.getSource() == tradeBtns[i]) {	
						if(Integer.parseInt(number.getText()) > 0) { //거래량이 0이상인지 판별
							double d = Double.parseDouble(jTable.getValueAt(0,3).toString()) * Integer.parseInt(number.getText());
							if(saveFile.OutStream.strmoney < d) { //보유자산 이상의 값을 거래하는것을 방지하는 조건
								saveFile.OutStream.strmoney = saveFile.OutStream.strmoney - d;
								saveFile.OutStream.strju[p] = String.valueOf(Integer.parseInt(saveFile.OutStream.strju[p]) + Integer.parseInt(number.getText()));
							}
							else
								JOptionPane.showMessageDialog(null, "보유자산이 부족합니다.");
						}
						else
							JOptionPane.showMessageDialog(null, "0이상 값을 입력해주세요.");
					}
					if(e.getSource() == tradeBtns[i]) {
						if(Integer.parseInt(number.getText()) > 0) { //거래량이 0이상인지 판별
							double d = Double.parseDouble(jTable.getValueAt(0,3).toString()) * Integer.parseInt(number.getText());
							if((Integer.parseInt(saveFile.OutStream.strju[p]) >= Integer.parseInt(number.getText()))) { //보유한 주 이상으로 파는것을 막는 조건
								saveFile.OutStream.strmoney = saveFile.OutStream.strmoney + d;
								saveFile.OutStream.strju[p] = String.valueOf(Integer.parseInt(saveFile.OutStream.strju[p]) - Integer.parseInt(number.getText()));
							}
							else
								JOptionPane.showMessageDialog(null, "보유주식이 부족합니다.");
						}
						else
							JOptionPane.showMessageDialog(null, "0이상 값을 입력해주세요.");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "정수를 입력해주세요.");
			}
		}
	};
	public static boolean isNumber(String str){//정수인지 체크하는 함수
        boolean result = false;
         
        try{
            Integer.parseInt(str) ;
            result = true ;
        }catch(Exception e){}
         
         
        return result ;
    }





	public static void main(String[] args)
	{
		new StockList(p);
		
	}
}
