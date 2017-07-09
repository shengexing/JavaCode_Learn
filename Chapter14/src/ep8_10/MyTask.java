//章节8.10              线程池
package ep8_10;

/**
 * 一个简单的任务*/
public class MyTask implements Task{
	private int taskID=0;         //任务的ID
	public MyTask(int id) {
		this.taskID=id;
	}
	
	/*实现Task接口的perform方法*/
	public void perform() throws Exception {
		System.out.println("MyTask "+taskID+" :start");
		//休眠一秒
		try {
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
			
		}
		System.out.println("MyTask "+taskID+" :end");
	}

}
