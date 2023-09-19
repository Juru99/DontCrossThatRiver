package dptr;

import job.*;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

class MainStarts extends JFrame{ //화면 전환 클래스
	
    public MainScreen mainScreen = null;
    public JobScreen jobScreen = null;
    public StuJobScreen stuJobScreen = null;
    public WorkJobScreen workJobScreen = null;
    public NoJobScreen	noJobScreen = null;
    public ArmyJobScreen armyJobScreen = null;
    public MainGame mainGame = null;
    public StockInfo stockInfo = null;
    public HanRiver hanRiver = null;
    private String [] jobNames= {"SelJob","Student","Worker","Jobless","Soldier","BigStudent",
    "HighStudent","ChickenWork","ProfessorWork","Thief","BuildingOwner","Homeless","Sergeant"};
    //직업 버튼들의 이름
    private String [] mainNames = {"Refresh","Ability","Home","Stock","Interest","River"};
    //메인게임창 버튼들의 이름
    private String [] stockEname = {"samsung","dusan","daewu","kt","yuhan","lg"};
    public void Change(String ScreenName){ // 패널체인지 부분
    	getContentPane().removeAll();
        if(ScreenName.equals(mainNames[3])){
        	stockInfo.setBounds(0, 70, 383, 460);
        	getContentPane().add(stockInfo);
            //주식시장버튼
        }
        if(ScreenName.equals(jobNames[0])) getContentPane().add(jobScreen);
        if(ScreenName.equals(jobNames[1])) getContentPane().add(stuJobScreen);
        if(ScreenName.equals(jobNames[2])) getContentPane().add(workJobScreen);      
        if(ScreenName.equals(jobNames[3])) getContentPane().add(noJobScreen);        
        if(ScreenName.equals(jobNames[4])) getContentPane().add(armyJobScreen);         
    	for (int i = 5; i < jobNames.length; i++) {
            if(ScreenName.equals(jobNames[i])) getContentPane().add(mainGame);
		}
    	if(ScreenName.equals("back")) getContentPane().add(jobScreen);        
        if(ScreenName.equals(mainNames[0])) {
            getContentPane().add(mainGame);
            //새로고침
        }
        if(ScreenName.equals(mainNames[1])){
        	getContentPane().add(mainGame);
        	//어빌리티
        }
        if(ScreenName.equals(mainNames[2])){
            getContentPane().add(mainGame);
            //홈버튼
        }    
        if(ScreenName.equals(mainNames[4])){
        	getContentPane().add(mainGame);
        	new newsflatform();
            //뉴스버튼
        }
        if(ScreenName.equals(mainNames[5])){
        	getContentPane().add(hanRiver);
            //한강버튼
        }
        if(ScreenName.equals("Load")) {
        	getContentPane().add(mainGame);
        }
        revalidate();
        repaint(); 
    }
    public void OpenStock(String ScreenName) {
        if(ScreenName.equals(stockEname[0])) {
            new StockList(0);
        }
        if(ScreenName.equals(stockEname[1])) {
            new StockList(1);
        }
        if(ScreenName.equals(stockEname[2])) {
            new StockList(2);
        }
        if(ScreenName.equals(stockEname[3])) {
            new StockList(3);
        }
        if(ScreenName.equals(stockEname[4])) {
            new StockList(4);
        }
        if(ScreenName.equals(stockEname[5])) {
            new StockList(5);
        }
    }
    public static void main(String[] args) {
       MainStarts Screen = new MainStarts();            

       Screen.mainScreen = new MainScreen(Screen); 
       Screen.jobScreen = new JobScreen(Screen);
       Screen.stuJobScreen = new StuJobScreen(Screen);
       Screen.workJobScreen = new WorkJobScreen(Screen);
       Screen.noJobScreen = new NoJobScreen(Screen);
       Screen.armyJobScreen = new ArmyJobScreen(Screen);
       Screen.mainGame = new MainGame(Screen);
       Screen.stockInfo = new StockInfo(Screen);
       Screen.hanRiver = new HanRiver(Screen); //다른 클래스들을 MainStarts에서 사용하기 위해 객체를 만들어줌
       Screen.add(Screen.mainScreen);
       
       Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); // 프레임창을 화면 정중앙에 위치하게 하기 위함
       int ww=500,hh=500,xx=(d.width-ww)/2,yy=(d.height-hh)/2;
       Screen.setTitle("메인화면");
       Screen.setDefaultCloseOperation(EXIT_ON_CLOSE);
       Screen.setBounds(xx, yy, ww, hh);
       Screen.setVisible(true);
    }
}
    