// �½�18.07.1            ��̬�������������
package ex18_07_1;

import java.lang.reflect.Array;

public class Sample18_7 {

	public static void main(String[] args) {
		try {
			// ʹ�÷���ķ�ʽ��̬����һάint������
			int[] intArray = (int[])Array.newInstance(Integer.TYPE, 5);
			
			// ʹ�÷���ķ�ʽ��̬������άString������
			String[][] stringArray = (String[][])Array.newInstance(String.class, new int[] {5, 4});
			
			// ��ӡ��������ĳ�����Ϣ
			System.out.println("intArray����Ϊ��" + intArray.length + "��");
			System.out.println("stringArray��һά����Ϊ��" + stringArray.length 
					+ "���ڶ� ά����Ϊ��" + stringArray[0].length);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
