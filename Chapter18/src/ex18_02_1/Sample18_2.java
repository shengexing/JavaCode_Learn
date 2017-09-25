// 章节18.02.1            Class类的简单使用
package ex18_02_1;

// 用来被加载类的父类
class MyFather {
	// 父类的公共成员变量
	public int memberFather;
	
	// 父类的公共方法
	public void methodFather() {
		System.out.println("我是从父类继承而来的方法methodFather！！！");
	}
}

// 用来被加载的类
class MySon extends MyFather {
	// 子类的公共成员变量
	public int memberSonPublic;
	
	// 子类的私有成员变量
	private int memberSonPrivate;
	
	// 子类的公共方法
	public void methodSonPublic() {
		System.out.println("我是子类自己的方法methodSonPublic！！！");
	}
	
	// 子类的保护方法
	protected void methodSonProtected() {
		System.out.println("我是子类自己的方法methodSonProtected！！！");
	}
}

// 主类
public class Sample18_2 {

	public static void main(String[] args) {
		try {
			/*// 加载指定的类
			Class<?> c = Class.forName("ex18_02_1.MySon");
			
			// 创建加载类的对象
			MySon ms = (MySon)c.newInstance();*/
			
			// 创建MySon对象
			MySon ms = new MySon();
			
			// 获取Class对象
			Class<?> c = ms.getClass();
			
			// 调用创建对象的方法
			System.out.println("=========="
					+ "调用创建对象的方法"
					+ "==========");
			ms.methodSonProtected();
			ms.methodSonPublic();
			ms.methodFather();
			
			// 打印加载类的详细信息
			System.out.println("=========="
					+ "加载类的信息"
					+ "==========");
			System.out.println(c.getName() + "类自己声明了" 
					+ c.getDeclaredFields().length + "个成员变量。");
			System.out.println(c.getName() + "类对外公布的方法有" 
					+ c.getMethods().length + "个。");
			
			for(int i = 0; i < c.getMethods().length; i++)
				System.out.println(c.getMethods()[i]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
