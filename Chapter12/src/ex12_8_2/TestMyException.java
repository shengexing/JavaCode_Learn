//�½�12.8.2              �Զ����쳣���ʹ��
package ex12_8_2;

/*
 * �Զ����쳣���ʹ��
 */

public class TestMyException {
	
	public static void firstException() throws MyFirstException {
		throw new MyFirstException("\"firstException()\"method occurs an exception��");
	}
	
	public static void secondException() throws MySecondException {
		throw new MySecondException("\"secondException()\"method occurs an exception��");
	}
	
	public static void main(String[] args) {
		try {             //����ֻ�Ჶ���һ���쳣
			TestMyException.firstException();
			TestMyException.secondException();
		} catch(MyFirstException e2) {
			System.out.println("Exception��"+e2.getMessage());
			e2.printStackTrace();
		} catch(MySecondException e1) {
			System.out.println("Exception��"+e1.getMessage());
			e1.printStackTrace();
		}
	}

}
