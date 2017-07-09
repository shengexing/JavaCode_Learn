//�½�7.5.3              ��̬��������ĳ���
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
		
		//�½�һ�����飬����Ϊ������ĳ��ȼ���length
		Integer[] result=new Integer[src.length+length];
		//�������ǰ�沿�ֵ�ֵ��������ֵһ��
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
		System.out.println("����ǰarray����ĳ���Ϊ��"+array.length);
		System.out.print("����ǰarray�����Ԫ��Ϊ��");
		AdjustArrayLength.print(array);
		
		array=AdjustArrayLength.increase(array);
		Arrays.fill(array, 10,20,10);  //�������
		System.out.println("������array����ĳ���Ϊ��"+array.length);
		System.out.print("������array�����Ԫ��Ϊ��");
		AdjustArrayLength.print(array);
	}
}
