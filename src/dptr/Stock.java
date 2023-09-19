package dptr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Stock extends Crawler{


	private List<Crawler> CrawlList;
	private String stockTemp;
	private String stockCode;

	public List<Crawler> getCrawlList() {
		return CrawlList;
	}

	public String getStockTemp() {
		return stockTemp;
	}

	public void setStockTemp(String stockTemp) {
		this.stockTemp = stockTemp;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public void setCrawlList(List<Crawler> crawlList) {
		CrawlList = crawlList;
	}
	public Stock(List<Crawler> CrawlList) {
		this.CrawlList = CrawlList;
	}
	public Stock() {
		
	}
	public String[] Crawlering(String crawlname) {
		List<Crawler> Han = new ArrayList<>();
		Han.add(new Crawler("https://finance.naver.com/item/sise_day.nhn?code="+crawlname));
		//"https://finance.naver.com/item/sise_day.nhn?code=034020"
		//�Ｚ�����Ͼ=028050  �λ��߰���=034020  �̷����´��=006800 
		//KT=030200 ���Ѿ���=000100 LG����=066570
		
		String[] stockTable=new String[70];
		
		
		Stock StockTemp = new Stock(Han);
		
		stockTable = StockTemp.searchTemp();
		
		return stockTable;

	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return stockTemp;
	}

	public String[] searchTemp(){
		String[] temp=new String[70];
		int i=0;

		
		for(Crawler r:this.CrawlList) {
			Document doc;
			try {
				doc=Jsoup.connect(r.getDestination()).get();
				Elements links=doc.select("table.type2 tbody tr td span");  //
				//
				for(Element link:links) {
				
					temp[i]=link.text();
					i++;	
						/*
						 * 
						 * */
					
				}//for
				
			}//try
			catch(IOException e) {
				e.printStackTrace();	//�������� ������ ���踦 �����ؼ�
			}//catch
		}//for
		return temp;
	}//searchTemp
	public static void main(String[] args) {
		
		
		
		
//		for(int i=0; i<str.length; i++) {
//			if(i%7==0) {
//				System.out.println();
//		}
		
//		System.out.print(a[i]+" ");
//		}
	}
}
