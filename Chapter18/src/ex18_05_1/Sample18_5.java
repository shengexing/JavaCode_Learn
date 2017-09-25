// 章节18.05.1            使用getModifiers()方法的例子
package ex18_05_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

// 自定义用来测试的类
class Employee {
	public volatile int eid;	// 员工号
	private String sname;	// 员工姓名

	// 无参构造器
	public Employee() {

	}

	// 有参构造器
	protected Employee(int eid, String sname) {

	}

	// 静态方法
	public static Employee getInstance() {
		return null;
	}

	// 非静态方法
	private void sayHello() {

	}
}

// 主类
public class Sample18_5 {

	// 将修饰符整数代码转换为字符串表示的方法
	public static String fromCodeToString(int code) {
		StringBuffer result = new StringBuffer();

		// 判断修饰符中有无abstract
		if((code & Modifier.ABSTRACT) != 0)
			result.append(",abstract");

		// 判断修饰符中有无final
		if((code & Modifier.FINAL) != 0)
			result.append(",final");

		// 判断修饰符中有无final
		if((code & Modifier.INTERFACE) != 0)
			result.append(",interface");

		// 判断修饰符中有无final
		if((code & Modifier.NATIVE) != 0)
			result.append(",native");

		// 判断修饰符中有无final
		if((code & Modifier.PROTECTED) != 0)
			result.append(",protected");

		// 判断修饰符中有无final
		if((code & Modifier.PUBLIC) != 0)
			result.append(",public");

		// 判断修饰符中有无final
		if((code & Modifier.STATIC) != 0)
			result.append(",static");

		// 判断修饰符中有无final
		if((code & Modifier.STRICT) != 0)
			result.append(",strict");

		// 判断修饰符中有无final
		if((code & Modifier.SYNCHRONIZED) != 0)
			result.append(",synchronized");

		// 判断修饰符中有无final
		if((code & Modifier.TRANSIENT) != 0)
			result.append(",transient");

		// 判断修饰符中有无final
		if((code & Modifier.VOLATILE) != 0)
			result.append(",volatile");

		// 判断修饰符中有无final
		if(result.length() > 0)
			return result.substring(1);
		else
			return "";

	}

	// 主方法
	public static void main(String[] args) {
		try {
			// 获取Employee类对应的Class对象
			Class<?> ec = Employee.class;
			
			// 打印所有Employee类声明的构造器信息
			System.out.println("=========="
					+ "构造器信息"
					+ "==========");
			System.out.println("构造器名\t\t修饰符号");
			
			Constructor<?> ca[] = ec.getConstructors();
			int size = ca.length;
			for(int i = 0; i < size; i++) {
				// 打印构造器名
				System.out.print(ca[i].getName() + "\t\t");
				
				// 打印修饰符序列
				System.out.println(fromCodeToString(ca[i].getModifiers()));
			}
			
			// 打印所有Employee类声明的成员变量的信息
			System.out.println("=========="
					+ "成员变量信息"
					+ "==========");
			System.out.println("成员变量名\t\t修饰符号");
			
			Field fa[] = ec.getFields();
			size  = fa.length;
			for(int i = 0; i < size; i++) {
				// 打印成员变量名
				System.out.print(fa[i].getName() + "\t\t\t");
				
				// 打印修饰符序列
				System.out.println(fromCodeToString(fa[i].getModifiers()));
			}
			
			// 打印所有Employee类声明的方法信息
			System.out.println("=========="
					+ "方法信息"
					+ "==========");
			System.out.println("方法名\t\t修饰符号");
			
			Method ma[] = ec.getMethods();
			size = ma.length;
			for(int i = 0; i < size; i++) {
				// 打印方法名
				System.out.print(ma[i].getName() + "\t\t");
				
				// 打印修饰符序列
				System.out.println(fromCodeToString(ma[i].getModifiers()));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
