// 章节18.07.1            动态创建数组的例子
package ex18_07_1;

import java.lang.reflect.Array;

public class Sample18_7 {

	public static void main(String[] args) {
		try {
			// 使用反射的方式动态创建一维int型数组
			int[] intArray = (int[])Array.newInstance(Integer.TYPE, 5);
			
			// 使用反射的方式动态创建二维String型数组
			String[][] stringArray = (String[][])Array.newInstance(String.class, new int[] {5, 4});
			
			// 打印两个数组的长度信息
			System.out.println("intArray长度为：" + intArray.length + "。");
			System.out.println("stringArray第一维长度为：" + stringArray.length 
					+ "，第二 维长度为：" + stringArray[0].length);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
