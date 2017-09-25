// �½�16.06.2             ʹ�������õ�����
package ex16_06_2;

import java.lang.ref.SoftReference;

/*�Զ�����дfinalize��������*/
class MySoftObject {
	String msname;
	
	// �вι�����
	public MySoftObject(String msname) {
		this.msname = msname;
	}
	
	// ��дfinalize����
	public void finalize() {
		System.out.println(msname + "�������������ռ������������ռ�������");
	}
	
	// �Զ����show()����
	public void show() {
		System.out.println(msname + "���󻹿��Ա����ã�����");
	}
}

/*����*/
public class MySoftObjectTest {

	public static void main(String[] args) {
		// ����һ��MySoftObject����
		MySoftObject mso = new MySoftObject("MSO");
		// ��������ָ�򴴽���MySoftObject����
		SoftReference sr = new SoftReference(mso);
		// ʹMySoftObject�������������ռ�����
		mso = null;
		// ͨ�������÷���MySoftObject����
		((MySoftObject)sr.get()).show();
		// ������������ռ�
		System.out.println("��һ�ν��������ռ�������");
		System.gc();
		// �����ӳ�ʹ�����ռ������ж����������̴߳���
		try {
			Thread.sleep(100);          // ���߳�����100����
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// ͨ�������÷���MySoftObject����
		((MySoftObject)sr.get()).show();
		// �ľ��ڴ�
		int size = 10000000;
		String[] sa = new String[size];
		for(int i=0; i<size; i++)
			sa[i] = new String("Hello World������");

	}

}
