// �½�16.05.1             �߳������Ļ���
package ex16_05_1;

/*�����߳�������*/
class RubbishThread extends Thread {
	// ����һ���������͵�����
	RubbishThread brother;
	// �����ַ�������
	String rtname;
	
	// �޲ι�����
	public RubbishThread() {
		
	}
	
	// �вι�����
	public RubbishThread(String rtname) {
		this.rtname = rtname;
	}
	
	// ��дrun����
	public void run() {
		System.out.println(rtname + "��ʼִ�У�����");
		// ���߳̽����ӳ٣�ʹ�����㹻ʱ�����ǻ��ŵ�
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(rtname + "ִ�н���");
	}
	
	// ��дfinalize()����
	public void finalize() {
		System.out.println(rtname + "�����Ϊ�����������ռ�������");
	}
}

// ����
public class Sample16_5 {

	public static void main(String[] args) {
		// ���������̶߳���
		RubbishThread rt1 = new RubbishThread("�µ��е�rt1�߳�");
		RubbishThread rt2 = new RubbishThread("�µ��е�rt2�߳�");
		RubbishThread rt3 = new RubbishThread("�µ��е�rt3�߳�");
		
		// ��ÿ���̵߳�brother����ָ�������̶߳����γ�һ����
		rt1.brother = rt2;
		rt2.brother = rt3;
		rt3.brother = rt1;
		
		// ����һ���߳�
		rt1.start();
		
		// �γɹµ�
		rt1 = null;
		rt2 = null;
		rt3 = null;
		
		// ����ִ�������ռ���
		System.out.println("-----�������õ����ŵ��߳̽��������ռ�-----");
		System.gc();
		
		// �����ӳ�ʹ�����ռ����ж����������̴߳���
		try {
			Thread.sleep(2000);      //���߳�����2000����
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// �߳̽�������״̬������ִ�������ռ�
		System.out.println("-----�������ò��������߳̽��������ռ�-----");
		System.gc();
		// �����ӳ�ʹ�����ռ������ж����������̴߳���
		try {
			Thread.sleep(1000);     //���߳�����1000����
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
