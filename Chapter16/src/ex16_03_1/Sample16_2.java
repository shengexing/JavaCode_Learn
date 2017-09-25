// �½�16.03.1             ��дfinalize()����������
package ex16_03_1;

/*����һ������*/
class Father {
	// ��дfinalize()����
	public void finalize() throws Throwable {
		// ���ø����finalize()����
		super.finalize();
		// �Լ�����������
		System.out.println("��ϲ�㣬������Father�࣬����ǰ�ɹ�����finalize()����������");
	}
}

/*����һ���̳���Father������*/
class Son extends Father {
	// ����Ҳ��дfinalize()����
	public void finalize() throws Throwable {
		// ���ø����finalize()����
		super.finalize();
		// �Լ�����������
		System.out.println("��ϲ�㣬������Son�࣬����ǰ�ɹ�����finalize()����������");
	}
}

/*����*/
public class Sample16_2 {

	public static void main(String[] args) {
		// ����Son����ʹ���Ϊ����
		new Son();
		// ���������ռ���ִ��
		System.gc();
		
		// �������̣߳�������������ռ������еĳɹ���
		try {
			Thread.sleep(100);         //���߳�����100����
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
