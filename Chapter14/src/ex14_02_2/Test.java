//章节14.2.2                实现Runnable接口创建线程
package ex14_02_2;

public class Test {

	public static void main(String[] args) {
		//实例化一个线程
		MyThread r=new MyThread();
		Thread t=new Thread(r);
		//对run方法进行调用
		t.start();
		//主程序内容
		for(int i=0; i<5; i++)
			System.out.println("主线程");
	}

}

class MyThread implements Runnable {
	int i=0;
	//定义run方法
	public void run() {
		//线程内容
		while(true) {
			System.out.println("Runnable "+i++);
			if(i==3)
				break;
		}
	}
}
