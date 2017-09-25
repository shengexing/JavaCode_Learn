// 章节16.06.2             使用软引用的例子
package ex16_06_2;

import java.lang.ref.SoftReference;

/*自定义重写finalize方法的类*/
class MySoftObject {
	String msname;
	
	// 有参构造器
	public MySoftObject(String msname) {
		this.msname = msname;
	}
	
	// 重写finalize方法
	public void finalize() {
		System.out.println(msname + "对象满足垃圾收集的条件，被收集！！！");
	}
	
	// 自定义的show()方法
	public void show() {
		System.out.println(msname + "对象还可以被调用！！！");
	}
}

/*主类*/
public class MySoftObjectTest {

	public static void main(String[] args) {
		// 创建一个MySoftObject对象
		MySoftObject mso = new MySoftObject("MSO");
		// 让软引用指向创建的MySoftObject对象
		SoftReference sr = new SoftReference(mso);
		// 使MySoftObject对象满足垃圾收集条件
		mso = null;
		// 通过弱引用访问MySoftObject对象
		((MySoftObject)sr.get()).show();
		// 申请进行垃圾收集
		System.out.println("第一次进行垃圾收集！！！");
		System.gc();
		// 设置延迟使垃圾收集器运行而不运行主线程代码
		try {
			Thread.sleep(100);          // 主线程休眠100毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 通过软引用访问MySoftObject对象
		((MySoftObject)sr.get()).show();
		// 耗尽内存
		int size = 10000000;
		String[] sa = new String[size];
		for(int i=0; i<size; i++)
			sa[i] = new String("Hello World！！！");

	}

}
