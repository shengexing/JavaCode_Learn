//�½�8.10              �̳߳�
package ep8_10;

/**
 * һ���򵥵�����*/
public class MyTask implements Task{
	private int taskID=0;         //�����ID
	public MyTask(int id) {
		this.taskID=id;
	}
	
	/*ʵ��Task�ӿڵ�perform����*/
	public void perform() throws Exception {
		System.out.println("MyTask "+taskID+" :start");
		//����һ��
		try {
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
			
		}
		System.out.println("MyTask "+taskID+" :end");
	}

}
