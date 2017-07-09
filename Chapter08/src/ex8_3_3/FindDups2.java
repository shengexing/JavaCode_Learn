//章节8.3.3              Set接口的批量操作
package ex8_3_3;

import java.util.HashSet;
import java.util.Set;

public class FindDups2 {

	public static void main(String[] args) {           //args的内容在运行配置的自变量中设置
		Set<String> uniques=new HashSet<String>();      //申明HashSet实例对象，使用泛型版本
		Set<String> dups=new HashSet<String>();      //申明HashSet实例对象，使用泛型版本
		for(String a:args)              //遍历命令行参数字符串数组
			if(!uniques.add(a))       //如果a已经存在
				dups.add(a);            //那么，将a添加到dups集合中
		
		//破坏性的集合差
		uniques.removeAll(dups);            //从uniques中移除所有具有重复的单词
		System.out.println("不重复的单词："+uniques);
		System.out.println("重复的单词："+dups);
		// TODO 自动生成的方法存根

	}

}
