//�½�8.4.3_2              ����һ���ڲ����б��г��ֵĵ��ʵ�Ƶ�ȱ���Ƶ�ȱ��У���ÿһ������ӳ�䵽���ڲ����б��г��ֵĴ���
package ex8_5_2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Freq {

	public static void main(String[] args) {
		Map<String,Integer> m=new HashMap<String,Integer>();
		Map<String,Integer> n=new TreeMap<String,Integer>();
		Map<String,Integer> o=new LinkedHashMap<String,Integer>();
		//�������г�ʼ��Ƶ�ȱ�
		for(String a:args) {
			Integer freq=m.get(a);                      //��ü�Ϊa��Ԫ�ص�ֵ
			m.put(a, (freq==null)? 1: freq+1);    //����a���ֵĴ�����������Map������
		}
		System.out.println(m.size()+"����ͬ�ĵ��ʣ�");
		System.out.println(m);
		
		for(String a:args) {
			Integer freq=n.get(a);                      //��ü�Ϊa��Ԫ�ص�ֵ
			n.put(a, (freq==null)? 1: freq+1);    //����a���ֵĴ�����������Map������
		}
		System.out.println(n.size()+"����ͬ�ĵ��ʣ�");
		System.out.println(n);
		
		for(String a:args) {
			Integer freq=o.get(a);                      //��ü�Ϊa��Ԫ�ص�ֵ
			o.put(a, (freq==null)? 1: freq+1);    //����a���ֵĴ�����������Map������
		}
		System.out.println(o.size()+"����ͬ�ĵ��ʣ�");
		System.out.println(o);
		// TODO �Զ����ɵķ������

	}

}
