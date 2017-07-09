//章节14.10.3             线程优先级
package ex14_10_3;

public class Priority {
	
	static class MyThread extends Thread {
		private int ID=0;
		public MyThread(int id) {
			this.ID=id;
		}
		public void run() {
			System.out.println("MyThread-"+this.ID+" begin! Priority: "+this.getPriority());
			System.out.println("MyThread-"+this.ID+" end!");
		}
	}
	
	public static void main(String[] args) {
		//建立3个优先级不同的线程，优先级分别为1，4，7
		MyThread[] myThreads=new MyThread[3];
		for(int i=0; i<3; i++) {
			myThreads[i]=new MyThread(i+1);
			myThreads[i].setPriority(i*3+1);
		}
		//按优先级从低到高启动线程
		for(int i=0; i<3; i++) {
			myThreads[i].start();
		}
		//先启动的线程不一定先运行，虚拟机会考虑线程的优先级
		//同等情况下，优先级高的线程先运行
		}
}
