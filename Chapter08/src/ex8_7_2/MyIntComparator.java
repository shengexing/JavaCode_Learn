//�½�8.7.2_1                 ��ex8_7_2.MyIntComparator������һ���Ƚ�������ex8_7_2.SortList��չʾ�����Collections��
//                               Comparator��List�е�Ԫ�ؽ�������
package ex8_7_2;

import java.util.Comparator;

/**�����Ƚ���������������������**/
public class MyIntComparator implements Comparator{

	/*o1��o2�󣬷���-1��o1��o2С������1��*/
	public int compare(Object o1,Object o2) {
		int i1=((Integer)o1).intValue();
		int i2=((Integer)o2).intValue();
		if(i1<i2) return 1;
		if(i1>i2) return -1;
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
