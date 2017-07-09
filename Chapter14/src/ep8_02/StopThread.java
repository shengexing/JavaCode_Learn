//�½�8.2             ֹͣ�߳�
package ep8_02;

/**
 * ֹͣ�߳�
 */
public class StopThread {
	private ThreadA thread=new ThreadA();         //�̶߳���
	
	/*�Զ����߳���*/
	class ThreadA extends Thread {
		private boolean running=false;          //����߳��Ƿ���Ҫ����
		//�����˸����start����
		public void start() {
			//��running��Ϊture����ʾ�߳���Ҫ����
			this.running=true;
			super.start();
		}
		
		public void run() {
			System.out.println("ThreadA begin!");
			int i=0;
			try {
				//���runningΪ�棬˵���̻߳����Լ�������
				while(running) {
					System.out.println("ThreadA: "+i++);
					//sleep��������ǰ�߳�����
					Thread.sleep(200);
				}
			} catch(InterruptedException e) {
				
			}
			System.out.println("ThreadA end!");
		}
		
		public void setRunning(boolean running) {
			this.running=running;
		}
	}
	
	/*����ThreadA�߳�*/
	public void startThreadA() {
		System.out.println("To start ThreadA!");
		thread.start();
	}
	
	/*ֹͣThreadA�߳�*/
	public void stopThreadA() {
		System.out.println("To stop ThreadA!");
		thread.setRunning(false);
	}

	public static void main(String[] args) {
		StopThread test=new StopThread();    //����ThreadA�߳�
		test.startThreadA();
		//��ǰ�߳���Ϣһ����
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		//ֹͣThreadA�߳�
		test.stopThreadA();
	}
}
