package dptr;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dptr.Crawler;

public class News extends Crawler{
	private List<Crawler> CrawlList;
	private String[] newsTemp; //����� ������ ������ ���ڿ� �迭
	private String[] hrefTemp; //��� ���� �ش��ϴ� a�±��� href�Ӽ��� ���ڿ��� ����
	public List<Crawler> getCrawlList() {
		return CrawlList;
	}

	public void setCrawlList(List<Crawler> crawlList) {
		CrawlList = crawlList;
	}
	public News() {
		// TODO Auto-generated constructor stub
	}
	public News(List<Crawler>CrawlList) {
		this.CrawlList = CrawlList;
	}
	public String[] Crawlering() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);//�ý��� �ð��� ����� ��¥ ����
		
		Date d = new Date(); //��¥�� �����ϴ� ��¥ ��ü
		
		String today = new String(sdf.format(d)); //�ý��� ��¥�� ������ �����Ͽ� ���ڿ��� ����
		
		List<Crawler> NewsPage = new ArrayList<>(); //������ �ִ� �� ������ �ּ� ����
		NewsPage.add(new Crawler("https://finance.naver.com/news/mainnews.nhn?date="+today));

		News NewsList = new News(NewsPage);

		String [] hrefs = NewsList.searchTemp();

		hrefTemp=hrefs;

		return hrefTemp;

	}
	public String[] HrefCrawlering(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);
		
		Date d = new Date();
		
		String today = new String(sdf.format(d));
		
		
		List <Crawler> hrefList=new ArrayList<>(); //ũ�ѷ� �迭 == ������ �ּ� ����
		hrefList.add(new Crawler("https://finance.naver.com/news/mainnews.nhn?date="+today)); 



		News NewsList = new News(hrefList);

		String [] temps = NewsList.hrefTemp();

		newsTemp=temps;

		return newsTemp;
	}

	public String[] searchTemp(){
		String [] temp=new String[17]; //���� ����� ���� �ٸ� �� , 6�� 13�� ���� 17�� / 6�� 14���� 12�� -> ���̾ƿ��� 17�� �������� ������� ,  
		int i=0;
		for(Crawler r:this.CrawlList) {
			Document doc;
			try {
				doc=Jsoup.connect(r.getDestination()).get();
				Elements linksdd=doc.select("dd.articleSubject a");
				Elements linksdt=doc.select("dt.articleSubject a");
				//dd�̹����� ����� ������ �Բ� �ִ� �±�
				//dt�̹��� ���� ����� ���븸 �ִ� �±�
				for(Element linkdd:linksdd) {
					temp[i]=linkdd.text();
					i++;
				}//fordd
				for(Element linkdt:linksdt) {
					temp[i]=linkdt.text();
					i++;
				}

			}//try
			catch(IOException e) {
				e.printStackTrace();
			}//catch
		}//for
		return temp;
	}//searchTemp

	public String[] hrefTemp(){
		String [] href=new String[17];
		int i=0;
		for(Crawler r:this.CrawlList) {
			Document doc;
			try {
				doc=Jsoup.connect(r.getDestination()).get();
				Elements linksdd=doc.select("dd.articleSubject a[href]");
				Elements linksdt=doc.select("dt.articleSubject a[href]");
				//dd�̹����� ����� ������ �Բ� �ִ� �±�
				//dt�̹��� ���� ����� ���븸 �ִ� �±�
				for(Element linkdd:linksdd) {
					href[i]="https://finance.naver.com"+linkdd.attr("href");
					i++;
				}//fordd
				for(Element linkdt:linksdt) {
					href[i]="https://finance.naver.com"+linkdt.attr("href");
					i++;
				}

			}//try
			catch(IOException e) {
				e.printStackTrace();
			}//catch
		}//for
		return href;
	}


	public static void main(String[] args) {
		News news=new News();
		String[] a=news.Crawlering();//���
		String[] b=news.HrefCrawlering();//��� �ּ�
		for(int i=0; i<a.length; i++) {
			System.out.println(" news:"+a[i]);
			System.out.println(" newsHref:"+b[i]);
			
			//���� ������ ���캸������ ���� ���� �Լ� , �����ص� ������
		}
	}

}