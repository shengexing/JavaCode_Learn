//章节14.6.1      线程的休眠方法测试
package ex14_06_3;

public class Test {

	public static void main(String[] args) {
		//定义3个线程
		MyThread1 mt1=new MyThread1();
		MyThread2 mt2=new MyThread2();
		MyThread3 mt3=new MyThread3();
		//分别启动3个线程
		mt1.start();
		mt2.start();
		mt3.start();
	}

}

class MyThread1 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //循环输出20个我
			System.out.print("我");
			try {
				Thread.sleep(2000);        //2000毫秒的间隔
			} catch(InterruptedException e) {
				System.out.println("异常"+e);
			}
		}
		System.out.print("\na");
	}
}

class MyThread2 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //循环输出20个你
			System.out.print("你");
			try {
				Thread.sleep(2000);        //2000毫秒的间隔
			} catch(InterruptedException e) {
				System.out.println("异常"+e);
			}
		}
		System.out.print("\nb");
	}
}

class MyThread3 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //循环输出20个他
			System.out.print("他");
			try {
				Thread.sleep(2000);        //2000毫秒的间隔
			} catch(InterruptedException e) {
				System.out.println("异常"+e);
			}
		}
		System.out.print("\nc");
	}
}
