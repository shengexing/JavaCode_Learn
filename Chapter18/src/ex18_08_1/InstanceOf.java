// �½�18.08.1            ʹ��instanceof������������
package ex18_08_1;

/**
 * instanceof ���ڼ����������
 * ��1����Ķ���������instanceof���������Ϊtrue
 * ��2����������븸����instanceof���������Ϊtrue
 * ��ˣ����ж�����Object��instanceof�����������Ϊtrue
 * ��3����������£������Ϊfalse
 */
public class InstanceOf {

	// ����
	static class ClassA {
		
	}
	
	// ����
	static class ClassB extends ClassA {
		
	}
	
	
	public static void main(String[] args) {
		ClassA a = new ClassA();
		ClassB b = new ClassB();
		
		// ������a, b�Ƿ�ΪClassA����
		if(a instanceof ClassA)
			System.out.println("Object a is a ClassA Object��");
		else
			System.out.println("Object a is not a ClassA Object��");
		
		if(b instanceof ClassA)
			System.out.println("Object b is a ClassA Object��");
		else
			System.out.println("Object b is not a ClassA Object��");
		
		// ������a, b�Ƿ�ΪClassB����
		if(a instanceof ClassB)
			System.out.println("Object a is a ClassB Object��");
		else
			System.out.println("Object a is not a ClassB Object��");
		
		if(b instanceof ClassB)
			System.out.println("Object b is a ClassB Object��");
		else
			System.out.println("Object b is not a ClassB Object��");
	}

}
