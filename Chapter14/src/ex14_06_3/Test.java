//�½�14.6.1      �̵߳����߷�������
package ex14_06_3;

public class Test {

	public static void main(String[] args) {
		//����3���߳�
		MyThread1 mt1=new MyThread1();
		MyThread2 mt2=new MyThread2();
		MyThread3 mt3=new MyThread3();
		//�ֱ�����3���߳�
		mt1.start();
		mt2.start();
		mt3.start();
	}

}

class MyThread1 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //ѭ�����20����
			System.out.print("��");
			try {
				Thread.sleep(2000);        //2000����ļ��
			} catch(InterruptedException e) {
				System.out.println("�쳣"+e);
			}
		}
		System.out.print("\na");
	}
}

class MyThread2 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //ѭ�����20����
			System.out.print("��");
			try {
				Thread.sleep(2000);        //2000����ļ��
			} catch(InterruptedException e) {
				System.out.println("�쳣"+e);
			}
		}
		System.out.print("\nb");
	}
}

class MyThread3 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //ѭ�����20����
			System.out.print("��");
			try {
				Thread.sleep(2000);        //2000����ļ��
			} catch(InterruptedException e) {
				System.out.println("�쳣"+e);
			}
		}
		System.out.print("\nc");
	}
}
