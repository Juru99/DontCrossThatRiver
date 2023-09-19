package dptr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class River extends Crawler{

	
	private List<Crawler> CrawlList;
	private String hanTemp;
	private String CrawlLink;

	public List<Crawler> getCrawlList() {
		return CrawlList;
	}

	public void setCrawlList(List<Crawler> crawlList) {
		CrawlList = crawlList;
	}
	public River(List<Crawler> CrawlList) {
		this.CrawlList = CrawlList;
	}
	public River() {
		Crawlering();
	}
	public String Crawlering() {
		List<Crawler> Han = new ArrayList<>();
		Han.add(new Crawler("http://www.koreawqi.go.kr/wQSCHomeLayout_D.wq?action_type=T"));
		
		
		River HanRiver = new River(Han);
		
		List<String> temps = HanRiver.searchTemp();
		
		hanTemp=temps.get(0).toString();//가져온 데이터(list의 값)를 String형태로
		
		return hanTemp;

	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return hanTemp;
	}

	public List<String> searchTemp(){
		List <String> temp=new ArrayList<>();
		
		for(Crawler r:this.CrawlList) {
			Document doc;
			try {
				doc=Jsoup.connect(r.getDestination()).get();
				Elements links=doc.select("table.table_01 tbody tr.site_S01004");
				//
				for(Element link:links) {
					temp.add(link.text().substring(3,7)); //가져온 데이터에서 온도값만 추가
				}//for
				
			}//try
			catch(IOException e) {
				e.printStackTrace();
			}//catch
		}//for
		return temp;
	}//searchTemp
}


