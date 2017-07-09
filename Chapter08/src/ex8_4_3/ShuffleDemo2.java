//章节8.4.3_2              使用Arrays.asList()并调用shuffle()方法随机地输出其参数列表中的单词
package ex8_4_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleDemo2 {

	public static void main(String[] args) {
		List<String> list=Arrays.asList(args);              //创建一个动态数组对象
		Collections.shuffle(list);                //使用Collections类的shuffle方法对List随机排序
		System.out.println(list);
		// TODO 自动生成的方法存根

	}

}
