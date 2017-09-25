// 章节18.04.1            使用Field类的例子
package ex18_04_1;

import java.lang.reflect.Field;

// 自定义用来测试的类
class Student {
	public int sage;	// 年龄
	private int sno; // 学号
	public boolean gender; // 性别：true-男 false-女
	public String sname; // 姓名
	
	// 无参构造器
	public Student() {
		
	}
	
	// 含参构造器
	public Student(int sage, int sno, boolean gender, String sname) {
		this.sage = sage;
		this.sno = sno;
		this.gender = gender;
		this.sname = sname;
	}
}

// 主类
public class Sample18_4_1 {

	public static void main(String[] args) {
		try {
			// 创建Student对象
			Student tom = new Student(21, 10001, true, "Tom");
			
			// 获取Student类对应的Class对象
			Class<?> dc = tom.getClass();
			
			// 获取Student类所有可以访问的成员变量对应的Field数组
			Field[] filedArray = dc.getFields();
			
			// 打印Student类对象各成员变量的详细信息
			System.out.println("成员变量名\t成员变量类型\t\t成员变量值");
			
			int size = filedArray.length;
			
			// 循环处理Field数组
			for(int i =0; i < size; i++) {
				Field tempf = filedArray[i];
				
				// 打印成员变量名称
				System.out.print(tempf.getName() + "\t\t");
				
				// 打印成员变量类型
				System.out.print(tempf.getType().toString() 
						+ ((tempf.getType().toString().length() > 7) ? "\t" : "\t\t\t"));
				
				// 打印成员变量值
				System.out.println(tempf.get(tom));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
