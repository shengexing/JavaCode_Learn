//�½�8.3.2              Set�ӿڵĻ�������
package ex8_3_2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class FindDups {
	
	public static void print(Set<String> s,String[] str) {
		for(String a:str)         //�����ַ�������
			if(!s.add(a))          //�������ַ���a���ɹ���˵��s���Ѿ�������ͬԪ��
				System.out.println("�ظ���Ԫ�أ�"+a);
		System.out.println(s.size()+"�������ĵ��ʣ�"+s);
	}

	public static void main(String[] args) {         //args���������������õ��Ա���������
		Set<String> s0=new HashSet<String>();      //�������ܾ����ظ�Ԫ�ص�HashSet����
		Set<String> s1=new TreeSet<String>();       //�������ܾ����ظ�Ԫ�ص�TreeSet����
		Set<String> s2=new LinkedHashSet<String>();    //�������ܾ����ظ�Ԫ�ص�LinkedHashSet����
		System.out.println("ʹ��HashSet�Ľ�����£�");
		FindDups.print(s0, args);
		System.out.println("ʹ��TreeSet�Ľ�����£�");
		FindDups.print(s1, args);
		System.out.println("ʹ��LinkedHashSet�Ľ�����£�");
		FindDups.print(s2, args);
		// TODO �Զ����ɵķ������

	}

}
