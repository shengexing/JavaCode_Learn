//�½�8.6                     ����������������
package ep8_06;

/*
 * �����ߣ������̣߳�ģ����������Ϊ*/

class Consumer extends Thread{
	private Warehouse warehouse;          //�����߻�ȡ��Ʒ�Ĳֿ�
	private boolean running=false;         //�Ƿ���Ҫ�����̵߳ı�־λ
	
	public Consumer(Warehouse warehouse, String name) {
		super(name);
		this.warehouse=warehouse;
	}
	
	public void start() {
		this.running=true;
		super.start();
	}
	
	public void run() {
		Product product;
		try {
			while(running) {
				//�Ӳֿ��л�ȡ��Ʒ
				product=warehouse.getProduct();
				sleep(500);
			}
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	/*ֹͣ�������߳�*/
	public void stopConsumer() {
		synchronized(warehouse) {
			this.running=false;
			warehouse.notifyAll();           //֪ͨ�ȴ��ֿ���߳�
		}
	}
	
	/*�������߳��Ƿ�������*/
	public boolean isRunning() {
		return running;
	}
}