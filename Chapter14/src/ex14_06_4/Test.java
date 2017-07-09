//章节14.6.4               线程的加入方法示例
package ex14_06_4;

public class Test {

	public static void main(String[] args) {
		//定义3个线程
		MyThread1 mt1=new MyThread1();
		MyThread2 mt2=new MyThread2();
		MyThread3 mt3=new MyThread3();
		MyThread4 mt4=new MyThread4();
		mt2.mt=mt1;
		//分别启动3个线程
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
	}
}

class MyThread1 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //循环输出20个我
			System.out.print("我");
			try {
				Thread.sleep(1000);        //2000毫秒的间隔
			} catch(InterruptedException e) {
				System.out.println("异常"+e);
			}
		}
	}
}

class MyThread2 extends Thread {
	public MyThread1 mt;
	public void run() {
		for(int i=0; i<5; i++) {         //循环输出20个你
			System.out.print("你");
			try {
				Thread.sleep(1000);        //2000毫秒的间隔
			} catch(InterruptedException e) {
				System.out.println("异常"+e);
			}
			if(i==1) {        //当打印第十个“你”后，运行
				try {
					mt.join();
				} catch(Exception e) {
					System.out.println("异常"+e);
				}
			}
		}
	}
}

class MyThread3 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //循环输出20个他
			System.out.print("他");
			try {
				Thread.sleep(1000);        //2000毫秒的间隔
			} catch(InterruptedException e) {
				System.out.println("异常"+e);
			}
		}
	}
}

class MyThread4 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {         //循环输出20个他
			System.out.print("它");
			try {
				Thread.sleep(1000);        //2000毫秒的间隔
			} catch(InterruptedException e) {
				System.out.println("异常"+e);
			}
		}
	}
}
