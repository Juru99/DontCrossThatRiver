package dptr;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dptr.News;

public class newsflatform extends JFrame{	
	static int articleX = 0; //ù ��° ��� ������ ��ġ�� X��ǥ
	static int articleY = 0; //ù ��° ��� ������ ��ġ�� Y��ǥ
	static String[] articlelink; //����� �ּҸ� ������ ���ڿ� �迭
	/*���콺 �����ʰ� �� �迭�� Ư�� �ε����� ����� ���������� �ּҸ� ������ �� �ֵ���
	   Ŭ���� ��𼭳� ������ �� �ִ� Ŭ���� ������ ������־���.
	 */
	//JFrame newsflat = new JFrame();
	public void openNews(String link) { //����� �ּҿ� �ش��ϴ� �������� �� �������� ���� �����ش�.
		try {
			Desktop.getDesktop().browse(new URI(link)); 
			//����ũž�� URI��ü�� ���� �ּҸ� Ž���ϵ��� �Ѵ�.
			/*URI��ü�� ���ڿ�(�ּ�) �м��� ������ ���� ��ü�̴�. �ּҰ� �����ϴ� ���ҽ��� �������� ���Ѵ�. 
			 * -> ũ�Ѹ��ؼ� ������ ������ �� ����.*/
		}catch(IOException e){
			e.printStackTrace(); //����
		}catch(URISyntaxException e) {
			e.printStackTrace(); //ó��
		}
	}
	
	public newsflatform(){//���� �÷��� ������
		News news = new News(); //News��ü ����
		
		String[] articletitle = news.Crawlering();//���ڿ� �迭�� ��� ���� ����
		articlelink = news.HrefCrawlering(); //���ڿ� �迭�� ����� �ּ� ����
		
		//�� ����� ����� �;��µ� �����ϸ� �� ����̾��ٰ� JLabel�߰��Ǹ鼭 ȸ�� ������� ���ع��� ;;
		
		if(articletitle.length == 0) {
			JLabel noarticle = new JLabel("���� ��ϵ� �ֿ� ������ �����ϴ�. ���̹��� �����ϼ���.");
			noarticle.setBounds(articleX  , articleY , 400 ,19);
			add(noarticle);
		}
		
		JLabel[] articles = new JLabel[articletitle.length]; //��� ������ ������ JLabel�迭�� ũ��� ��� ������ ������ ���ƾ� �Ѵ�.
		
		for(int i = 0 ; i < articles.length ; i++) {//�����ӿ� ���̺��� �߰��ϴ� �ݺ���
			
			articles[i] = new JLabel(articletitle[i]);//JLabel�� ��� ���� ����
			articles[i].setBounds(articleX  , articleY , 400 ,19);
			//��� ������ ��ġ�� ũ�� ����
			String templink = articlelink[i];
			//X��ǥ�� �����ϰ� Y��ǥ�� 19px�� ������ ��
			articleY += 19;
			if(articletitle[i] == null) {
				articles[i].setVisible(false);
			}
			articles[i].addMouseListener(new MouseListener() {
			//��� ���� ���콺 ������ �߰�	
				@Override
				public void mouseClicked(MouseEvent arg) {
					openNews(templink);
				}//���콺 Ŭ�� �̿ܿ��� ���� �� ��

				@Override
				public void mouseEntered(MouseEvent e) {}

				@Override
				public void mouseExited(MouseEvent e) {}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {}
			});//addMouseListener
			
			addWindowListener(new WindowAdapter() {
				@Override

				public void windowClosing(WindowEvent e) {  // �̺�Ʈ���α׷�
					System.gc();
				}			
			});
			
			add(articles[i]); //�����ӿ� ��� ���� ����
			
			setLayout(null); //��ġ������ ����
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("����");
			setBounds(0, 0, 500, 360); 
			setBackground(Color.white); 
			setVisible(true);
			
		}//for
		
		//wraper.setVisible(true); //��Ÿ���� ��!
		
	}//���� �÷��� ������
	
	public static void main(String args[]) 
	{
		new newsflatform();
	}//mm
	
}//class newsflatform
