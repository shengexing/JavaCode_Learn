//�½�7.12                        �Ӽ��̽������ݲ�������ļ�
package ep7_12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import ep7_08.ReadFromFile;

/**
 * �ӱ�׼�������ж�ȡ�ļ������洢���ļ���
 */
public class CatStdinToFile {
	
	public static boolean CatStdinToFile(String fileName) {
		File file=new File(fileName);
		//�����ݰ����ı�������ļ�
		PrintWriter writer=null;
		BufferedReader in=null;
		try {
			//Ϊ����ļ�����һ��д����
			writer=new PrintWriter(new FileWriter(file));
			System.out.println("�������ļ����ݣ�����quit����");
			//��BufferedReader��װ��׼������
			in=new BufferedReader(new InputStreamReader(System.in));
			String inputLine=null;
			while(((inputLine=in.readLine())!=null)&&(!inputLine.equals("quit"))) {
				writer.println(inputLine);
			}
			//�������new PrintWriter(new FileWriter(file), true)����Զ�flush
			writer.flush();
			writer.close();
			return true;
		} catch(IOException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			if(in!=null) {
				try {
					in.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String fileName="./src/ep7_12/test.txt";
		CatStdinToFile.CatStdinToFile(fileName);
		System.out.println("\n����ļ������ݣ�");
		ReadFromFile.readFileByLines(fileName);
	}

}
