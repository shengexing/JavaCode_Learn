// 章节16.05.1             线程垃圾的回收
package ex16_05_1;

/*定义线程垃圾类*/
class RubbishThread extends Thread {
	// 定义一个自身类型的引用
	RubbishThread brother;
	// 定义字符串变量
	String rtname;
	
	// 无参构造器
	public RubbishThread() {
		
	}
	
	// 有参构造器
	public RubbishThread(String rtname) {
		this.rtname = rtname;
	}
	
	// 重写run方法
	public void run() {
		System.out.println(rtname + "开始执行！！！");
		// 对线程进行延迟，使其在足够时间内是活着的
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(rtname + "执行结束");
	}
	
	// 重写finalize()方法
	public void finalize() {
		System.out.println(rtname + "对象成为垃圾，并被收集！！！");
	}
}

// 主类
public class Sample16_5 {

	public static void main(String[] args) {
		// 创建三个线程对象
		RubbishThread rt1 = new RubbishThread("孤岛中的rt1线程");
		RubbishThread rt2 = new RubbishThread("孤岛中的rt2线程");
		RubbishThread rt3 = new RubbishThread("孤岛中的rt3线程");
		
		// 让每个线程的brother引用指向其他线程对象，形成一个环
		rt1.brother = rt2;
		rt2.brother = rt3;
		rt3.brother = rt1;
		
		// 启动一个线程
		rt1.start();
		
		// 形成孤岛
		rt1 = null;
		rt2 = null;
		rt3 = null;
		
		// 申请执行垃圾收集器
		System.out.println("-----对无引用但活着的线程进行垃圾收集-----");
		System.gc();
		
		// 设置延迟使垃圾收集运行而不运行主线程代码
		try {
			Thread.sleep(2000);      //主线程休眠2000毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 线程进入死亡状态后申请执行垃圾收集
		System.out.println("-----对无引用并死亡的线程进行垃圾收集-----");
		System.gc();
		// 设置延迟使垃圾收集器运行而不运行主线程代码
		try {
			Thread.sleep(1000);     //主线程休眠1000毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
