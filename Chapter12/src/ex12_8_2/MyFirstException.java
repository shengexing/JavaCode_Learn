//�½�12.8.2              �Զ����쳣���ʹ��
package ex12_8_2;

/*
 * �Զ����쳣��
 * ��һ�ֶ��巽ʽ���̳�Exception��
 */

public class MyFirstException extends Exception {
	
	public MyFirstException() {
		super();
	}
	
	public MyFirstException(String msg) {
		super(msg);
	}
	
	public MyFirstException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public MyFirstException(Throwable cause) {
		super(cause);
	}

}
