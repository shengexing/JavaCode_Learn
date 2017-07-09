//章节8.4.3_2                   ArrayList、Vector和LinkedList的使用
package ex8_7_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;

public class TestList {
	
	/*初始化一个List*/
	public static void init(List list) {
		if(list!=null) {
			list.add("aaa");
			list.add("ccc");
			list.add("bbb");
			list.add("eee");
			list.add("ddd");
		}
	}
	
	/*输出List的内容*/
	public static void output(List list) {
		if(list!=null) {
			//根据列表下标遍历，使用list.size()获取列表中元素的个数
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+" ");
			}
			//或者用迭代器遍历
			Iterator it=list.iterator();
			Object value=null;
			while(it.hasNext()) {
				value=it.next();
				//System.out.println(value);
			}
		}
		System.out.println();
	}

	/*使用ArrayList*/
	public static void testArrayList() {
		List list=new ArrayList();
		init(list);
		System.out.println("使用ArrayList：");
		output(list);
	}
	
	/*使用Vector*/
	public static void testVector() {
		List list=new Vector();
		init(list);
		System.out.println("使用Vector：");
		output(list);
	}
	
	/*使用LinkedList*/
	public static void testLinkedList() {
		List list=new LinkedList();
		init(list);
		System.out.println("使用LinkedList：");
		output(list);
	}
	
	
	public static void main(String[] args) {
		TestList.testArrayList();
		TestList.testVector();
		TestList.testLinkedList();
		
		List list=new ArrayList();
		init(list);
		//List支持元素重复
		list.add("aaa");
		list.add("bbb");
		System.out.println("插入元素aaa,bbb后：");
		output(list);
		
		//指定元素插入位置
		list.add(1,"fff");
		System.out.println("在下标1处插入fff后：");
		output(list);
		
		List list2=new ArrayList();
		list2.add("ggg");
		list2.add("hhh");
		//将另一列表中的元素插入到列表中
		list.addAll(list2);
		System.out.println("添加list2的元素后：");
		output(list);
		
		//判断列表是否包含某一元素
		//通过元素的equals方法，判断元素是否相等
		System.out.println("list包含aaa？"+list.contains("aaa"));
		//判断列表中是否包含了另一个列表中的所有元素
		System.out.println("list包含list2中的所有元素？"+list.containsAll(list2));
		//定位一个元素在列表中最先出现的位置
		System.out.println("aaa在list中第一次出现的位置："+list.indexOf("aaa"));
		//定位一个元素在列表中最后出现的位置
		System.out.println("aaa在list中最后一次出现的位置："+list.lastIndexOf("aaa"));
		
		//更新列表中某个位置的元素值
		list.set(2, "xxx");
		System.out.println("更新位置为2的元素为xxx后：");
		output(list);
		//删除列表中的某个元素，只删除第一次出现的那个
		list.remove("aaa");
		System.out.println("删除元素aaa后：");
		output(list);
		//删除列表中指定位置的元素
		list.remove(1);
		System.out.println("删除下标为1的元素后：");
		output(list);
		//删除列表中的其他元素，只保留另一个列表中包含的元素
		list.retainAll(list2);
		System.out.println("删除除list2包含的以外的元素后：");
		output(list);
		//删除列表中在另一列表中也包含了的元素
		list.removeAll(list2);
		System.out.println("删除list2包含的元素后：");
		output(list);
		
		list.clear();          //清空列表
		//判断列表中是否有数据
		System.out.println("清空list后，list为空吗？"+list.isEmpty());
		init(list);
		//用列表中的某个元素构成一个新的列表
		list2=list.subList(1, 3);
		System.out.println("用list的第1个到第3个元素构造一个新的List：");
		output(list2);
		
		//用List特有的遍历器ListIterator遍历列表
		//与普通的Iterator不同，它允许两个方向遍历列表
		ListIterator listIt=list.listIterator();
		System.out.println("正向遍历列表");
		while(listIt.hasNext())
			System.out.print(listIt.next()+" ");
		System.out.println();
		System.out.println("反向遍历列表");
		while(listIt.hasPrevious())
			System.out.print(listIt.previous()+" ");
		System.out.println();
		//也可以使用ListIterator从List中间插入和删除元素
		//只能在遍历器当前位置添加和删除
		listIt.add("newadd");
		System.out.println("用ListIterator往列表中添加元素newadd后：");
		output(list);
		listIt.next();
		listIt.remove();
		System.out.println("用ListIterator删除列表中元素后：");
		output(list);
		
		//LinkedList自定义的方法
		LinkedList linklist=new LinkedList();
		init(linklist);
		//添加元素到列表头
		linklist.addFirst("fff");
		System.out.println("把fff放到列表头后：");
		output(linklist);
		//添加元素到列表尾
		linklist.addLast("eee");
		System.out.println("把eee放到列表尾后：");
		output(linklist);
		
		System.out.println("列表头元素："+linklist.getFirst());      //获取表头元素
		System.out.println("列表尾元素："+linklist.getLast());      //获取表尾元素
		linklist.removeFirst();           //删除列表头的元素
		System.out.println("删除列表头元素后：");
		output(linklist);
		linklist.removeLast();           //删除列表尾的元素
		System.out.println("删除列表尾元素后：");
		output(linklist);
		
		Stack myStack=new Stack();          //堆栈Stack类，它继承自Stack类
		//插入元素，是插入到尾部
		myStack.push("aaa");
		myStack.push("bbb");
		myStack.push("ccc");
		myStack.push("ddd");
		myStack.push("aaa");
		myStack.push("ddd");
		System.out.println("堆栈中的元素是：");
		output(myStack);
		System.out.println("堆栈尾部元素："+myStack.peek());
		System.out.println("弹出堆栈尾部元素："+myStack.pop());
		

	}

}
