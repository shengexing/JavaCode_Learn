//�½�13.5.1                ��ʾ���ͨ�������ļ���ʵ���ļ��ĸ���
package ex13_5_1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamTest {
	
	public static void main(String[] args) throws IOException {
		/*
		 * �������ļ��Ͻ������������������ļ�������Fileʵ���������������filein�����ݣ�
		 * Դ�ļ���FileStreamTest.java��ͨ�����������fileoutд���ݵ�ָ��Ŀ���ļ�
		 */
		FileReader filein=new FileReader(new File("./src//ex13_5_1//FileStreamTest.java"));
		FileWriter fileout=new FileWriter(new File("./src//ex13_5_1//DestriFileStreamTest.txt"));
		int c;
		
		//���ζ�ȡ�������е����ݣ��ȴ洢�ڱ���c�У�Ȼ�������д�������
		//д���ļ�DestiFileStreamTest.txt
		while((c=filein.read())!=-1)
			fileout.write(c);
		//�ر�����������������ͷ���ռ�õ���Դ
		filein.close();
		fileout.close();
	}

}
