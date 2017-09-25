// �½�16.06.1             ʹ����������WeakObjectTest������
package ex16_06_1;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/*�Զ�����дfinalize()��������*/
class MyWeakObject {
	String mwname;
	
	// �вι�����
	public MyWeakObject(String mwname) {
		this.mwname = mwname;
	}
	
	// ��дfinalize����
	public void finalize() {
		System.out.println(mwname + "�������������ռ������������ռ�������");
	}
	
	// �Զ����show()����
	public void show() {
		System.out.println(mwname + "���󻹿��Ա����ã�����");
	}
}

/*����*/
public class MyWeakObjectTest {

	public static void main(String[] args) {
		// ��ͨ�����õ�ʹ��
		System.out.println("-----�����ö��������ռ������-----");
		// ����һ��MyWeakObject����
		MyWeakObject mwo = new MyWeakObject("MyWeakObject1");
		// ��������ָ�򴴽���MyWeakObject����
		WeakReference wr = new WeakReference(mwo);
		// ʹMyWeakObject�������������ռ�����
		mwo = null;
		// ͨ�������÷���MyWeakObject����
		((MyWeakObject)wr.get()).show();
		// ������������ռ���
		System.out.println("��һ�ν��������ռ�������");
		System.gc();
		// �����ӳ�ʹ�����ռ������ж����������̴߳���
		try {
			Thread.sleep(100);          // ���߳�����100����
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// �ٴ�ͨ�������÷���MyWeakObject����
		if(wr.get() != null)
			((MyWeakObject)wr.get()).show();
		
		// ������Map-----WeakHashMap��ʹ��
		System.out.println("-----������Map-----");
		// ����������Map����
		WeakHashMap whm = new WeakHashMap();
		// ����һ��MyWeakObject����
		MyWeakObject mwo2 = new MyWeakObject("MyWeakObject2");
		// ��MyWeakObject����Ž�������Map��
		whm.put(mwo2, "xxxxx");               // ������Map��key��������
		// ʹMyWeakObject�������������ռ�����
		mwo2 = null;
		// ͨ�������÷��ʼ�����
		((MyWeakObject)whm.keySet().iterator().next()).show();
		// �������������ռ���
		System.out.println("�ڶ��ν��������ռ�������");
		System.gc();
		// �����ӳ�ʹ�����ռ������ж����������̴߳���
		try {
			Thread.sleep(100);          // ���߳�����100����
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
