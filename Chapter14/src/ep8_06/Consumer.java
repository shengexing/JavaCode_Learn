//章节8.6                     生产者消费者问题
package ep8_06;

/*
 * 消费者，采用线程，模拟消费者行为*/

class Consumer extends Thread{
	private Warehouse warehouse;          //消费者获取产品的仓库
	private boolean running=false;         //是否需要结束线程的标志位
	
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
				//从仓库中获取产品
				product=warehouse.getProduct();
				sleep(500);
			}
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	/*停止消费者线程*/
	public void stopConsumer() {
		synchronized(warehouse) {
			this.running=false;
			warehouse.notifyAll();           //通知等待仓库的线程
		}
	}
	
	/*消费者线程是否在运行*/
	public boolean isRunning() {
		return running;
	}
}