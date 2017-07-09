//章节8.4.3_2              生成一个在参数列表中出现的单词的频度表。在频度表中，将每一个单词映射到它在参数列表中出现的次数
package ex8_5_2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Freq {

	public static void main(String[] args) {
		Map<String,Integer> m=new HashMap<String,Integer>();
		Map<String,Integer> n=new TreeMap<String,Integer>();
		Map<String,Integer> o=new LinkedHashMap<String,Integer>();
		//从命令行初始化频度表
		for(String a:args) {
			Integer freq=m.get(a);                      //获得键为a的元素的值
			m.put(a, (freq==null)? 1: freq+1);    //设置a出现的次数，保存在Map对象中
		}
		System.out.println(m.size()+"个不同的单词：");
		System.out.println(m);
		
		for(String a:args) {
			Integer freq=n.get(a);                      //获得键为a的元素的值
			n.put(a, (freq==null)? 1: freq+1);    //设置a出现的次数，保存在Map对象中
		}
		System.out.println(n.size()+"个不同的单词：");
		System.out.println(n);
		
		for(String a:args) {
			Integer freq=o.get(a);                      //获得键为a的元素的值
			o.put(a, (freq==null)? 1: freq+1);    //设置a出现的次数，保存在Map对象中
		}
		System.out.println(o.size()+"个不同的单词：");
		System.out.println(o);
		// TODO 自动生成的方法存根

	}

}
