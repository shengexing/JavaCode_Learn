//�½�13.4.3                ��ʾ�ļ���д��
package ex13_3_4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Usefile1 {

	public static void main(String[] args) throws IOException{
		
		int i;
		FileReader fr;
		FileWriter fw;
		
		try {
			fr=new FileReader("text.txt");      //�������ļ�
		} catch(FileNotFoundException e) {
			System.out.println("not found this file");
			return;
		}
		
		try {
			fw=new FileWriter("text1.txt");        //������ļ�
		} catch(FileNotFoundException e) {        //��δ�ҵ�����ļ�������Զ������ļ�����catch������ݲ���ִ��
			System.out.println("error");
			return;
		}
		
		try {
			i=fr.read();        //������
			while(i!=-1) {
				fw.write(i);          //д����
				i=fr.read();
			}
			fr.close();
			fw.close();
		} catch(IOException e) {
			System.out.println("error");
		}
	}

}
