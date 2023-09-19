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
	private String[] newsTemp; //기사의 제목을 저장할 문자열 배열
	private String[] hrefTemp; //기사 제목에 해당하는 a태그의 href속성을 문자열로 저장
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);//시스템 시간을 출력할 날짜 형식
		
		Date d = new Date(); //날짜를 저장하는 날짜 객체
		
		String today = new String(sdf.format(d)); //시스템 날짜에 형식을 지정하여 문자열로 저장
		
		List<Crawler> NewsPage = new ArrayList<>(); //뉴스가 있는 웹 페이지 주소 저장
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
		
		
		List <Crawler> hrefList=new ArrayList<>(); //크롤러 배열 == 페이지 주소 저장
		hrefList.add(new Crawler("https://finance.naver.com/news/mainnews.nhn?date="+today)); 



		News NewsList = new News(hrefList);

		String [] temps = NewsList.hrefTemp();

		newsTemp=temps;

		return newsTemp;
	}

	public String[] searchTemp(){
		String [] temp=new String[17]; //매일 기사의 양이 다른 듯 , 6월 13일 기준 17개 / 6월 14일은 12개 -> 레이아웃은 17개 기준으로 맞춰놓음 ,  
		int i=0;
		for(Crawler r:this.CrawlList) {
			Document doc;
			try {
				doc=Jsoup.connect(r.getDestination()).get();
				Elements linksdd=doc.select("dd.articleSubject a");
				Elements linksdt=doc.select("dt.articleSubject a");
				//dd이미지와 기사의 내용이 함께 있는 태그
				//dt이미지 없이 기사의 내용만 있는 태그
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
				//dd이미지와 기사의 내용이 함께 있는 태그
				//dt이미지 없이 기사의 내용만 있는 태그
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
		String[] a=news.Crawlering();//기사
		String[] b=news.HrefCrawlering();//기사 주소
		for(int i=0; i<a.length; i++) {
			System.out.println(" news:"+a[i]);
			System.out.println(" newsHref:"+b[i]);
			
			//동작 원리를 살펴보기위해 만든 메인 함수 , 삭제해도 무방함
		}
	}

}