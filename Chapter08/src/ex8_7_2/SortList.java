//章节8.7.2_2                 类ex8_7_2.MyIntComparator定义了一个比较器，类ex8_7_2.SortList将展示如何用Collections和
//                               Comparator对List中的元素进行排序
package ex8_7_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**对List中的元素排序*/
public class SortList {
	
	public static void output(List list) {
		if(list==null)
			return;
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i).toString()+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		List list=new ArrayList();
		list.add(new Integer(5));
		list.add(new Integer(8));
		list.add(new Integer(1));
		list.add(new Integer(3));
		list.add(new Integer(2));
		System.out.println("list开始状态");
		SortList.output(list);
		//Collections.sort方法将用默认比较器排列list的元素
		Collections.sort(list);
		System.out.println("list被默认比较器排序后的状态");
		SortList.output(list);
		//下面将list的元素按降序排列
		Collections.sort(list,new MyIntComparator());
		System.out.println("list被自定义比较器排序后的状态");
		SortList.output(list);
		// TODO 自动生成的方法存根

	}

}
