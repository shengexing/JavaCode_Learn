//�½�13.6.3                    ɾ���ļ���Ŀ¼ʾ��
package ex13_6_3;

import java.io.File;

/**
 * ɾ���ļ���Ŀ¼
 */

public class DeleteFileUtil {

	/**
	 * ɾ���ļ��������ǵ����ļ����ļ���
	 * @param fileName	��ɾ�����ļ���
	 * @return	�ļ�ɾ���ɹ�����true�����򷵻�false
	 */
	public static boolean delete(String fileName){
		File file = new File(fileName);
		if (!file.exists()){
			System.out.println("ɾ���ļ�ʧ�ܣ�" + fileName + "�ļ������ڣ�");
			return false;
		} else {
			if (file.isFile()){
				return DeleteFileUtil.deleteFile(fileName);
			} else {
				return DeleteFileUtil.deleteDirectory(fileName);
			}
		}
	}

	/**
	 * ɾ�������ļ�
	 * @param fileName	��ɾ���ļ����ļ���
	 * @return	�����ļ�ɾ���ɹ�����true�����򷵻�false
	 */
	public static boolean deleteFile(String fileName){
		File file = new File(fileName);
		// ����ļ�·����Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ����
		if (file.exists() && file.isFile()){
			if(file.delete()){
				System.out.println("ɾ�������ļ�" + fileName + "�ɹ���");
				return true;
			} else {
				System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ�");
				return false;
			}
		} else {
			System.out.println("ɾ�������ļ�ʧ�ܣ�" + fileName + "�ļ������ڣ�");
			return false;
		}
	}

	/**
	 * ɾ��Ŀ¼���ļ��У��Լ�Ŀ¼�µ��ļ�
	 * @param dir	��ɾ��Ŀ¼���ļ�·��
	 * @return	Ŀ¼ɾ���ɹ�����true�����򷵻�false
	 */
	public static boolean deleteDirectory(String dir){
		// ���dir�����ļ��ָ�����β���Զ�����ļ��ָ�����
		if (!dir.endsWith(File.separator)){
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);
		//���dir��Ӧ���ļ������ڣ����߲���һ���ļ��У����˳�
		if (!dirFile.exists() || (!dirFile.isDirectory())){
			System.out.println("ɾ��Ŀ¼ʧ�ܣ�" + dir + "Ŀ¼�����ڣ�");
			return false;
		}
		
		boolean flag = true;
		// ɾ���ļ����������ļ���������Ŀ¼��
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// ɾ�����ļ�
			if (files[i].isFile()){
				flag = DeleteFileUtil.deleteFile(files[i].getAbsolutePath());
				if (!flag){
					break;
				}
			}
			// ɾ����Ŀ¼
			else if (files[i].isDirectory()){
				flag = DeleteFileUtil.deleteDirectory(files[i].getAbsolutePath());
				if (!flag){
					break;
				}
			}
		}
		if (!flag){
			System.out.println("ɾ��Ŀ¼ʧ�ܣ�");
			return false;
		}
		// ɾ����ǰĿ¼
		if (dirFile.delete()){
			System.out.println("ɾ��Ŀ¼" + dir + "�ɹ���");
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// ɾ�������ļ�
		String file = "./src/ex13_6_2/test/test1/text.txt";
		DeleteFileUtil.deleteFile(file);
		System.out.println();
		
		// ɾ��һ��Ŀ¼
		String dir = "./src/ex13_6_2/test/test1";             //���ǿ�ƽ̨ʹ�ã���"."+File.separator+"src"+
		                                                                		//                            File.separator+"ex13_6_2"+File.separator+"test"+
																				//                            File.separator+"test1"
		DeleteFileUtil.deleteDirectory(dir);
		System.out.println();
		
		// ɾ���ļ�
		dir = "./src/ex13_6_2/test";
		DeleteFileUtil.delete(dir);
	}
}
