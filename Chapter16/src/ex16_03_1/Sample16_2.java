// 章节16.03.1             重写finalize()方法的例子
package ex16_03_1;

/*定义一个父类*/
class Father {
	// 重写finalize()方法
	public void finalize() throws Throwable {
		// 调用父类的finalize()方法
		super.finalize();
		// 自己类的清理代码
		System.out.println("恭喜你，这里是Father类，清理前成功调用finalize()方法！！！");
	}
}

/*定义一个继承自Father的子类*/
class Son extends Father {
	// 子类也重写finalize()方法
	public void finalize() throws Throwable {
		// 调用父类的finalize()方法
		super.finalize();
		// 自己类的清理代码
		System.out.println("恭喜你，这里是Son类，清理前成功调用finalize()方法！！！");
	}
}

/*主类*/
public class Sample16_2 {

	public static void main(String[] args) {
		// 创建Son对象，使其成为垃圾
		new Son();
		// 申请垃圾收集器执行
		System.gc();
		
		// 休眠主线程，提高申请垃圾收集器运行的成功率
		try {
			Thread.sleep(100);         //主线程休眠100毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
