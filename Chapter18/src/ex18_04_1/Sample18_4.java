// �½�18.03.1            ���÷��似����ȷ�ж϶�������
package ex18_04_1;

// ����
class MyFather {
	
}

// ������ȷ�ж����͵���
class MyClass extends MyFather {
	
}

// ����
public class Sample18_4 {

	public static void main(String[] args) {
		try {
			// ����MyClass�����
			MyClass mc = new MyClass();
			
			// ��instanceof�ж�����
			System.out.println("instanceof���жϽ����");
			
			if(mc instanceof MyFather)
				System.out.println("������MyFather���͵ģ�����");
			else
				System.out.println("������MyFather���͵ģ�����");
			
			// ���÷��侫ȷ�ж�����
			System.out.println("������жϽ����");
			
			if(mc.getClass() == Class.forName("ex18_04_1.MyFather"))
				System.out.println("������MyFather���͵ģ�����");
			else
				System.out.println("������MyFather���͵ģ�����");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
