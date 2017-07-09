//�½�8.4                 �̵߳�Э��
package ep8_04;

import java.util.Vector;

/**
 * �̼߳��Э��
 */
public class WaitNofity {

	/**
	 * ��ӡ��Ϣ���࣬��һ���߳�
	 */
	static class Printer extends Thread {
		Vector task=new Vector();
		boolean running=false;

		public void start() {
			this.running=true;
			super.start();
		}

		public void run() {
			try {
				System.out.println("Printer begin!");
				while(running) {
					synchronized(this) {
						while((task.size()==0)&&running) {
							//��������б�Ϊ�գ����̻߳��������У���ȴ�����
							System.out.println("wait begin!");
							//���߳̽���ȴ�״̬��ֱ���������̻߳���
							wait();
							System.out.println("wait end!");
						}
					}
					if(running) {
						System.out.println("print the task: "+task.remove(0));
					}
				}
				System.out.println("Printer end!");
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/*��Ӵ���ӡ������*/
		public void addTask(String str) {
			synchronized(this) {
				this.task.add(str);
				//���������ȴ����߳�
				System.out.println("addTask notify!");
				notify();          //notifyAll();
			}
		}
		
		/*ֹͣ�߳�*/
		public void stopPrinter() {
			this.running=false;
			synchronized(this) {
				//���������ȴ����߳�
				System.out.println("stopPrinter notify!");
				notify();
			}
		}
	}
	
	public static void main(String[] args) {
		Printer printer=new Printer();
		printer.start();        //������ӡ�߳�
		//�������
		try {
			Thread.sleep(1000);
			for(int i=0; i<5; i++) {
				Thread.sleep(1000);      //����200����
				printer.addTask("The task "+i);
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		printer.stopPrinter();
	}

}
