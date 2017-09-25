//�½�8.7.3            ��Map�е�Ԫ�ؽ�������
package ex8_7_3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import ex8_7_2.MyIntComparator;

public class SortMap {
	
	public static void output(Map map) {
		if(map==null)
			return;
		Iterator it=map.keySet().iterator();
		while(it.hasNext()) {
			Object in=it.next();
			System.out.println("key��"+in+"��value��"+map.get(in));
		}
	}

	public static void main(String[] args) {
		Map myMap=new HashMap();
		myMap.put(new Integer(5), "aaa");
		myMap.put(new Integer(8), "bbb");
		myMap.put(new Integer(4), "ccc");
		myMap.put(new Integer(7), "ddd");
		myMap.put(new Integer(3), "eee");
		System.out.println("��ʼ�����myMap��");
		SortMap.output(myMap);
		
		//����TreeMap�������ܽ�myMap����
		Map treeMap=new TreeMap(myMap);
		System.out.println("������myMap��");
		SortMap.output((treeMap));
		//�����Զ���ıȽ�������
		TreeMap newTreeMap=new TreeMap(new MyIntComparator());
		newTreeMap.putAll(myMap);          //��һ��Map�����ݷ��ڱ�Map��
		System.out.println("ʹ���Զ���Ƚ���������myMap��");
		SortMap.output(newTreeMap);
		// TODO �Զ����ɵķ������

	}
 
}
