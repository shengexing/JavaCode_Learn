//�½�14.2.1                   �̳�Thread�ഴ���߳�
package ex14_02_1;

public class Test {

	public static void main(String[] args) {
		//������̵߳�����
		Thread t=Thread.currentThread();
		//������߳���Ϣ
		System.out.println("���̣߳�"+t);
		//�ı����̵߳���Ϣ
		t.setName("My Thread");
		//���̵߳�����Ϣ
		System.out.println("�ı����ƺ�"+t);
		//�߳�����
		try {
			for(int i=0; i<5; i++) {
				System.out.println(i);
				//ÿ��3���ӡһ����
				t.sleep(3000);
			}
		} catch(Exception e) {
			System.out.println("�����쳣 �д���");
		}
		
	}

}
