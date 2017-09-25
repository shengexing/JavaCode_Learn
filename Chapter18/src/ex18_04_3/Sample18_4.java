// �½�18.04.3            ʹ��Constructor�������
package ex18_04_3;

import java.lang.reflect.Constructor;

// �Զ����������Ե���
class Student {
	String sname;	// ����
	int sage;	// ����
	
	// �����޲ι�����
	public Student() {
		sname = "Tom";
		sage = 23;
	}
	
	// �����вι�����
	public Student(String sname, int sage) {
		this.sname = sname;
		this.sage = sage;
	}
	
	// ����һ����ͨ����
	public void sayHello() {
		System.out.println("��ã�����" + sname + "������" + sage + "�꣡����");
	}
}

// ����
public class Sample18_4 {

	public static void main(String[] args) {
		try {
			// ��ȡStudent���Ӧ��Class����
			Class<?> sc = Student.class;
			
			// ��ȡ���Է��ʵĹ�������Ӧ��Constructor����
			Constructor<?>[] ca = sc.getConstructors();
			
			// ���������ɨ���ӡ��������Ϣ
			System.out.println("����������\t\t�����б�");
			
			int size = ca.length;
			
			for(int i = 0; i < size; i++) {
				Constructor<?> tempc = ca[i];
				
				// ��ӡ����������
				String cname = tempc.getName();
				System.out.print(cname + "\t\t");
				
				// ѭ����ӡ�������Ĳ�������
				Class<?>[] pa = tempc.getParameterTypes();
				int psize = pa.length;
				if(psize == 0)
					System.out.print("û�в���");
				for(int j = 0; j < psize; j++)
					System.out.print(pa[j].getName() + ((j == psize - 1) ? "" : "��"));
				// ����
				System.out.println();
			}
			
			// ʹ�÷�������޲ι�������������
			Student stu = (Student)ca[0].newInstance(new Object[0]);
			
			// ���ô��������sayHello����
			stu.sayHello();
			
			// ʹ�÷�������вι�������������
			stu = (Student)ca[1].newInstance(new Object[] {"��ǿ", new Integer(25)});
			
			// ���ô��������sayHello����
			stu.sayHello();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
