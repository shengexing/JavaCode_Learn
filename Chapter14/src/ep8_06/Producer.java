//�½�8.6                     ����������������
package ep8_06;

/*
 * �������࣬�����̣߳�ģ�������ߵ���Ϊ*/
class Producer extends Thread{
	private Warehouse warehouse;          //�����ߴ洢��Ʒ�Ĳֿ�
	private static int produceName=0;      //��Ʒ������
	private boolean running=false;         //�Ƿ���Ҫ�����̵߳ı�ʾλ
	
	public Producer(Warehouse warehouse, String name) {
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
				//�������洢��Ʒ
				product=new Product((++produceName)+"");
				this.warehouse.storageProduct(product);
				sleep(300);
			}
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	/*ֹͣ�������߳�*/
	public void stopProducer() {
		synchronized(warehouse) {
			this.running=false;
			warehouse.notifyAll();        //֪ͨ�ȴ��ֿ���߳�
		}
	}
	
	/*�������߳��Ƿ�������*/
	public boolean isRunning() {
		return running;
	}
}