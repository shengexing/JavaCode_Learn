//�½�7.11                 �ļ��ķָ���ϲ�
package ep7_11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * �ļ��ָ�ϲ����������ļ��ָ������С�ļ��������С�ļ��ϲ���һ�����ļ�
 */
public class FileDivisionUniter {

	public static final String SUFFIX=".pp";            //�ָ����ļ�����׺
	
	/**
	 * �ָ��ļ�
	 * @param fileName ���ָ���ļ���
	 * @param size С�ļ��Ĵ�С����λ�ֽ�
	 * @return �ָ�ɵ�С�ļ����ļ���
	 * @throws Exception �ָ�����п����׳����쳣
	 */
	public static String[] divide(String fileName, long size) throws Exception {
		File inFile=new File(fileName);
		if((!inFile.exists())||(!inFile.isFile())) {
			throw new Exception("ָ���ļ������ڣ�");
		}
		//��ñ��ָ��ļ����ļ��������ָ�ɵ�С�ļ���������Ŀ¼��
		File parentFile=inFile.getParentFile();
		//ȡ���ļ���С
		long fileLength=inFile.length();
		if(size<=0) {
			size=fileLength/2;
		}
		//ȡ�ñ��ָ���С�ļ�����Ŀ
		int num=(