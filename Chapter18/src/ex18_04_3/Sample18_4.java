// 章节18.04.3            使用Constructor类的例子
package ex18_04_3;

import java.lang.reflect.Constructor;

// 自定义用来测试的类
class Student {
	String sname;	// 姓名
	int sage;	// 年龄
	
	// 声明无参构造器
	public Student() {
		sname = "Tom";
		sage = 23;
	}
	
	// 声明有参构造器
	public Student(String sname, int sage) {
		this.sname = sname;
		this.sage = sage;
	}
	
	// 声明一个普通方法
	public void sayHello() {
		System.out.println("你好，我是" + sname + "，今年" + sage + "岁！！！");
	}
}

// 主类
public class Sample18_4 {

	public static void main(String[] args) {
		try {
			// 获取Student类对应的Class对象
			Class<?> sc = Student.class;
			
			// 获取可以访问的构造器对应的Constructor数组
			Constructor<?>[] ca = sc.getConstructors();
			
			// 对数组进行扫描打印构造器信息
			System.out.println("构造器名称\t\t参数列表");
			
			int size = ca.length;
			
			for(int i = 0; i < size; i++) {
				Constructor<?> tempc = ca[i];
				
				// 打印构造器名称
				String cname = tempc.getName();
				System.out.print(cname + "\t\t");
				
				// 循环打印构造器的参数序列
				Class<?>[] pa = tempc.getParameterTypes();
				int psize = pa.length;
				if(psize == 0)
					System.out.print("没有参数");
				for(int j = 0; j < psize; j++)
					System.out.print(pa[j].getName() + ((j == psize - 1) ? "" : "，"));
				// 换行
				System.out.println();
			}
			
			// 使用反射调用无参构造器创建对象
			Student stu = (Student)ca[0].newInstance(new Object[0]);
			
			// 调用创建对象的sayHello方法
			stu.sayHello();
			
			// 使用反射调用有参构造器创建对象
			stu = (Student)ca[1].newInstance(new Object[] {"王强", new Integer(25)});
			
			// 调用创建对象的sayHello方法
			stu.sayHello();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
