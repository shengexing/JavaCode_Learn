// �½�18.04.1            ʹ��Field�������
package ex18_04_1;

import java.lang.reflect.Field;

// �Զ����������Ե���
class Student {
	public int sage;	// ����
	private int sno; // ѧ��
	public boolean gender; // �Ա�true-�� false-Ů
	public String sname; // ����
	
	// �޲ι�����
	public Student() {
		
	}
	
	// ���ι�����
	public Student(int sage, int sno, boolean gender, String sname) {
		this.sage = sage;
		this.sno = sno;
		this.gender = gender;
		this.sname = sname;
	}
}

// ����
public class Sample18_4_1 {

	public static void main(String[] args) {
		try {
			// ����Student����
			Student tom = new Student(21, 10001, true, "Tom");
			
			// ��ȡStudent���Ӧ��Class����
			Class<?> dc = tom.getClass();
			
			// ��ȡStudent�����п��Է��ʵĳ�Ա������Ӧ��Field����
			Field[] filedArray = dc.getFields();
			
			// ��ӡStudent��������Ա��������ϸ��Ϣ
			System.out.println("��Ա������\t��Ա��������\t\t��Ա����ֵ");
			
			int size = filedArray.length;
			
			// ѭ������Field����
			for(int i =0; i < size; i++) {
				Field tempf = filedArray[i];
				
				// ��ӡ��Ա��������
				System.out.print(tempf.getName() + "\t\t");
				
				// ��ӡ��Ա��������
				System.out.print(tempf.getType().toString() 
						+ ((tempf.getType().toString().length() > 7) ? "\t" : "\t\t\t"));
				
				// ��ӡ��Ա����ֵ
				System.out.println(tempf.get(tom));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
