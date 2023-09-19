package saveFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dptr.ArmyJobScreen;
import dptr.HanRiver;
import dptr.JobScreen;
import dptr.MainGame;
import dptr.MainScreen;
import dptr.NoJobScreen;
import dptr.StockInfo;
import dptr.StuJobScreen;
import dptr.WorkJobScreen;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class ShowStream {
    public ShowStream() {
    	
    	try{
            //파일 객체 생성
            File file = new File("D:/JAVA/Output.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line="";
            
            
            int i=0;
            while((line = bufReader.readLine()) != null){
            	saveFile.OutStream.inline[i]=line.substring(3);
            	i++;
            } 
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
    
	}     
}

