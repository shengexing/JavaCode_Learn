//�½�8.4.3_2                   ArrayList��Vector��LinkedList��ʹ��
package ex8_7_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;

public class TestList {
	
	/*��ʼ��һ��List*/
	public static void init(List list) {
		if(list!=null) {
			list.add("aaa");
			list.add("ccc");
			list.add("bbb");
			list.add("eee");
			list.add("ddd");
		}
	}
	
	/*���List������*/
	public static void output(List list) {
		if(list!=null) {
			//�����б��±������ʹ��list.size()��ȡ�б���Ԫ�صĸ���
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+" ");
			}
			//�����õ���������
			Iterator it=list.iterator();
			Object value=null;
			while(it.hasNext()) {
				value=it.next();
				//System.out.println(value);
			}
		}
		System.out.println();
	}

	/*ʹ��ArrayList*/
	public static void testArrayList() {
		List list=new ArrayList();
		init(list);
		System.out.println("ʹ��ArrayList��");
		output(list);
	}
	
	/*ʹ��Vector*/
	public static void testVector() {
		List list=new Vector();
		init(list);
		System.out.println("ʹ��Vector��");
		output(list);
	}
	
	/*ʹ��LinkedList*/
	public static void testLinkedList() {
		List list=new LinkedList();
		init(list);
		System.out.println("ʹ��LinkedList��");
		output(list);
	}
	
	
	public static void main(String[] args) {
		TestList.testArrayList();
		TestList.testVector();
		TestList.testLinkedList();
		
		List list=new ArrayList();
		init(list);
		//List֧��Ԫ���ظ�
		list.add("aaa");
		list.add("bbb");
		System.out.println("����Ԫ��aaa,bbb��");
		output(list);
		
		//ָ��Ԫ�ز���λ��
		list.add(1,"fff");
		System.out.println("���±�1������fff��");
		output(list);
		
		List list2=new ArrayList();
		list2.add("ggg");
		list2.add("hhh");
		//����һ�б��е�Ԫ�ز��뵽�б���
		list.addAll(list2);
		System.out.println("���list2��Ԫ�غ�");
		output(list);
		
		//�ж��б��Ƿ����ĳһԪ��
		//ͨ��Ԫ�ص�equals�������ж�Ԫ���Ƿ����
		System.out.println("list����aaa��"+list.contains("aaa"));
		//�ж��б����Ƿ��������һ���б��е�����Ԫ��
		System.out.println("list����list2�е�����Ԫ�أ�"+list.containsAll(list2));
		//��λһ��Ԫ�����б������ȳ��ֵ�λ��
		System.out.println("aaa��list�е�һ�γ��ֵ�λ�ã�"+list.indexOf("aaa"));
		//��λһ��Ԫ�����б��������ֵ�λ��
		System.out.println("aaa��list�����һ�γ��ֵ�λ�ã�"+list.lastIndexOf("aaa"));
		
		//�����б���ĳ��λ�õ�Ԫ��ֵ
		list.set(2, "xxx");
		System.out.println("����λ��Ϊ2��Ԫ��Ϊxxx��");
		output(list);
		//ɾ���б��е�ĳ��Ԫ�أ�ֻɾ����һ�γ��ֵ��Ǹ�
		list.remove("aaa");
		System.out.println("ɾ��Ԫ��aaa��");
		output(list);
		//ɾ���б���ָ��λ�õ�Ԫ��
		list.remove(1);
		System.out.println("ɾ���±�Ϊ1��Ԫ�غ�");
		output(list);
		//ɾ���б��е�����Ԫ�أ�ֻ������һ���б��а�����Ԫ��
		list.retainAll(list2);
		System.out.println("ɾ����list2�����������Ԫ�غ�");
		output(list);
		//ɾ���б�������һ�б���Ҳ�����˵�Ԫ��
		list.removeAll(list2);
		System.out.println("ɾ��list2������Ԫ�غ�");
		output(list);
		
		list.clear();          //����б�
		//�ж��б����Ƿ�������
		System.out.println("���list��listΪ����"+list.isEmpty());
		init(list);
		//���б��е�ĳ��Ԫ�ع���һ���µ��б�
		list2=list.subList(1, 3);
		System.out.println("��list�ĵ�1������3��Ԫ�ع���һ���µ�List��");
		output(list2);
		
		//��List���еı�����ListIterator�����б�
		//����ͨ��Iterator��ͬ��������������������б�
		ListIterator listIt=list.listIterator();
		System.out.println("��������б�");
		while(listIt.hasNext())
			System.out.print(listIt.next()+" ");
		System.out.println();
		System.out.println("��������б�");
		while(listIt.hasPrevious())
			System.out.print(listIt.previous()+" ");
		System.out.println();
		//Ҳ����ʹ��ListIterator��List�м�����ɾ��Ԫ��
		//ֻ���ڱ�������ǰλ����Ӻ�ɾ��
		listIt.add("newadd");
		System.out.println("��ListIterator���б������Ԫ��newadd��");
		output(list);
		listIt.next();
		listIt.remove();
		System.out.println("��ListIteratorɾ���б���Ԫ�غ�");
		output(list);
		
		//LinkedList�Զ���ķ���
		LinkedList linklist=new LinkedList();
		init(linklist);
		//���Ԫ�ص��б�ͷ
		linklist.addFirst("fff");
		System.out.println("��fff�ŵ��б�ͷ��");
		output(linklist);
		//���Ԫ�ص��б�β
		linklist.addLast("eee");
		System.out.println("��eee�ŵ��б�β��");
		output(linklist);
		
		System.out.println("�б�ͷԪ�أ�"+linklist.getFirst());      //��ȡ��ͷԪ��
		System.out.println("�б�βԪ�أ�"+linklist.getLast());      //��ȡ��βԪ��
		linklist.removeFirst();           //ɾ���б�ͷ��Ԫ��
		System.out.println("ɾ���б�ͷԪ�غ�");
		output(linklist);
		linklist.removeLast();           //ɾ���б�β��Ԫ��
		System.out.println("ɾ���б�βԪ�غ�");
		output(linklist);
		
		Stack myStack=new Stack();          //��ջStack�࣬���̳���Stack��
		//����Ԫ�أ��ǲ��뵽β��
		myStack.push("aaa");
		myStack.push("bbb");
		myStack.push("ccc");
		myStack.push("ddd");
		myStack.push("aaa");
		myStack.push("ddd");
		System.out.println("��ջ�е�Ԫ���ǣ�");
		output(myStack);
		System.out.println("��ջβ��Ԫ�أ�"+myStack.peek());
		System.out.println("������ջβ��Ԫ�أ�"+myStack.pop());
		

	}

}
