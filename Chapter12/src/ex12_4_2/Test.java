//�½�12.4.2              ʹ���Զ����쳣ʵ��
package ex12_4_2;

import java.util.Scanner;

public class Test {
	static int avg(int number1, int number2) throws MyException {        //�����׳��Զ����쳣
		if(number1<0||number2<0) {
			throw new MyException("������ʹ�ø���");            //�׳��Զ����쳣
		}
		if(number1>100||number2>100) {
			throw new MyException("��ֵ̫����");           //�׳��Զ����쳣
		}
		return (number1+number2)/2;             //�������
	}

	public static void main(String[] args) {
		System.out.println("����������ƽ������"+"��������������Ҫ���Ƕ�С��100������");
		Scanner in=new Scanner(System.in);         //����һ���������ڶ�ȡ�û�����
		int number1=in.nextInt();               //�Ӽ��̻������
		int number2=in.nextInt();              //�Ӽ��̻������
		try {
			int result=avg(number1,number2);         //���÷���avg()
			System.out.println(result);
		} catch(MyException e) {
			System.out.println(e);
		}
	}
}

class MyException extends Exception {                //�Զ����쳣�̳�Exception��
	MyException(String ErrorMessage) {
		super(ErrorMessage);
	}
}
