//�½�8.4.3_1              ʹ��shuffle()�㷨��������������б��еĵ���
package ex8_4_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleDemo1 {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();           //����һ����̬�������
		for(String a:args)                  //ѭ�����������в����е�ÿһ��Ԫ��
			list.add(a);               //��Ԫ����ӵ�������
		Collections.shuffle(list,new Random());       //ʹ��Collections���shuffle������List�������
		System.out.println(list);
		// TODO �Զ����ɵķ������

	}

}
