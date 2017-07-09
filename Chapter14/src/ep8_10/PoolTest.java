//章节8.10              线程池
package ep8_10;

/**
 * 测试线程池
 */
public class PoolTest {

	public static void main(String[] args) {
		int numThreads=3;            //线程池中的线程数
		MyThreadPool threadPool=new MyThreadPool(numThreads);         //生成线程池
		int numTasks=10;         //任务数
		//运行任务
		for(int i=0; i<numTasks; i++) {
			threadPool.performTask(new MyTask(i));
		}
		//关闭线程池并等待所有任务完成
		threadPool.join();
	}

}
