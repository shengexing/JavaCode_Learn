//章节8.7.2_1                 类ex8_7_2.MyIntComparator定义了一个比较器，类ex8_7_2.SortList将展示如何用Collections和
//                               Comparator对List中的元素进行排序
package ex8_7_2;

import java.util.Comparator;

/**整数比较器，将整数按降序排列**/
public class MyIntComparator implements Comparator{

	/*o1比o2大，返回-1；o1比o2小，返回1。*/
	public int compare(Object o1,Object o2) {
		int i1=((Integer)o1).intValue();
		int i2=((Integer)o2).intValue();
		if(i1<i2) return 1;
		if(i1>i2) return -1;
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
