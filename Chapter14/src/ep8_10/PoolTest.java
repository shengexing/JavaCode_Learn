//�½�8.10              �̳߳�
package ep8_10;

/**
 * �����̳߳�
 */
public class PoolTest {

	public static void main(String[] args) {
		int numThreads=3;            //�̳߳��е��߳���
		MyThreadPool threadPool=new MyThreadPool(numThreads);         //�����̳߳�
		int numTasks=10;         //������
		//��������
		for(int i=0; i<numTasks; i++) {
			threadPool.performTask(new MyTask(i));
		}
		//�ر��̳߳ز��ȴ������������
		threadPool.join();
	}

}
