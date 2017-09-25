// �½�16.03.2             ��ֹ�����ռ�������
package ex16_03_2;

/*����һ���ܹ���ֹ�����ռ�����*/
class CallBack {
	// �����������һ������ľ�̬����
	static CallBack help;
	// �����������show
	public void show() {
		System.out.println("show�������ܷ��ʣ��ö���û�б������ռ����ռ�������");
	}
	
	// ��д��finalize()����
	public void finalize() {
		System.out.println("��һ���ռ�CallBack���󣬵�����finalize����������");
		// ����Լ�������󲻳�Ϊ����������
		CallBack.help = this;
	}
}

/*����һ����ͨ����*/
class Common {
	// ��д��finalize����
	public void finalize() {
		System.out.println("�ռ�Common���󣬵�����finalize����������");
	}
}

/*����*/
public class Sample16_3 {

	public static void main(String[] args) {
		// ����һ��CallBack����ʹ���Ϊ����
		System.out.println("-----����һ��CallBack����ʹ���Ϊ����-----");
		new CallBack();
		// ���������ռ�������
		System.gc();
		// ���߳����ߣ��Ӵ�����ɹ��Ļ���
		try {
			Thread.sleep(100);         //���߳�����100����
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// ��һ�������ռ������CallBack�����show()����
		CallBack.help.show();
		
		// ����һ��Common����ʹ���Ϊ����
		System.out.println("-----����һ��Common����ʹ���Ϊ����-----");
		new Common();
		// �ٴ�ʹCallBack�����Ϊ����
		System.out.println("-----�ٴ�ʹCallBack�����Ϊ����-----");
		CallBack.help = null;
		
		// �ٴ����������ռ�������
		System.gc();
		// ���߳����ߣ��Ӵ�����ɹ��Ļ���
		try {
			Thread.sleep(100);         //���߳�����100����
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// �ڶ��������ռ������CallBack�����show����
		CallBack.help.show();
	}

}
