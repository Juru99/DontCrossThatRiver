package saveFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutStream {
	public static String strjob="";//������ ���� �Ǹ� �����Ǵ� ���ڿ�
	public static double strmoney=0;//�ż� �ŵ��� ������ �Ǹ� ������ ���ڿ�
	public static String strju[]= {"0","0","0","0","0","0"}; // �ż� �ŵ��� �ϰ� �Ǹ� ������ ���ڿ�
	public static String[] inline=new String[8];//[0]���� [1]�� [2]�ְ� ���� ������ ����� ���ڿ� �迭
	BufferedOutputStream bs = null;
    public static String str;
	public OutStream() throws IOException {
		try {
			bs = new BufferedOutputStream(new FileOutputStream("D:/Java/Output.txt"));
			str ="����:"+strjob+"\r\n" 
					+ "��:"+strmoney+"\r\n" 
					+"�Ｚ�����Ͼ��:"+strju[0]+"\r\n"
					+"�λ��߰�����:"+strju[1]+"\r\n"
					+"�̷����´����:"+strju[2]+"\r\n"
					+"KT��:"+strju[3]+"\r\n"
					+"���Ѿ�����:"+strju[4]+"\r\n"
					+"LG������:"+strju[5]+"\r\n";
			bs.write(str.getBytes()); //Byte�����θ� ���� �� ����
		} catch (Exception e) {
	                e.getStackTrace();
			// TODO: handle exception
		}finally {
				bs.close();
		}	
	} //�ݵ�� �ݴ´�.
}


