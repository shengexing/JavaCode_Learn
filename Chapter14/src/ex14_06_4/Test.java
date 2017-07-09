//�½�14.6.4               �̵߳ļ��뷽��ʾ��
package ex14_06_4;

public class Test {

	public static void main(String[] args) {
		//����3���߳�
		MyThread1 mt1=new MyThread1();
		MyThread2 mt2=new MyThread2();
		MyThread3 mt3=new MyThread3();
		MyThread4 mt4=new MyThread4();
		mt2.mt=mt1;
		//�ֱ�����3���߳�
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
	}
}

class MyThread1 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //ѭ�����20����
			System.out.print("��");
			try {
				Thread.sleep(1000);        //2000����ļ��
			} catch(InterruptedException e) {
				System.out.println("�쳣"+e);
			}
		}
	}
}

class MyThread2 extends Thread {
	public MyThread1 mt;
	public void run() {
		for(int i=0; i<5; i++) {         //ѭ�����20����
			System.out.print("��");
			try {
				Thread.sleep(1000);        //2000����ļ��
			} catch(InterruptedException e) {
				System.out.println("�쳣"+e);
			}
			if(i==1) {        //����ӡ��ʮ�����㡱������
				try {
					mt.join();
				} catch(Exception e) {
					System.out.println("�쳣"+e);
				}
			}
		}
	}
}

class MyThread3 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //ѭ�����20����
			System.out.print("��");
			try {
				Thread.sleep(1000);        //2000����ļ��
			} catch(InterruptedException e) {
				System.out.println("�쳣"+e);
			}
		}
	}
}

class MyThread4 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //ѭ�����20����
			System.out.print("��");
			try {
				Thread.sleep(1000);        //2000����ļ��
			} catch(InterruptedException e) {
				System.out.println("�쳣"+e);
			}
		}
	}
}
