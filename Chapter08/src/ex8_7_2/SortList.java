//�½�8.7.2_2                 ��ex8_7_2.MyIntComparator������һ���Ƚ�������ex8_7_2.SortList��չʾ�����Collections��
//                               Comparator��List�е�Ԫ�ؽ�������
package ex8_7_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**��List�е�Ԫ������*/
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
		System.out.println("list��ʼ״̬");
		SortList.output(list);
		//Collections.sort��������Ĭ�ϱȽ�������list��Ԫ��
		Collections.sort(list);
		System.out.println("list��Ĭ�ϱȽ���������״̬");
		SortList.output(list);
		//���潫list��Ԫ�ذ���������
		Collections.sort(list,new MyIntComparator());
		System.out.println("list���Զ���Ƚ���������״̬");
		SortList.output(list);
		// TODO �Զ����ɵķ������

	}

}
