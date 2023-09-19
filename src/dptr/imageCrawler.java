package dptr;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

import javax.imageio.ImageIO;
import javax.lang.model.element.Element;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.jsoup.*;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class imageCrawler extends Crawler{//크롤러 클래스 상속받는 이미지 크롤러 클래스

	private Crawler origin;//웹 페이지의 주소를 문자열로 저장한 크롤러 
	private URL imgurl; //이미지의 경로를 URL객체로 치환!

	private ImageIcon image = new ImageIcon();//이미지를 저장할 이미지 아이콘 객체
	public imageCrawler() {	}

	public imageCrawler(String origin) {
		this.origin = new dptr.Crawler("https://finance.naver.com/item/main.nhn?code="+origin);
	
		
	}
	
	public ImageIcon getImage() {
		return image;
	}

	public ImageIcon searchImage(String plz){
				
		try {
			Document doc;
			Crawler str;
			str = new dptr.Crawler("https://finance.naver.com/item/main.nhn?code="+plz);
			doc = Jsoup.connect(str.getDestination()).get();//DOM을 문서 객체에 저-장
			
			Elements target = doc.select("div.chart"); //img태그를 감싸고 있는 요소를 선택! <- 웹 페이지에 따라 다를 수 있다.			
			Elements img = target.select("img");//img태그 선택하여 HTML요소 배열에 저----장

			for(org.jsoup.nodes.Element x : img) {//HTML요소 배열 img에 대한 for in 반복문

				
				
				String url = x.getElementsByAttribute("src").attr("src");
				//이미지의 경로를 src속성으로부터 반환받는다.
				URL imgurl = new URL(url);//이미지 경로를 저장하는 URL객체
				
				ImageIcon temp = new ImageIcon(imgurl); //URL의 경로에 있는 이미지를 이미지 아이콘으로 치환

				
				image = temp; //이미지 속성에 저--장
			}//for
		}catch(Exception e) {
			e.printStackTrace(); //이건 어떤 예외 처리일까?
		}
		
	return image;//이미지 반환!!

	}
	








	
	
}
