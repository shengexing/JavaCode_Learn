//章节8.3.2              Set接口的基本操作
package ex8_3_2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class FindDups {
	
	public static void print(Set<String> s,String[] str) {
		for(String a:str)         //遍历字符串数组
			if(!s.add(a))          //如果添加字符串a不成功，说明s中已经有了相同元素
				System.out.println("重复的元素："+a);
		System.out.println(s.size()+"个单独的单词："+s);
	}

	public static void main(String[] args) {         //args的内容在运行配置的自变量中设置
		Set<String> s0=new HashSet<String>();      //声明不能具有重复元素的HashSet对象
		Set<String> s1=new TreeSet<String>();       //声明不能具有重复元素的TreeSet对象
		Set<String> s2=new LinkedHashSet<String>();    //声明不能具有重复元素的LinkedHashSet对象
		System.out.println("使用HashSet的结果如下：");
		FindDups.print(s0, args);
		System.out.println("使用TreeSet的结果如下：");
		FindDups.print(s1, args);
		System.out.println("使用LinkedHashSet的结果如下：");
		FindDups.print(s2, args);
		// TODO 自动生成的方法存根

	}

}
