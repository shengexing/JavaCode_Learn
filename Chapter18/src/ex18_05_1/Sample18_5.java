// �½�18.05.1            ʹ��getModifiers()����������
package ex18_05_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

// �Զ����������Ե���
class Employee {
	public volatile int eid;	// Ա����
	private String sname;	// Ա������

	// �޲ι�����
	public Employee() {

	}

	// �вι�����
	protected Employee(int eid, String sname) {

	}

	// ��̬����
	public static Employee getInstance() {
		return null;
	}

	// �Ǿ�̬����
	private void sayHello() {

	}
}

// ����
public class Sample18_5 {

	// �����η���������ת��Ϊ�ַ�����ʾ�ķ���
	public static String fromCodeToString(int code) {
		StringBuffer result = new StringBuffer();

		// �ж����η�������abstract
		if((code & Modifier.ABSTRACT) != 0)
			result.append(",abstract");

		// �ж����η�������final
		if((code & Modifier.FINAL) != 0)
			result.append(",final");

		// �ж����η�������final
		if((code & Modifier.INTERFACE) != 0)
			result.append(",interface");

		// �ж����η�������final
		if((code & Modifier.NATIVE) != 0)
			result.append(",native");

		// �ж����η�������final
		if((code & Modifier.PROTECTED) != 0)
			result.append(",protected");

		// �ж����η�������final
		if((code & Modifier.PUBLIC) != 0)
			result.append(",public");

		// �ж����η�������final
		if((code & Modifier.STATIC) != 0)
			result.append(",static");

		// �ж����η�������final
		if((code & Modifier.STRICT) != 0)
			result.append(",strict");

		// �ж����η�������final
		if((code & Modifier.SYNCHRONIZED) != 0)
			result.append(",synchronized");

		// �ж����η�������final
		if((code & Modifier.TRANSIENT) != 0)
			result.append(",transient");

		// �ж����η�������final
		if((code & Modifier.VOLATILE) != 0)
			result.append(",volatile");

		// �ж����η�������final
		if(result.length() > 0)
			return result.substring(1);
		else
			return "";

	}

	// ������
	public static void main(String[] args) {
		try {
			// ��ȡEmployee���Ӧ��Class����
			Class<?> ec = Employee.class;
			
			// ��ӡ����Employee�������Ĺ�������Ϣ
			System.out.println("=========="
					+ "��������Ϣ"
					+ "==========");
			System.out.println("��������\t\t���η���");
			
			Constructor<?> ca[] = ec.getConstructors();
			int size = ca.length;
			for(int i = 0; i < size; i++) {
				// ��ӡ��������
				System.out.print(ca[i].getName() + "\t\t");
				
				// ��ӡ���η�����
				System.out.println(fromCodeToString(ca[i].getModifiers()));
			}
			
			// ��ӡ����Employee�������ĳ�Ա��������Ϣ
			System.out.println("=========="
					+ "��Ա������Ϣ"
					+ "==========");
			System.out.println("��Ա������\t\t���η���");
			
			Field fa[] = ec.getFields();
			size  = fa.length;
			for(int i = 0; i < size; i++) {
				// ��ӡ��Ա������
				System.out.print(fa[i].getName() + "\t\t\t");
				
				// ��ӡ���η�����
				System.out.println(fromCodeToString(fa[i].getModifiers()));
			}
			
			// ��ӡ����Employee�������ķ�����Ϣ
			System.out.println("=========="
					+ "������Ϣ"
					+ "==========");
			System.out.println("������\t\t���η���");
			
			Method ma[] = ec.getMethods();
			size = ma.length;
			for(int i = 0; i < size; i++) {
				// ��ӡ������
				System.out.print(ma[i].getName() + "\t\t");
				
				// ��ӡ���η�����
				System.out.println(fromCodeToString(ma[i].getModifiers()));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
