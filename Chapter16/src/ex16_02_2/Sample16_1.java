// 章节16.02.2             申请垃圾收集器运行
package ex16_02_2;

public class Sample16_1 {
	public static void main(String[] args) {
		// 获得该应用程序的Runtime对象
		Runtime rt = Runtime.getRuntime();
		
		// 打印当前JVM使用的总内存量与可使用内存量
		System.out.println("当前JVM使用的总内存量为：" + rt.totalMemory());
		
		// 申请垃圾收集器运行
		System.gc();
		
		// 休眠主线程，提高申请垃圾收集器运行的成功率
		try {
			Thread.sleep(100);         //主线程休眠100毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("创建10000000个垃圾对象前，JVM中可使用"
																			+ "的内存量为：" + rt.freeMemory());
		
		// 创建10000000个“垃圾”对象
		for(int i = 0; i < 10000000; i++)
			new String("Rubbish");
		
		// 打印创建“垃圾”对象后的可使用内存量
		System.out.println("创建10000000个垃圾对象后，JVM中可使用"
																			+ "的内存量为：" + rt.freeMemory());
		
		// 申请垃圾收集器运行
		System.gc();
		
		// 休眠主线程，提高申请垃圾收集器运行的成功率
		try {
			Thread.sleep(100);         //主线程休眠100毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 打印申请垃圾收集器运行后的可使用内存量
		System.out.println("申请垃圾收集器运行后，JVM中可使用"
																			+ "的内存量为：" + rt.freeMemory());
		
	}

}
