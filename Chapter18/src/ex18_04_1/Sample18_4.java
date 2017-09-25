// 章节18.03.1            利用反射技术精确判断对象类型
package ex18_04_1;

// 父类
class MyFather {
	
}

// 用来精确判断类型的类
class MyClass extends MyFather {
	
}

// 主类
public class Sample18_4 {

	public static void main(String[] args) {
		try {
			// 创建MyClass类对象
			MyClass mc = new MyClass();
			
			// 用instanceof判断类型
			System.out.println("instanceof的判断结果：");
			
			if(mc instanceof MyFather)
				System.out.println("对象是MyFather类型的！！！");
			else
				System.out.println("对象不是MyFather类型的！！！");
			
			// 利用反射精确判断类型
			System.out.println("反射的判断结果：");
			
			if(mc.getClass() == Class.forName("ex18_04_1.MyFather"))
				System.out.println("对象是MyFather类型的！！！");
			else
				System.out.println("对象不是MyFather类型的！！！");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
