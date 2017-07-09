//�½�14.4.1                         ͨ��ִ��ѭ������¼���������ֳ����ȼ��ĸߵ�
package ex14_04_1;

class Clicker implements Runnable {

	int click=0;
	Thread t;
	
	//Ӧ�ùؼ���volatile
	private volatile boolean running=true;
	
	public Clicker(int p) {
		t=new Thread(this);
		t.setPriority(p);           //�����߳����ȼ�
	}
	
	public void run() {    //�߳�����
		while(running)
			click++;
	}
	
	public void stop() {      //�߳̽���
		running=false;
	}
	
	public void start() {
		t.start();
	}
}

//���в�����
public class Test {
	public static void main(String[] args) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		Clicker hi=new Clicker(Thread.NORM_PRIORITY+2);
		Clicker lo=new Clicker(Thread.NORM_PRIORITY-2);
		hi.start();
		lo.start();
		try {
			Thread.sleep(10000);
		} catch(Exception e) {
			System.out.println("���߳��쳣");
		}
		
		lo.stop();
		hi.stop();
		try {
			hi.t.join();
			lo.t.join();
		} catch(Exception e) {
			System.out.println("�쳣");
		}
		
		//������
		System.out.println("�����ȼ��̣߳�"+lo.click);
		System.out.println("�����ȼ��̣߳�"+hi.click);
	}
}