//�½�14.10.1          ����������߳�
package ex14_10_1;

import java.util.Date;

public class DefineThread {
	/*ͨ���̳�java.lang.Thread�ඨ���߳�*/
	class ThreadA extends Thread {
		private Date runDate;            //�̱߳����е�ʱ��
		
		//���̱߳�����ʱ���ô˷���
		public void run() {
			System.out.println("ThreadA begin, ");
			this.runDate=new Date();
			System.out.println("ThreadA end. ");
		}
	}
	
	/*ͨ��ʵ��java.lang.Runnable�ӿڶ����߳�*/
	class ThreadB implements Runnable {
		private Date runDate;             //�̱߳����е�ʱ��
		public void run() {
			System.out.println("ThreadB begin, ");
			this.runDate=new Date();
			System.out.println("ThreadB end. ");
		}
	}
	
	/*����һ��ThreadA�߳�*/
	public void startA() {
		Thread threadA=new ThreadA();
		//����Thread��start���������߳�
		threadA.start();
	}
	
	/*����һ��ThreadB�߳�*/
	public void startB() {
		Runnable tb=new ThreadB();
		//��Runable �������߳�
		Thread threadB=new Thread(tb);
		threadB.start();
	}
	
	public static void main(String[] args) {
		DefineThread test=new DefineThread();
		//�̵߳����о��в�ȷ���ԣ����������̲߳�һ�������У�ȡ���������
		test.startA();
		test.startB();
	}

}
