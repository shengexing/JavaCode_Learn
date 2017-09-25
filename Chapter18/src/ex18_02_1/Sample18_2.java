// �½�18.02.1            Class��ļ�ʹ��
package ex18_02_1;

// ������������ĸ���
class MyFather {
	// ����Ĺ�����Ա����
	public int memberFather;
	
	// ����Ĺ�������
	public void methodFather() {
		System.out.println("���ǴӸ���̳ж����ķ���methodFather������");
	}
}

// ���������ص���
class MySon extends MyFather {
	// ����Ĺ�����Ա����
	public int memberSonPublic;
	
	// �����˽�г�Ա����
	private int memberSonPrivate;
	
	// ����Ĺ�������
	public void methodSonPublic() {
		System.out.println("���������Լ��ķ���methodSonPublic������");
	}
	
	// ����ı�������
	protected void methodSonProtected() {
		System.out.println("���������Լ��ķ���methodSonProtected������");
	}
}

// ����
public class Sample18_2 {

	public static void main(String[] args) {
		try {
			/*// ����ָ������
			Class<?> c = Class.forName("ex18_02_1.MySon");
			
			// ����������Ķ���
			MySon ms = (MySon)c.newInstance();*/
			
			// ����MySon����
			MySon ms = new MySon();
			
			// ��ȡClass����
			Class<?> c = ms.getClass();
			
			// ���ô�������ķ���
			System.out.println("=========="
					+ "���ô�������ķ���"
					+ "==========");
			ms.methodSonProtected();
			ms.methodSonPublic();
			ms.methodFather();
			
			// ��ӡ���������ϸ��Ϣ
			System.out.println("=========="
					+ "���������Ϣ"
					+ "==========");
			System.out.println(c.getName() + "���Լ�������" 
					+ c.getDeclaredFields().length + "����Ա������");
			System.out.println(c.getName() + "����⹫���ķ�����" 
					+ c.getMethods().length + "����");
			
			for(int i = 0; i < c.getMethods().length; i++)
				System.out.println(c.getMethods()[i]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
