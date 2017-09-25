// 章节18.06.1            利用AccessibleObject中的方法去除访问限制的例子
package ex18_06_1;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 自定义用来测试的类
class Employee {
	private String sname;	// 员工姓名
	
	// 私有方法
	private void sayHello() {
		System.out.println("你好，我是" + sname 
				+ "，恭喜你成功访问了private的方法sayHello！！！");
	}
}

// 主类
public class Sample18_6 {

	public static void main(String[] args) {
		try {
			// 创建Employee对象
			Employee tom = new Employee();
			
			// 获取Employee类对应的Class对象
			Class<?> ec = tom.getClass();
			
			// 获取Employee类声明的成员变量对应的Field数组
			Field[] fa = ec.getDeclaredFields();
			
			// 设置sname成员变量的访问限制为允许
			fa[0].setAccessible(true);
			
			// 设置sname成员变量的值
			fa[0].set(tom, "Tom");
			
			// 获取Employee类声明的方法对应的Method数组
			Method[] ma = ec.getDeclaredMethods();
			
			// 设置所有方法的访问限制为允许
			AccessibleObject.setAccessible(ma, true);
			
			// 调用sayHello方法
			ma[0].invoke(tom, new Object[0]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
