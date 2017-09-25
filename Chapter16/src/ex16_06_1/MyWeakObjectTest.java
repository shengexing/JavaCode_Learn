// 章节16.06.1             使用弱引用与WeakObjectTest的例子
package ex16_06_1;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/*自定义重写finalize()方法的类*/
class MyWeakObject {
	String mwname;
	
	// 有参构造器
	public MyWeakObject(String mwname) {
		this.mwname = mwname;
	}
	
	// 重写finalize方法
	public void finalize() {
		System.out.println(mwname + "对象满足垃圾收集的条件，被收集！！！");
	}
	
	// 自定义的show()方法
	public void show() {
		System.out.println(mwname + "对象还可以被调用！！！");
	}
}

/*主类*/
public class MyWeakObjectTest {

	public static void main(String[] args) {
		// 普通弱引用的使用
		System.out.println("-----弱引用对象垃圾收集的情况-----");
		// 创建一个MyWeakObject对象
		MyWeakObject mwo = new MyWeakObject("MyWeakObject1");
		// 让弱引用指向创建的MyWeakObject对象
		WeakReference wr = new WeakReference(mwo);
		// 使MyWeakObject对象满足垃圾收集条件
		mwo = null;
		// 通过弱引用访问MyWeakObject对象
		((MyWeakObject)wr.get()).show();
		// 申请进行垃圾收集器
		System.out.println("第一次进行垃圾收集！！！");
		System.gc();
		// 设置延迟使垃圾收集器运行而不运行主线程代码
		try {
			Thread.sleep(100);          // 主线程休眠100毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 再次通过弱引用访问MyWeakObject对象
		if(wr.get() != null)
			((MyWeakObject)wr.get()).show();
		
		// 弱引用Map-----WeakHashMap的使用
		System.out.println("-----弱引用Map-----");
		// 创建弱引用Map对象
		WeakHashMap whm = new WeakHashMap();
		// 创建一个MyWeakObject对象
		MyWeakObject mwo2 = new MyWeakObject("MyWeakObject2");
		// 将MyWeakObject对象放进弱引用Map中
		whm.put(mwo2, "xxxxx");               // 若引用Map中key是弱引用
		// 使MyWeakObject对象满足垃圾收集条件
		mwo2 = null;
		// 通过弱引用访问键对象
		((MyWeakObject)whm.keySet().iterator().next()).show();
		// 申请运行垃圾收集器
		System.out.println("第二次进行垃圾收集！！！");
		System.gc();
		// 设置延迟使垃圾收集器运行而不运行主线程代码
		try {
			Thread.sleep(100);          // 主线程休眠100毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
