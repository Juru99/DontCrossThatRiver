package saveFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutStream {
	public static String strjob="";//직업을 고르게 되면 결정되는 문자열
	public static double strmoney=0;//매수 매도를 누르게 되면 결정될 문자열
	public static String strju[]= {"0","0","0","0","0","0"}; // 매수 매도를 하게 되면 결정될 문자열
	public static String[] inline=new String[8];//[0]직업 [1]돈 [2]주가 따로 나뉘어 저장될 문자열 배열
	BufferedOutputStream bs = null;
    public static String str;
	public OutStream() throws IOException {
		try {
			bs = new BufferedOutputStream(new FileOutputStream("D:/Java/Output.txt"));
			str ="직업:"+strjob+"\r\n" 
					+ "돈:"+strmoney+"\r\n" 
					+"삼성엔지니어링주:"+strju[0]+"\r\n"
					+"두산중공업주:"+strju[1]+"\r\n"
					+"미래에셋대우주:"+strju[2]+"\r\n"
					+"KT주:"+strju[3]+"\r\n"
					+"유한양행주:"+strju[4]+"\r\n"
					+"LG전자주:"+strju[5]+"\r\n";
			bs.write(str.getBytes()); //Byte형으로만 넣을 수 있음
		} catch (Exception e) {
	                e.getStackTrace();
			// TODO: handle exception
		}finally {
				bs.close();
		}	
	} //반드시 닫는다.
}


