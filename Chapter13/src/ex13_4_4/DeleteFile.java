//�½�13.4.4                   ɾ���ļ�
package ex13_4_4;

import java.io.File;

public class DeleteFile {
	
	public void delFile(String fileDerecatorAndName) {
		try {
			//��Ҫɾ�����ļ����ļ�����Ϊ����������File����
			File deletedFile=new File(fileDerecatorAndName);
			//����File���delete����ɾ���ļ�
			deletedFile.delete();
		} catch(Exception ex) {
			System.out.println("ɾ���ļ�����");
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//������DeleteFile�Ķ���
		DeleteFile deleteFile=new DeleteFile();
		//�������delFile����������ΪҪɾ�����ļ����ļ���
		deleteFile.delFile(args[0]);
	}

}
