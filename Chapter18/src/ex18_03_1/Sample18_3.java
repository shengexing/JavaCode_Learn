// �½�18.03.1            �����Class��ļ�ʹ��
package ex18_03_1;

public class Sample18_3 {

	public static void main(String[] args) {
		// �����������
		String[] stringArray = new String[4];
		int[][] intArray = new int[9][9];
		
		// ��ȡ��������Ӧ��Class��
		Class sc = stringArray.getClass();
		Class ic = intArray.getClass();
		
		// ��ӡ���������Ӧ������
		System.out.println("һάString�����Ӧ������Ϊ��" + sc.getName() + "��");
		System.out.println("һάint�����Ӧ������Ϊ��" + ic.getName() + "��");
	}

}
