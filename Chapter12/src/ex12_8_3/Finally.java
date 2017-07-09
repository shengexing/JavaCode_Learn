//�½�12.8.2             ʹ��finally
package ex12_8_3;

import ex12_8_2.MyFirstException;
import ex12_8_2.MySecondException;

/*
 * try catch finally���÷�
 * �����Ƿ����쳣��finally�����ʼ�ն���ִ��
 */

public class Finally {

	/*
	 * ����ƽ����
	 * @param nStr  ���ֵ��ַ���
	 * @return  ����ƽ����
	 * @throws MyFirstException  �������ַ���Ϊ�գ����ַ�������ת��������ʱ���׳����쳣
	 * @throws MySecondException   ��������ַ���ת���ɵ�����Ϊ����ʱ���׳����쳣
	 */
	
	public static double getSqrt(String nStr) throws MyFirstException, MySecondException {
		if(nStr==null) {
			throw new MyFirstException("������ַ�������Ϊ�գ�");
		}
		double n=0;
		try {
			n=Double.parseDouble(nStr);
		} catch(NumberFormatException e) {
			throw new MyFirstException("������ַ��������ܹ�ת�������֣�", e);
		}
		if(n<0) {
			throw new MySecondException("������ַ���ת���ɵ����ֱ�����ڵ���0��");
		}
		return Math.sqrt(n);
	}
	
	public static double testFinallyA(String nStr) {
		try {
			System.out.println("Try block��");
			return getSqrt(nStr);
		} catch(MyFirstException e1) {
			System.out.println("Catch MyFirstException block��");
			System.out.println("Exception��"+e1.getMessage());
			return -1;
		} catch(MySecondException e2) {
			System.out.println("Catch MySecondException block��");
			System.out.println("Exception��"+e2.getMessage());
			return -2;
		} finally {
			System.out.println("Finally block��");
		}
	}
	
	public static double testFinallyB(String nStr) {
		try {
			System.out.println("Try block��");
			return getSqrt(nStr);
		} catch(MyFirstException e1) {
			System.out.println("Catch MyFirstException block��");
			System.out.println("Exception��"+e1.getMessage());
			return -1;
		} catch(MySecondException e2) {
			System.out.println("Catch MySecondException block��");
			System.out.println("Exception��"+e2.getMessage());
			return -2;
		} finally {
			System.out.println("Finally block��");
			//����һ�У�����һ��ֵ
			return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("ʹ��testFinallyA������");
		System.out.println("û�з����쳣ʱ�������");
		System.out.println("result��"+Finally.testFinallyA("123.4"));
		System.out.println("�����쳣ʱ�������");
		System.out.println("result��"+Finally.testFinallyA("dfdg"));
		System.out.println("ʹ��testFinallyB������");
		System.out.println("û�з����쳣ʱ�������");
		System.out.println("result��"+Finally.testFinallyB("123.4"));
		System.out.println("�����쳣ʱ�������");
		System.out.println("result��"+Finally.testFinallyB("dfdg"));
	}
}
