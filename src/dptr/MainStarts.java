package dptr;

import job.*;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

class MainStarts extends JFrame{ //ȭ�� ��ȯ Ŭ����
	
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
    //���� ��ư���� �̸�
    private String [] mainNames = {"Refresh","Ability","Home","Stock","Interest","River"};
    //���ΰ���â ��ư���� �̸�
    private String [] stockEname = {"samsung","dusan","daewu","kt","yuhan","lg"};
    public void Change(String ScreenName){ // �г�ü���� �κ�
    	getContentPane().removeAll();
        if(ScreenName.equals(mainNames[3])){
        	stockInfo.setBounds(0, 70, 383, 460);
        	getContentPane().add(stockInfo);
            //�ֽĽ����ư
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
            //���ΰ�ħ
        }
        if(ScreenName.equals(mainNames[1])){
        	getContentPane().add(mainGame);
        	//�����Ƽ
        }
        if(ScreenName.equals(mainNames[2])){
            getContentPane().add(mainGame);
            //Ȩ��ư
        }    
        if(ScreenName.equals(mainNames[4])){
        	getContentPane().add(mainGame);
        	new newsflatform();
            //������ư
        }
        if(ScreenName.equals(mainNames[5])){
        	getContentPane().add(hanRiver);
            //�Ѱ���ư
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
       Screen.hanRiver = new HanRiver(Screen); //�ٸ� Ŭ�������� MainStarts���� ����ϱ� ���� ��ü�� �������
       Screen.add(Screen.mainScreen);
       
       Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); // ������â�� ȭ�� ���߾ӿ� ��ġ�ϰ� �ϱ� ����
       int ww=500,hh=500,xx=(d.width-ww)/2,yy=(d.height-hh)/2;
       Screen.setTitle("����ȭ��");
       Screen.setDefaultCloseOperation(EXIT_ON_CLOSE);
       Screen.setBounds(xx, yy, ww, hh);
       Screen.setVisible(true);
    }
}
    