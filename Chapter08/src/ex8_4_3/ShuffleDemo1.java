//章节8.4.3_1              使用shuffle()算法随机地输出其参数列表中的单词
package ex8_4_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleDemo1 {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();           //创建一个动态数组对象
		for(String a:args)                  //循环遍历命令行参数中的每一个元素
			list.add(a);               //将元素添加到序列中
		Collections.shuffle(list,new Random());       //使用Collections类的shuffle方法对List随机排序
		System.out.println(list);
		// TODO 自动生成的方法存根

	}

}
