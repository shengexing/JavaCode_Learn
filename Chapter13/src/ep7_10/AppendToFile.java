//�½�7.10                 ������ݵ��ļ�β
package ep7_10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import ep7_08.ReadFromFile;

/**
 * ������׷�ӵ��ļ�β��
 */
public class AppendToFile {
	/**
	 * A����׷���ļ���ʹ��RandomAccessFile
	 * @param fileName �ļ���
	 * @param content ׷�ӵ�����
	 */
	public static void appendMethodA(String fileName, String content) {
		try {
			//��һ����������ļ���������д��ʽ
			RandomAccessFile randomFile=new RandomAccessFile(fileName, "rw");
			long fileLength=randomFile.length();      //�ļ����ȣ��ֽ���
			//��д�ļ�ָ���Ƶ��ļ�β
			randomFile.seek(fileLength);
			randomFile.writeBytes(content);
			randomFile.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * B����׷���ļ���ʹ��FileWriter
	 */
	public static void appendMethodB(String fileName, String content) {
		try {
			//��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
			FileWriter writer=new FileWriter(fileName, true);
			writer.write(content);
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String fileName="./src/ep7_09/test3.txt";
		String content="new append!";
		//������A׷���ļ�
		AppendToFile.appendMethodA(fileName, content);
		AppendToFile.appendMethodA(fileName, " append end. \n");
		ReadFromFile.readFileByLines(fileName);     //��ʾ�ļ�����
		//������B׷���ļ�
		AppendToFile.appendMethodB(fileName, content);
		AppendToFile.appendMethodB(fileName, " append end. \n");
		ReadFromFile.readFileByLines(fileName);     //��ʾ�ļ�����
	}

}
