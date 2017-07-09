//�½�13.4.5              ɾ���ļ���
package ex13_4_5;

import java.io.File;

public class DeleteFolder {
	//����ɾ���ļ��к���������Ϊ�ļ�·��
	public void delFolder(String folderPath) {
		try {
			//����ɾ�������ļ�������ɾ����Ŀ¼���������ļ�
			delAllFile(folderPath);
			//�����ļ����󣬲���Ϊ��ɾ����Ŀ¼
			File myFilePath=new File(folderPath);
			myFilePath.delete();              //����ɾ��Ŀ¼����
		} catch(Exception ex) {
			System.out.println("ɾ���ļ��д���");
			ex.printStackTrace();
		}
	}
	
	public void delAllFile(String path) {      //���岢����ɾ�������ļ�����������Ϊ�ļ�·��
		File file=new File(path);               //�����ļ����󣬲���Ϊ�ļ�·��
		if(!file.exists()) {              //����ļ������ڣ�����������
			return;
		}
		if(!file.isDirectory()) {            //�����file������Ŀ¼Ҳ��������
			return;
		}
		
		String[] tempList=file.list();                  //ȡ��Ŀ¼�µ��ļ�����Ŀ¼��
		File temp=null;
		for(int i=0; i<tempList.length; i++) {
			//�г���ǰ�ļ����µ��ļ���Ŀ¼�����Է���ع۲�ɾ���˵���Щ�ļ�
			System.out.println(tempList[i].toString());
			if(path.endsWith(File.separator)) {
				temp=new File(path+tempList[i]);
			}
			else {
				//Ϊ��ɾ��Ŀ¼�µ�ÿһ���ļ���Ŀ¼������ʱFile���󣬲���Ϊȫ·��
				temp=new File(path+File.separator+tempList[i]);
			}
			
			//���temp���ļ���ɾ�����ļ�
			if(temp.isFile())
				temp.delete();
			
			//���temp��Ŀ¼�������ɾ�������ļ��ķ�������ʱ������delAllFile()�����ĵ�������
			if(temp.isDirectory()) {
				delAllFile(path+"/"+tempList[i]);
				delFolder(path+"/"+tempList[i]);
			}
		}	
	}

	public static void main(String[] args) {           //�����еġ�./����ʾ��ǰ·�� 
		DeleteFolder deleteFolder=new DeleteFolder();
		deleteFolder.delFolder(args[0]);
	}

}
