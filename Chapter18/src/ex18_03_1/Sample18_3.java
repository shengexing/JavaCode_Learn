// 章节18.03.1            数组的Class类的简单使用
package ex18_03_1;

public class Sample18_3 {

	public static void main(String[] args) {
		// 创建数组对象
		String[] stringArray = new String[4];
		int[][] intArray = new int[9][9];
		
		// 获取数组对象对应的Class类
		Class sc = stringArray.getClass();
		Class ic = intArray.getClass();
		
		// 打印两个数组对应的类名
		System.out.println("一维String数组对应的类名为：" + sc.getName() + "。");
		System.out.println("一维int数组对应的类名为：" + ic.getName() + "。");
	}

}
