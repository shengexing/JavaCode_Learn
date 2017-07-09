//�½�7.7                һ���򵥵��ļ�������
package ep7_07;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ʵ��һ��֧��ͨ����Ļ��ڹ�������㷨���ļ�������
 */
public class FileFinder {
	/**
	 * �����ļ�
	 * @param baseDirName �����ҵ�Ŀ¼
	 * @param targetFileName Ŀ���ļ�����֧��ͨ�����ʽ
	 * @param count ���������Ŀ�����Ϊ0�����ʾ����ȫ��
	 * @return �����ѯ�������ļ����б�
	 */
	public static List findFiles(String baseDirName, String targetFileName, int count) {
		/**
		 * �㷨������
		 * ��ĳ������������ҵ��ļ��г������������ļ��е��������ļ��м��ļ���
		 * ��Ϊ�ļ��������ƥ�䣬ƥ��ɹ��������������Ϊ���ļ��У��������
		 * ���в��գ��ظ���������������Ϊ�գ�������������ؽ��
		 */
		List fileList=new ArrayList();           //�ж�Ŀ¼�Ƿ����
		File baseDir=new File(baseDirName);
		if(!baseDir.exists()||!baseDir.isDirectory()) {
			System.out.println("�ļ�����ʧ�ܣ�"+baseDirName+"����һ��Ŀ¼��");
			return fileList;
		}

		String tempName=null;
		//����һ�����У�Queue�ڵ������ж���
		Queue queue=new Queue();          //ʵ��������
		queue.add(baseDir);   //���
		File tempFile=null;
		while(!queue.isEmpty()) {        //�Ӷ�����ȡĿ¼
			tempFile=(File) queue.pop();
			if(tempFile.exists()&&tempFile.isDirectory()) {
				File[] files=tempFile.listFiles();
				if(files!=null) {
					for(int i=0; i<files.length; i++) {    //�����Ŀ¼��Ž�����
						if(files[i].isDirectory())
							queue.add(files[i]);
						else {   //������ļ�������ļ�����Ŀ���ļ�������ƥ��
							tempName=files[i].getName();
							if(FileFinder.wildcardMatch(targetFileName, tempName)) {
								//ƥ��ɹ������ļ�����ӵ������
								fileList.add(files[i].getAbsoluteFile());
								//����Ѿ��ﵽָ������Ŀ�����˳�ѭ��
								if((count!=0)&&(fileList.size()>=count)) {
									return fileList;
								}
							}
						}
					}
				}
			}
		}
		return fileList;
	}

	/**
	 * ͨ���ƥ��
	 * @param pattern ͨ���ģʽ
	 * @param str ��ƥ����ַ���
	 * @return ƥ��ɹ��򷵻�true�����򷵻�false
	 */
	private static boolean wildcardMatch(String pattern, String str) {
		int patternLength=pattern.length();
		int strLength=str.length();
		int strIndex=0;
		char ch;
		for(int patternIndex=0; patternIndex<patternLength; patternIndex++) {
			ch=pattern.charAt(patternIndex);
			if(ch=='*') {
				//ͨ����Ǻ�*��ʾ����ƥ���������ַ�
				while(strIndex<strLength) {
					if(wildcardMatch(pattern.substring(patternIndex+1), str.substring(strIndex))) {
						return true;
					}
					strIndex++;
				}
			} else if(ch=='?') {
				//ͨ����ʺ�?��ʾƥ������һ���ַ�
				strIndex++;
				if(strIndex>strLength) {
					//��ʾstr���Ѿ�û���ַ�ƥ��?��
					return false;
				}
			}
			else {
				if((strIndex>=strLength)||(ch!=str.charAt(strIndex)))
					return false;
				strIndex++;
			}
		}
		return (strIndex==strLength);
	}

	public static void main(String[] parament) {
		String baseDIR="D:\\";     //�ڴ�Ŀ¼�����ļ�
		String fileName="*.txt";       //����չ��Ϊtxt���ļ�
		int countNumber=10;     //��෵��5���ļ�
		List resultList=FileFinder.findFiles(baseDIR, fileName, countNumber);
		if(resultList.size()==0) {
			System.out.println("No File Fount.");
		}
		else {
			for(int i=0; i<resultList.size(); i++) {
				System.out.println(resultList.get(i));         //��ʾ���ҽ��
			}
		}
	}

}

class Queue {
	private LinkedList data=new LinkedList();

	public Queue() {

	}

	//��������һ��Ԫ�أ�ֻ�ܼ��뵽��β
	public void add(Object obj) {
		this.data.addLast(obj);
	}

	//�鿴����Ԫ�أ����ݻ������ڶ�����
	public Object peek() {
		if(data.isEmpty()) {
			System.out.println("������û��Ԫ�أ�");
			return null;
		}
		return data.getFirst();
	}

	//ɾ������Ԫ��
	public boolean remove() {
		if(data.isEmpty()) {
			System.out.println("������û��Ԫ�أ�");
			return false;
		}
		data.removeFirst();
		return true;
	}

	//����Ԫ�أ�����ȡ����Ԫ�ز�����Ӷ�����ɾ��
	public Object pop() {
		if(data.isEmpty()) {
			System.out.println("������û��Ԫ�أ�");
			return null;
		}
		return data.removeFirst();
	}

	//�ڶ����в���Ԫ�أ����ص�һ�γ��ֵ�λ��
	public int indexOf(Object obj) {
		return data.indexOf(obj);
	}

	//�ڶ����в���Ԫ�أ��������һ�γ��ֵ�λ��
	public int lastIndexOf(Object obj) {
		return data.lastIndexOf(obj);
	}

	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return data.isEmpty();
	}

	//�������������Ԫ��
	public void clear() {
		data.clear();
	}
}