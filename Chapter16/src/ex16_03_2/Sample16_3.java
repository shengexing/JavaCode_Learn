// 章节16.03.2             阻止垃圾收集的例子
package ex16_03_2;

/*定义一个能够阻止垃圾收集的类*/
class CallBack {
	// 定义用于挽救一个对象的静态引用
	static CallBack help;
	// 定义输出方法show
	public void show() {
		System.out.println("show方法还能访问，该对象没有被垃圾收集器收集！！！");
	}
	
	// 重写了finalize()方法
	public void finalize() {
		System.out.println("第一次收集CallBack对象，调用了finalize方法！！！");
		// 挽救自己这个对象不成为垃圾！！！
		CallBack.help = this;
	}
}

/*定义一个普通的类*/
class Common {
	// 重写了finalize方法
	public void finalize() {
		System.out.println("收集Common对象，调用了finalize方法！！！");
	}
}

/*主类*/
public class Sample16_3 {

	public static void main(String[] args) {
		// 创建一个CallBack对象并使其成为垃圾
		System.out.println("-----创建一个CallBack对象并使其成为垃圾-----");
		new CallBack();
		// 申请垃圾收集器运行
		System.gc();
		// 主线程休眠，加大申请成功的机会
		try {
			Thread.sleep(100);         //主线程休眠100毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 第一次垃圾收集后调用CallBack对象的show()方法
		CallBack.help.show();
		
		// 创建一个Common对象并使其成为垃圾
		System.out.println("-----创建一个Common对象并使其成为垃圾-----");
		new Common();
		// 再次使CallBack对象成为垃圾
		System.out.println("-----再次使CallBack对象成为垃圾-----");
		CallBack.help = null;
		
		// 再次申请垃圾收集器运行
		System.gc();
		// 主线程休眠，加大申请成功的机会
		try {
			Thread.sleep(100);         //主线程休眠100毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 第二次垃圾收集后调用CallBack对象的show方法
		CallBack.help.show();
	}

}
