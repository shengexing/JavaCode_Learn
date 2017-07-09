//章节14.4.1                         通过执行循环，记录次数来表现出优先级的高低
package ex14_04_1;

class Clicker implements Runnable {

	int click=0;
	Thread t;
	
	//应用关键字volatile
	private volatile boolean running=true;
	
	public Clicker(int p) {
		t=new Thread(this);
		t.setPriority(p);           //设置线程优先级
	}
	
	public void run() {    //线程运行
		while(running)
			click++;
	}
	
	public void stop() {      //线程结束
		running=false;
	}
	
	public void start() {
		t.start();
	}
}

//运行测试类
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
			System.out.println("主线程异常");
		}
		
		lo.stop();
		hi.stop();
		try {
			hi.t.join();
			lo.t.join();
		} catch(Exception e) {
			System.out.println("异常");
		}
		
		//输出结果
		System.out.println("低优先级线程："+lo.click);
		System.out.println("高优先级线程："+hi.click);
	}
}