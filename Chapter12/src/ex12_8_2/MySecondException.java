//�½�12.8.2              �Զ����쳣���ʹ��
package ex12_8_2;

/*
 * �Զ����쳣��
 * �ڶ��ֶ��巽ʽ���̳�Throwable��
 */

public class MySecondException extends Throwable {
	
	public MySecondException() {
		super();
	}
	
	public MySecondException(String msg) {
		super(msg);
	}
	
	public MySecondException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public MySecondException(Throwable cause) {
		super(cause);
	}

}
