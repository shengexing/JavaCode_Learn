//�½�14.6.5          �ж��߳�ʾ��
package ex14_06_5;

public class Test {

	public static void main(String[] args) {
		String messages[]= {
				"��Ϣ1", "��Ϣ2", "��Ϣ3", "��Ϣ4"
		};
		for(int i=0; i<messages.length; i++) {
			try {
				Thread.sleep(3000);       //ִ�е�����ͣ3��
			} catch(InterruptedException e) {
				return;        //û�и�����Ϣ�ˣ��ж��߳�
			}
			System.out.println(messages[i]);
		}
	}

}
