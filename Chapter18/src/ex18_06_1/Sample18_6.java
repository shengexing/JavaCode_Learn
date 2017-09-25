// �½�18.06.1            ����AccessibleObject�еķ���ȥ���������Ƶ�����
package ex18_06_1;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// �Զ����������Ե���
class Employee {
	private String sname;	// Ա������
	
	// ˽�з���
	private void sayHello() {
		System.out.println("��ã�����" + sname 
				+ "����ϲ��ɹ�������private�ķ���sayHello������");
	}
}

// ����
public class Sample18_6 {

	public static void main(String[] args) {
		try {
			// ����Employee����
			Employee tom = new Employee();
			
			// ��ȡEmployee���Ӧ��Class����
			Class<?> ec = tom.getClass();
			
			// ��ȡEmployee�������ĳ�Ա������Ӧ��Field����
			Field[] fa = ec.getDeclaredFields();
			
			// ����sname��Ա�����ķ�������Ϊ����
			fa[0].setAccessible(true);
			
			// ����sname��Ա������ֵ
			fa[0].set(tom, "Tom");
			
			// ��ȡEmployee�������ķ�����Ӧ��Method����
			Method[] ma = ec.getDeclaredMethods();
			
			// �������з����ķ�������Ϊ����
			AccessibleObject.setAccessible(ma, true);
			
			// ����sayHello����
			ma[0].invoke(tom, new Object[0]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
