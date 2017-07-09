//�½�8.10               �̳߳�
package ep8_10;

import java.util.LinkedList;

/**
 * �̳߳أ��̳�ThreadGroup
 * ThreadGroup ���ڴ���һ���̵߳��࣬��һ����״�ṹ�������²�ڵ㻹������ThreadGroup����
 */
public class MyThreadPool extends ThreadGroup{
	private boolean isAlive;            //��־�̳߳��Ƿ���
	private LinkedList taskQueue;     //�̳߳��е��������
	private int threadID;                 //�̳߳��е��߳�ID
	private static int threadPoolID;    //�̳߳�ID
	
	/*�����µ��̳߳أ�numThreads�ǳ��е��߳���*/
	public MyThreadPool(int numThreads) {
		super("ThreadPool-"+(threadPoolID++));
		//����Ϊ���̳߳���daemon����Ϊtrue��
		//��ʾ�����̳߳��������̶߳�������ʱ�����̳߳ػ��Զ�������
		super.setDaemon(true);
		this.isAlive=true;
		this.taskQueue=new LinkedList();        //�½�һ���������
		//����numThreads�������߳�
		for(int i=0; i<numThreads; i++) {
			new PooledThread().start();
		}
	}
	
	/*���������*/
	public synchronized void performTask(Task task) {
		if(!this.isAlive) {
			throw new IllegalStateException();        //�̱߳��ر����׳��쳣
		}
		if(task!=null) {
			this.taskQueue.add(task);        //������ŵ�������е�β��
			notify();                 //֪ͨ�����߳�ȡ����
		}
	}
	
	/*��ȡ����*/
	protected synchronized Task getTask() throws InterruptedException {
		//��������б�Ϊ�գ������̳߳�û�б��رգ�������ȴ�����
		while(this.taskQueue.size()==0) {
			if(!this.isAlive) {
				return null;
			}
			wait();
		}
		
		//ȡ�����б�ĵ�һ������
		return (Task)this.taskQueue.removeFirst();
	}
	
	/*�ر��̳߳أ������߳�ֹͣ������ִ������*/
	public synchronized void close() {
		if(isAlive) {
			this.isAlive=false;
			this.taskQueue.clear();           //�������
			this.interrupt();            //��ֹ�̳߳��е������߳�
		}
	}
	
	/*
	 * �ر��̳߳أ����ȴ��̳߳��е��������������ꡣ
	 * ���ǲ��ܽ����µ�����*/
	public void join() {
		//֪ͨ�����ȴ��̡߳����̳߳��ѹرա�����Ϣ
		synchronized(this) {
			isAlive=false;
			notifyAll();
		}
		//�ȴ������߳����
		//���Ƚ���һ���µ��߳����顣
		//activeCount������ȡ�̳߳��л�̵߳Ĺ�����
		Thread[] threads=new Thread[this.activeCount()];
		
		//���̳߳��еĻ�߳̿������´������߳�����threads��
		int count=this.enumerate(threads);
		for(int i=0; i<count; i++) {
			try {
				threads[i].join();                //�ȴ��߳����н���
			} catch(InterruptedException ex) {
				
			}
		}
	}
	
	/*�ڲ��࣬����ִ������Ĺ����߳�*/
	private class PooledThread extends Thread {
		//���췽��
		public PooledThread() {
			//��һ������Ϊ���߳����ڵ��߳�����󣬼���ǰ�̳߳ض���
			//�ڶ�������Ϊ�߳�����
			super(MyThreadPool.this, "PooledThread-"+(threadID++));
		}
		
		public void run() {
			//������߳�û�б���ֹ
			while(!isInterrupted()) {
				//��ȡ����
				Task task=null;
				try {
					task=getTask();
				} catch(InterruptedException ex) {
					
				}
				//ֻҪ�̳߳ص������б�Ϊ�գ�getTask�������ܵõ�һ������
				//��getTask()����null�����ʾ�̳߳����Ѿ�û�����񣬶����̳߳��Ѿ����ر�
				if(task==null) {
					return;
				}
				//�������������쳣
				try {
					task.perform();
				} catch(Throwable t) {
					//���߳����е��߳���δ��������쳣����ʱ��JVM�ͻ�ȥ����uncaughtException����
					uncaughtException(this, t);
				}
			}
		}
	}
}