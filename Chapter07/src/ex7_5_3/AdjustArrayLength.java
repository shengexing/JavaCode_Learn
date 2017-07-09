//章节7.5.3              动态调整数组的长度
package ex7_5_3;

import java.util.Arrays;

public class AdjustArrayLength {

	private static int DEFAULT_LENGTH=10;
	
	public static Integer[] increase(Integer[] src) {
		return increase(src,DEFAULT_LENGTH);
	}
	
	public static Integer[] increase(Integer[] src,int length) {
		if(src==null) {
			return null;
		}
		
		//新建一个数组，长度为旧数组的长度加上length
		Integer[] result=new Integer[src.length+length];
		//新数组的前面部分的值与旧数组的值一样
		System.arraycopy(src, 0, result, 0, src.length);
		return result;
	}
	
	public static void print(Integer[] array) {
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] array=new Integer[10];
		for(int i=0;i<10;i++)
			array[i]=new Integer(i);
		System.out.println("调整前array数组的长度为："+array.length);
		System.out.print("调整前array数组的元素为：");
		AdjustArrayLength.print(array);
		
		array=AdjustArrayLength.increase(array);
		Arrays.fill(array, 10,20,10);  //添加数据
		System.out.println("调整后array数组的长度为："+array.length);
		System.out.print("调整后array数组的元素为：");
		AdjustArrayLength.print(array);
	}
}
