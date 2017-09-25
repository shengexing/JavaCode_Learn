// �½�18.04.1            ʹ��Method�������
package ex18_04_2;

import java.lang.reflect.Method;

// �Զ����������Ե���
class ForMethod {
	// ������̬����sayHello������Ϊ����Ļ�ϴ�ӡ�ַ���
	public static void sayHello(String name) {
		System.out.println("��ã�" + name + "������");
	}
	
	// �����Ǿ�̬����generateNum������Ϊ����min��max֮��������
	public String genrateNum(int max, int min) {
		return ((int)(Math.random()*(max - min) + min)) + "";
	}
}

// ����
public class Sample18_4 {

	public static void main(String[] args) {
		try {
			// ����ForMethod�����
			ForMethod fm = new ForMethod();
			
			// ��ȡForMethod���Ӧ��Class����
			Class<?> fmc = fm.getClass();
			
			// ��ȡ���Է��ʵķ�����Ӧ��Method����
			Method[] ma = fmc.getMethods();
			
			// ���������ɨ���ӡ��������Ϣ
			System.out.println("��������\t����ֵ����\t\t�����б�");
			
			int size = ma.length;
			
			for(int i = 0; i < size; i++) {
				Method tempm = ma[i];
				
				// ��ӡ��������
				String mname = tempm.getName();
				System.out.print(mname + ((mname.length() > 7) ? "\t" : "\t\t"));
				
				// ��ӡ�����ķ���ֵ����
				String mReturnType = tempm.getReturnType().getName();
				System.out.print(mReturnType + ((mReturnType.length() > 15) ? "\t" : 
					(mReturnType.length() > 10) ? "\t\t" : "\t\t\t"));
				
				// ѭ����ӡ�����Ĳ�������
				Class<?>[] ca = tempm.getParameterTypes();
				
				int csize = ca.length;
				
				if(csize == 0)
					System.out.print("û�в���");
				for(int j = 0; j < csize; j++)
					System.out.print(ca[j].getName() + ((j == csize - 1) ? "" : "��"));
				
				// ����
				System.out.println();
			}
			
			// ͨ��������þ�̬����sayHello
			System.out.println("=========="
					+ "ͨ��������þ�̬����sayHello"
					+ "==========");
			ma[0].invoke(null, new Object[] {"��ǿ"});
			
			// ͨ��������÷Ǿ�̬����generateNum
			System.out.println("=========="
					+ "ͨ��������÷Ǿ�̬����generateNum"
					+ "==========");
			System.out.println(ma[1].invoke(fm, new Object[] {new Integer(100), new Integer(1000)}));
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
