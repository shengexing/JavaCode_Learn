//�½�8.4.3_2              ʹ��Arrays.asList()������shuffle()������������������б��еĵ���
package ex8_4_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleDemo2 {

	public static void main(String[] args) {
		List<String> list=Arrays.asList(args);              //����һ����̬�������
		Collections.shuffle(list);                //ʹ��Collections���shuffle������List�������
		System.out.println(list);
		// TODO �Զ����ɵķ������

	}

}
