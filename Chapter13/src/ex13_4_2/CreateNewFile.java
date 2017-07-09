//�½�13.4.2                 ���ȴ���һ���û�ָ�����ƺ����͵����ݣ������ļ���д������
package ex13_4_2;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CreateNewFile {
	//����һ��������ɴ����ļ���Ŀ�ģ��ļ��ĵ�һ���������ļ�·�����ļ������ڶ����������ļ�����
	public void createNewFile(String fileDerectoryAndName, String fileContent) {
		try {
			String fileName=fileDerectoryAndName;
			//����File���󣬲���ΪString���ͣ���ʾĿ¼��
			File myFile=new File(fileName);
			//�ж�Ŀ¼�Ƿ���ڣ�������������creatNewFile()����������Ŀ¼��������ת���쳣�������
			if(!myFile.exists())
				myFile.createNewFile();
			else {
				System.out.println("�ļ��Ѵ��ڣ�");
				return;
			}
			
			//���������д�봴�����ļ��������½��ļ���Ϊ��������FileWriter����
			FileWriter resultFile=new FileWriter(myFile);
			//�Ѹö����װ��PrinterWriter����
			PrintWriter myNewFile=new PrintWriter(resultFile);
			//��ͨ��PrintWriter�����println()�������ַ�������д���½��ļ�
			myNewFile.println(fileContent);
			resultFile.close();               //�ر��ļ�д����
		} catch(Exception ex) {
			System.out.println("�޷��½��ļ�");
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//������Ķ��󲢵��øö����createNewFile()�������������ļ���д������
		CreateNewFile createFile=new CreateNewFile();
		createFile.createNewFile(args[0], args[1]);
	}

}
