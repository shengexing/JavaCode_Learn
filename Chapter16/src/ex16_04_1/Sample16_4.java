// �½�16.04.1             �µ��������ռ�
package ex16_04_1;

/*�Զ���ġ���������*/
class Rubbish {
	// ����һ���������͵�����
	Rubbish brother;
	// �����ַ�������
	String rname;
	
	// �޲ι�����
	public Rubbish() {
		
	}
	
	// ����������
	public Rubbish(String rname) {
		this.rname = rname;
	}
	
	// ��дfinalize()����
	public void finalize() {
		System.out.println(this.rname + "�����Ϊ�����������ռ�������");
	}
}

public class Sample16_4 {

	public static void main(String[] args) {
		// ����3��Rubbish����
		Rubbish r1 = new Rubbish("�µ��е�r1");
		Rubbish r2 = new Rubbish("�µ��е�r2");
		Rubbish r3 = new Rubbish("�µ��е�r3");
		
		// �����������������γ�һ����
		r1.brother = r2;
		r2.brother = r3;
		r3.brother = r1;
		
		// �Ͼ�����������ϵ���γɹµ�
		r1 = null;
		r2 = null;
		r3 = null;
		
		// ����ִ�������ռ�
		System.gc();
		// ���߳����ߣ��Ӵ�����ɹ��Ļ���
		try {
			Thread.sleep(100);         //���߳�����100����
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
