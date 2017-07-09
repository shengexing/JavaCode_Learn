//�½�7.16                         ��jar������Դ�ļ�
package ep7_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * ��jar���ж���Դ�ļ����������ļ���
 */
public class ResourceReader {
	/**
	 * ��һ�ַ�����Jar���е���Դ��Ϣ�����ȶ�ȡ��Դ��URL���ٶ�ȡURL��Ӧ���ļ���Ϣ
	 * @param class1 ��
	 * @param fileName �ļ������·��
	 */
	public static void readFromJarA(Class class1, String fileName) {
		//getResource �õ�һ��URL��������λ��Դ
		URL fileURL=class1.getResource(fileName);
		System.out.println("��Դ��URL��"+fileURL+"\n");
		try {
			//��fileURL��Ӧ���ļ���
			InputStream inputstream=fileURL.openStream();
			BufferedReader bufferedreader=new BufferedReader(new InputStreamReader(inputstream));
			String str;
			while((str=bufferedreader.readLine())!=null) {
				System.out.println(str);
			}
			inputstream.close();
		} catch(IOException ioexception) {
			ioexception.printStackTrace();
		}
	}
	
	/**
	 * �ڶ��ַ�����Jar���е���Դ��Ϣ
	 * @param class1 ��
	 * @param fileName �ļ������·��
	 */
	public static void readFromJarB(Class class1, String fileName) {
		//getResourceAsStreamȡ�ø���Դ�����������ã���֤������Դ���ȷ��λ�ó�ȡ����
		InputStream inputstream=class1.getResourceAsStream(fileName);
		if(inputstream!=null) {
			BufferedReader bufferedreader=new BufferedReader(new InputStreamReader(inputstream));
			String str;
			try {
				//���ж�ȡ���е�����
				while((str=bufferedreader.readLine())!=null) {
					System.out.println(str);
				}
				inputstream.close();
			} catch(IOException ioexception) {
				ioexception.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Class class1=ResourceReader.class;
		//����ļ����·��ǰû��"/"�����ʾ����ڸ�class�ļ���λ��
		String filePath="config0.conf";
		ResourceReader.readFromJarA(class1, filePath);
		System.out.println();
		filePath="Resources/config1.conf";
		ResourceReader.readFromJarB(class1, filePath);
		System.out.println();
		//������ļ����·��ǰ����"/"�����ʾ�����jar�ļ��ĵ�һ��Ŀ¼��Ŀ¼ΪResource
		filePath="/src/ep7_16/config2.conf";
		ResourceReader.readFromJarA(class1, filePath);
	}

}