//�½�13.4.1              �����ļ���
package ex13_4_1;

import java.io.File;

public class CreateNewFolder {
	//����newFolder��ʾ�½�Ŀ¼�����ƣ��÷����ڴ�����Ŀ¼ʱ�����ж�Ŀ¼�ļ��Ƿ����
	//����ڣ���������ת���쳣������룬��ʾһ�д�����Ϣ�����������������Ŀ¼
	private void newFolder(String newfolder) {
		try {
			String filepath=newfolder;
			File myPath=new File(filepath);
			if(!myPath.exists()) {             //�ж��ļ���·���Ƿ����
				myPath.mkdir();
			}
		} catch(Exception e) {
			System.out.println("�½�Ŀ¼�Ѵ���");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//������public��Ķ����Ե����亯��������Ŀ¼
		CreateNewFolder createNewFolder=new CreateNewFolder();
		//���ִ�г���ʱ�Ĳ������ò�����ִ�г���Ĵ����ֱ�Ӹ���
		//�ò���������ʱ����mynewpath��
		String mynewpath=args[0];
		//��������亯����������Ŀ¼
		createNewFolder.newFolder(mynewpath);
	}

}
