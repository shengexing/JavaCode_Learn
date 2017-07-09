//�½�13.4.3                    �����ļ�
package ex13_4_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class CopyFileTest {
	//����oldFile  ��d:/old.txt,����newFile��d:/new.txt
	public void copyFile(String oldFile, String newFile) {
		try {
			int bytesum=0;
			int byteread=0;
			File oldfile=new File(oldFile);
			//�ж��ļ��Ƿ���ڣ�����ļ����ڣ���ʵ�ָ��ļ������ļ��ĸ���
			if(oldfile.exists()) {
				//��ȡԭ�ļ�
				InputStream ins=new FileInputStream(oldFile);
				//�����ļ��������д���ļ�
				FileOutputStream outs=new FileOutputStream(newFile);
				//��������������СΪ500�ֽ�
				byte[] buffer=new byte[500];
				//ÿ�δ��ļ��������ж�ȡ500�ֽ����ݣ����㵱ǰΪֹ��ȡ����������
				while((byteread=ins.read(buffer))!=-1) {
					bytesum+=byteread;
					System.out.println(bytesum);
					//�ѵ�ǰ�������е�����д�����ļ�
					outs.write(buffer,0,byteread);
				}
				ins.close();        //�ر��ļ�������
			}
		} catch(Exception ex) {
			System.out.println("ԭ�ļ�������");
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//���������ʵ����������copyFile()����������������ִ�г���ʱ�ڿ���̨����
		//��һ��������ʾ���ļ����ڶ���������ʾ���ļ�
		CopyFileTest copyfile=new CopyFileTest();
		copyfile.copyFile(args[0], args[1]);
	}

}
