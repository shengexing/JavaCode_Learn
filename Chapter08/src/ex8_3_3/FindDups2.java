//�½�8.3.3              Set�ӿڵ���������
package ex8_3_3;

import java.util.HashSet;
import java.util.Set;

public class FindDups2 {

	public static void main(String[] args) {           //args���������������õ��Ա���������
		Set<String> uniques=new HashSet<String>();      //����HashSetʵ������ʹ�÷��Ͱ汾
		Set<String> dups=new HashSet<String>();      //����HashSetʵ������ʹ�÷��Ͱ汾
		for(String a:args)              //���������в����ַ�������
			if(!uniques.add(a))       //���a�Ѿ�����
				dups.add(a);            //��ô����a��ӵ�dups������
		
		//�ƻ��Եļ��ϲ�
		uniques.removeAll(dups);            //��uniques���Ƴ����о����ظ��ĵ���
		System.out.println("���ظ��ĵ��ʣ�"+uniques);
		System.out.println("�ظ��ĵ��ʣ�"+dups);
		// TODO �Զ����ɵķ������

	}

}
