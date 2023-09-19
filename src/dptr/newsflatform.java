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
	static int articleX = 0; //첫 번째 기사 제목이 위치할 X좌표
	static int articleY = 0; //첫 번째 기사 제목이 위치할 Y좌표
	static String[] articlelink; //기사의 주소를 저장할 문자열 배열
	/*마우스 리스너가 이 배열의 특정 인덱스에 저장된 웹브라우저의 주소를 참조할 수 있도록
	   클래스 어디서나 접근할 수 있는 클래스 변수로 만들어주었다.
	 */
	//JFrame newsflat = new JFrame();
	public void openNews(String link) { //기사의 주소에 해당하는 페이지를 웹 브라우저를 통해 보여준다.
		try {
			Desktop.getDesktop().browse(new URI(link)); 
			//데스크탑이 URI객체가 가진 주소를 탐색하도록 한다.
			/*URI객체는 문자열(주소) 분석과 조작을 위한 객체이다. 주소가 참조하는 리소스를 가져오지 못한다. 
			 * -> 크롤링해서 내용을 가져올 수 없다.*/
		}catch(IOException e){
			e.printStackTrace(); //예외
		}catch(URISyntaxException e) {
			e.printStackTrace(); //처리
		}
	}
	
	public newsflatform(){//뉴스 플랫폼 생성자
		News news = new News(); //News객체 생성
		
		String[] articletitle = news.Crawlering();//문자열 배열에 기사 제목 저장
		articlelink = news.HrefCrawlering(); //문자열 배열에 기사의 주소 저장
		
		//흰 배경을 만들고 싶었는데 실행하면 흰 배경이었다가 JLabel추가되면서 회색 배경으로 변해버림 ;;
		
		if(articletitle.length == 0) {
			JLabel noarticle = new JLabel("현재 등록된 주요 뉴스가 없습니다. 네이버에 문의하세요.");
			noarticle.setBounds(articleX  , articleY , 400 ,19);
			add(noarticle);
		}
		
		JLabel[] articles = new JLabel[articletitle.length]; //기사 제목을 삽입할 JLabel배열의 크기는 기사 제목의 개수와 같아야 한다.
		
		for(int i = 0 ; i < articles.length ; i++) {//프레임에 레이블을 추가하는 반복문
			
			articles[i] = new JLabel(articletitle[i]);//JLabel에 기사 제목 삽입
			articles[i].setBounds(articleX  , articleY , 400 ,19);
			//기사 제목의 위치와 크기 지정
			String templink = articlelink[i];
			//X좌표는 동일하고 Y좌표만 19px씩 간격을 둠
			articleY += 19;
			if(articletitle[i] == null) {
				articles[i].setVisible(false);
			}
			articles[i].addMouseListener(new MouseListener() {
			//기사 제목에 마우스 리스너 추가	
				@Override
				public void mouseClicked(MouseEvent arg) {
					openNews(templink);
				}//마우스 클릭 이외에는 구현 안 함

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

				public void windowClosing(WindowEvent e) {  // 이벤트프로그램
					System.gc();
				}			
			});
			
			add(articles[i]); //프레임에 기사 제목 삽입
			
			setLayout(null); //배치관리자 없고
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("뉴스");
			setBounds(0, 0, 500, 360); 
			setBackground(Color.white); 
			setVisible(true);
			
		}//for
		
		//wraper.setVisible(true); //나타나라 얍!
		
	}//뉴스 플랫폼 생성자
	
	public static void main(String args[]) 
	{
		new newsflatform();
	}//mm
	
}//class newsflatform
