// 章节16.04.1             孤岛垃圾的收集
package ex16_04_1;

/*自定义的“垃圾”类*/
class Rubbish {
	// 定义一个自身类型的引用
	Rubbish brother;
	// 定义字符串变量
	String rname;
	
	// 无参构造器
	public Rubbish() {
		
	}
	
	// 有叁构造器
	public Rubbish(String rname) {
		this.rname = rname;
	}
	
	// 重写finalize()方法
	public void finalize() {
		System.out.println(this.rname + "对象成为垃圾，并被收集！！！");
	}
}

public class Sample16_4 {

	public static void main(String[] args) {
		// 创建3个Rubbish对象
		Rubbish r1 = new Rubbish("孤岛中的r1");
		Rubbish r2 = new Rubbish("孤岛中的r2");
		Rubbish r3 = new Rubbish("孤岛中的r3");
		
		// 让三个对象互相引用形成一个环
		r1.brother = r2;
		r2.brother = r3;
		r3.brother = r1;
		
		// 断绝环与外界的联系，形成孤岛
		r1 = null;
		r2 = null;
		r3 = null;
		
		// 申请执行垃圾收集
		System.gc();
		// 主线程休眠，加大申请成功的机会
		try {
			Thread.sleep(100);         //主线程休眠100毫秒
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
