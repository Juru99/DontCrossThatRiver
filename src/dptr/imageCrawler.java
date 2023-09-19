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

public class imageCrawler extends Crawler{//ũ�ѷ� Ŭ���� ��ӹ޴� �̹��� ũ�ѷ� Ŭ����

	private Crawler origin;//�� �������� �ּҸ� ���ڿ��� ������ ũ�ѷ� 
	private URL imgurl; //�̹����� ��θ� URL��ü�� ġȯ!

	private ImageIcon image = new ImageIcon();//�̹����� ������ �̹��� ������ ��ü
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
			doc = Jsoup.connect(str.getDestination()).get();//DOM�� ���� ��ü�� ��-��
			
			Elements target = doc.select("div.chart"); //img�±׸� ���ΰ� �ִ� ��Ҹ� ����! <- �� �������� ���� �ٸ� �� �ִ�.			
			Elements img = target.select("img");//img�±� �����Ͽ� HTML��� �迭�� ��----��

			for(org.jsoup.nodes.Element x : img) {//HTML��� �迭 img�� ���� for in �ݺ���

				
				
				String url = x.getElementsByAttribute("src").attr("src");
				//�̹����� ��θ� src�Ӽ����κ��� ��ȯ�޴´�.
				URL imgurl = new URL(url);//�̹��� ��θ� �����ϴ� URL��ü
				
				ImageIcon temp = new ImageIcon(imgurl); //URL�� ��ο� �ִ� �̹����� �̹��� ���������� ġȯ

				
				image = temp; //�̹��� �Ӽ��� ��--��
			}//for
		}catch(Exception e) {
			e.printStackTrace(); //�̰� � ���� ó���ϱ�?
		}
		
	return image;//�̹��� ��ȯ!!

	}
	








	
	
}
