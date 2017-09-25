// 章节18.04.1            使用Method类的例子
package ex18_04_2;

import java.lang.reflect.Method;

// 自定义用来测试的类
class ForMethod {
	// 声明静态方法sayHello，功能为在屏幕上打印字符串
	public static void sayHello(String name) {
		System.out.println("你好，" + name + "！！！");
	}
	
	// 声明非静态方法generateNum，功能为产生min与max之间的随机数
	public String genrateNum(int max, int min) {
		return ((int)(Math.random()*(max - min) + min)) + "";
	}
}

// 主类
public class Sample18_4 {

	public static void main(String[] args) {
		try {
			// 创建ForMethod类对象
			ForMethod fm = new ForMethod();
			
			// 获取ForMethod类对应的Class对象
			Class<?> fmc = fm.getClass();
			
			// 获取可以访问的方法对应的Method数组
			Method[] ma = fmc.getMethods();
			
			// 对数组进行扫描打印方法的信息
			System.out.println("方法名称\t返回值类型\t\t参数列表");
			
			int size = ma.length;
			
			for(int i = 0; i < size; i++) {
				Method tempm = ma[i];
				
				// 打印方法名称
				String mname = tempm.getName();
				System.out.print(mname + ((mname.length() > 7) ? "\t" : "\t\t"));
				
				// 打印方法的返回值类型
				String mReturnType = tempm.getReturnType().getName();
				System.out.print(mReturnType + ((mReturnType.length() > 15) ? "\t" : 
					(mReturnType.length() > 10) ? "\t\t" : "\t\t\t"));
				
				// 循环打印方法的参数序列
				Class<?>[] ca = tempm.getParameterTypes();
				
				int csize = ca.length;
				
				if(csize == 0)
					System.out.print("没有参数");
				for(int j = 0; j < csize; j++)
					System.out.print(ca[j].getName() + ((j == csize - 1) ? "" : "，"));
				
				// 换行
				System.out.println();
			}
			
			// 通过反射调用静态方法sayHello
			System.out.println("=========="
					+ "通过反射调用静态方法sayHello"
					+ "==========");
			ma[0].invoke(null, new Object[] {"王强"});
			
			// 通过反射调用非静态方法generateNum
			System.out.println("=========="
					+ "通过反射调用非静态方法generateNum"
					+ "==========");
			System.out.println(ma[1].invoke(fm, new Object[] {new Integer(100), new Integer(1000)}));
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
