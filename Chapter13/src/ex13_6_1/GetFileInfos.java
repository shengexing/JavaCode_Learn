//�½�13.6.1                  ��ȡ�ļ���Ϣʾ��
package ex13_6_1;

import java.io.File;
import java.util.Date;

/*
 * ��ȡ�ļ��Ļ�����Ϣ
 */

public class GetFileInfos {
	
	public static void println(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		//���ļ�·���½�һ���ļ�����·�������Ǿ���·����Ҳ���������·��
		//����Ĳ����������ļ��ĳ���·��
		File file=new File("F:/MyWorkspace/JavaLearn/JavaCode_Learn/Chapter13/src/ex13_6_1/GetFileInfos.java");
		println("�ļ�����\t"+file.getName());         //��ȡ�ļ������֣�������·��
		//������·�����е��ļ��ָ�����ϵͳĬ�Ϸָ����滻
		println("�ļ�·����\t"+file.getPath());
		
		println("����·����\t"+file.getAbsolutePath());               //��ȡ�ļ��ľ���·��
		println("��Ŀ¼��\t"+file.getParent());               //��ȡ����·�����ĸ�����·��
		println("�ļ��Ƿ���ڣ�\t"+file.exists());
		println("�Ƿ�ɶ���\t"+file.canRead());
		println("�Ƿ��д��\t"+file.canWrite());
		println("�Ƿ��������ļ���\t"+file.isHidden());
		println("�Ƿ�����ͨ�ļ���\t"+file.isFile());
		println("�Ƿ����ļ�Ŀ¼��\t"+file.isDirectory());
		println("�ļ�·���Ƿ��Ǿ���·����"+file.isAbsolute());
		println("�ļ�·����URI��\t"+file.toURI());
		println("�ļ�����޸�ʱ�䣺\t"+new Date(file.lastModified()));
		println("�ļ���С��\t"+file.length()+" bytes");
	}

}
