// �½�16.06.3             �����ػ���ģʽ������
package ex16_06_3;

/*����ʵ�������ػ���ģʽ����*/
class FinalGuarder {
	private Object fg = new Object() {
		// ��д��finalize����
		public void finalize() throws Throwable {
			System.out.println("FinalGuarder�౻���������ռ�ʱ��Ҫִ�е�finalize����������");
		}
	};
}

/*����̳��������ػ���ģʽ����*/
class FinalGuarderSon extends FinalGuarder {
	// ��д��finalize����
	public void finalize() throws Throwable {
		System.out.println("FinalGuarderSon�౻���������ռ�ʱ��Ҫִ�е�finalize����������");
	}
}

/*����*/
public class FinalGuarderTest {

	public static void main(String[] args) {
		// ����һ��FinalGuarderSon����ʹ���Ϊ����
		new FinalGuarderSon();
		// ���������ռ�������
		System.gc();
		// ���߳����ߣ��Ӵ�����ɹ��Ļ���
		try {
			Thread.sleep(100);              // ���߳�����100����
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
