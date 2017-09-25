// 章节16.06.3             最终守护者模式的例子
package ex16_06_3;

/*定义实现最终守护者模式的类*/
class FinalGuarder {
	private Object fg = new Object() {
		// 重写了finalize方法
		public void finalize() throws Throwable {
			System.out.println("FinalGuarder类被进行垃圾收集时需要执行的finalize工作！！！");
		}
	};
}

/*定义继承了最终守护者模式的类*/
class FinalGuarderSon extends FinalGuarder {
	// 重写了finalize方法
	public void finalize() throws Throwable {
		System.out.println("FinalGuarderSon类被进行垃圾收集时需要执行的finalize工作！！！");
	}
}

/*主类*/
public class FinalGuarderTest {

	public static void main(String[] args) {
		// 创建一个FinalGuarderSon对象并使其成为垃圾
		new FinalGuarderSon();
		// 申请垃圾收集器运行
		System.gc();
		// 主线程休眠，加大申请成功的机会
		try {
			Thread.sleep(100);              // 主线程休眠100毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
