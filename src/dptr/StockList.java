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
	private String [] tradeName = {"�ż�","�ŵ�"};
	private String [] crawlWhat = {"028050","034020","006800","030200","000100","066570"}; //�ּҿ� �� �����ڵ�
	public Object[][] rowData;			//�پ��ѵ����� �������� object
	public int count=0;			//2���������¿뵵 + 1������ 2������ �־���
	private JFrame jFrame = new JFrame();
	private JPanel [] pans = new JPanel[2];
	public JTextField number = new JTextField("",5);
	String columnNames[]={ "��¥", "����", "���Ϻ�", "�ð�","��","����","�ŷ���" };
	public JTable jTable=new JTable();
	private static int p;

	public StockList() {
		
	}
	public StockList(int b) {	//MainStarts�� OpenStock�Լ����� StockList(��)���� ��ü �����Ǹ� ���޵� �μ���  ��ư���� ũ�Ѹ� �ٸ��� �и�
		this.p = b;
		int x=0 ,y = 300 , width=30 , height = 30;
		
		JScrollPane jScollPane = new JScrollPane(InputValue());	//ũ�Ѹ��� �����͸� ���̺�ȿ� �־��ִ� �Լ�
		ImageIcon icon = ImageTest();	//ũ�Ѹ��� ��Ʈ �̹����� ImageIcon���� �����ϴ� �Լ�
		JLabel imglbl = new JLabel(icon); //�̹��� �󺧿� ����
		jFrame.add(jScollPane);
		pans[0] = new JPanel();	//��Ʈ�� �� �г� ��ܿ� ��ġ
		pans[1] = new JPanel(); //�ż� �ŵ��� �� �г� �ϴܿ� ��ġ
		jFrame.add(pans[0],"North");
		jFrame.add(pans[1],"South");
		pans[1].add(number); //���� �ŷ��Ұ��� �Է��� �ؽ�Ʈ�ʵ�
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
		//setLayout null; �����ϰ� �ț��µ� ��ġ ������ ������
		jFrame.setBounds(0,0,750,510);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private ImageIcon ImageTest() {	//ũ�Ѹ��� �����͸� ���̺�ȿ� �־��ִ� �Լ�
		ImageIcon img = new imageCrawler().searchImage(crawlWhat[p]);	//StockList(p)�� �Ѿ�� p������  imageCrawler Ŭ������ searchImage�Լ��� �����ڵ� ����
		return img;
	}

	private  JTable InputValue() {	//ũ�Ѹ��� �����͸� ���̺�ȿ� �־��ִ� �Լ�
		String[] a=new Stock().Crawlering(crawlWhat[p]);	//ũ�Ѹ��� �����Ͱ� ��
		rowData=new String[10][7];	//rowData 2�����迭 ����Ȯ��
  		for(int i=0; i<10; i++) { //ũ�Ѹ��� �����Ͱ� ����ִ� a�迭�� ���� 2���� �迭 rowData�� ����
			for(int j=0; j<7; j++) {			
				rowData[i][j]=a[count];
				count++;
			}
		}
  		
		jTable = new JTable(rowData, columnNames);
		
		return jTable;
	}
	ActionListener l = new ActionListener() {	//�ż��ŵ� ��ư�� �� �׼�
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < tradeBtns.length; i++){
				if(isNumber(number.getText()) ) {	//�������� �Ǻ��ϴ� �Լ� isNumber
					if(e.getSource() == tradeBtns[i]) {	
						if(Integer.parseInt(number.getText()) > 0) { //�ŷ����� 0�̻����� �Ǻ�
							double d = Double.parseDouble(jTable.getValueAt(0,3).toString()) * Integer.parseInt(number.getText());
							if(saveFile.OutStream.strmoney < d) { //�����ڻ� �̻��� ���� �ŷ��ϴ°��� �����ϴ� ����
								saveFile.OutStream.strmoney = saveFile.OutStream.strmoney - d;
								saveFile.OutStream.strju[p] = String.valueOf(Integer.parseInt(saveFile.OutStream.strju[p]) + Integer.parseInt(number.getText()));
							}
							else
								JOptionPane.showMessageDialog(null, "�����ڻ��� �����մϴ�.");
						}
						else
							JOptionPane.showMessageDialog(null, "0�̻� ���� �Է����ּ���.");
					}
					if(e.getSource() == tradeBtns[i]) {
						if(Integer.parseInt(number.getText()) > 0) { //�ŷ����� 0�̻����� �Ǻ�
							double d = Double.parseDouble(jTable.getValueAt(0,3).toString()) * Integer.parseInt(number.getText());
							if((Integer.parseInt(saveFile.OutStream.strju[p]) >= Integer.parseInt(number.getText()))) { //������ �� �̻����� �Ĵ°��� ���� ����
								saveFile.OutStream.strmoney = saveFile.OutStream.strmoney + d;
								saveFile.OutStream.strju[p] = String.valueOf(Integer.parseInt(saveFile.OutStream.strju[p]) - Integer.parseInt(number.getText()));
							}
							else
								JOptionPane.showMessageDialog(null, "�����ֽ��� �����մϴ�.");
						}
						else
							JOptionPane.showMessageDialog(null, "0�̻� ���� �Է����ּ���.");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.");
			}
		}
	};
	public static boolean isNumber(String str){//�������� üũ�ϴ� �Լ�
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
