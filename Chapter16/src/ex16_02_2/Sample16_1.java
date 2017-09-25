// �½�16.02.2             ���������ռ�������
package ex16_02_2;

public class Sample16_1 {
	public static void main(String[] args) {
		// ��ø�Ӧ�ó����Runtime����
		Runtime rt = Runtime.getRuntime();
		
		// ��ӡ��ǰJVMʹ�õ����ڴ������ʹ���ڴ���
		System.out.println("��ǰJVMʹ�õ����ڴ���Ϊ��" + rt.totalMemory());
		
		// ���������ռ�������
		System.gc();
		
		// �������̣߳�������������ռ������еĳɹ���
		try {
			Thread.sleep(100);         //���߳�����100����
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("����10000000����������ǰ��JVM�п�ʹ��"
																			+ "���ڴ���Ϊ��" + rt.freeMemory());
		
		// ����10000000��������������
		for(int i = 0; i < 10000000; i++)
			new String("Rubbish");
		
		// ��ӡ�����������������Ŀ�ʹ���ڴ���
		System.out.println("����10000000�����������JVM�п�ʹ��"
																			+ "���ڴ���Ϊ��" + rt.freeMemory());
		
		// ���������ռ�������
		System.gc();
		
		// �������̣߳�������������ռ������еĳɹ���
		try {
			Thread.sleep(100);         //���߳�����100����
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// ��ӡ���������ռ������к�Ŀ�ʹ���ڴ���
		System.out.println("���������ռ������к�JVM�п�ʹ��"
																			+ "���ڴ���Ϊ��" + rt.freeMemory());
		
	}

}
