//�½�14.2.2                ʵ��Runnable�ӿڴ����߳�
package ex14_02_2;

public class Test {

	public static void main(String[] args) {
		//ʵ����һ���߳�
		MyThread r=new MyThread();
		Thread t=new Thread(r);
		//��run�������е���
		t.start();
		//����������
		for(int i=0; i<5; i++)
			System.out.println("���߳�");
	}

}

class MyThread implements Runnable {
	int i=0;
	//����run����
	public void run() {
		//�߳�����
		while(true) {
			System.out.println("Runnable "+i++);
			if(i==3)
				break;
		}
	}
}
