//�½�4.6.6              ��λ�����ʾ��
package ex4_6_6;

public class test1 {

	public static void main(String[] args) {
		int num=-1073741836;
		int num1=-11;
		System.out.println("���Ʋ�����");
		System.out.println(num+":"+Integer.toBinaryString(num)+";"+(num>>1)+":"+Integer.toBinaryString(num>>1));         //���Ʋ���
		System.out.println(num1+":"+Integer.toBinaryString(num1)+";"+(num1>>1)+":"+Integer.toBinaryString(num1>>1));
		System.out.println("���Ʋ�����");
		System.out.println(num+":"+Integer.toBinaryString(num)+";"+(num<<1)+":"+Integer.toBinaryString(num<<1));         //���Ʋ���
		System.out.println(num1+":"+Integer.toBinaryString(num1)+";"+(num1<<1)+":"+Integer.toBinaryString(num1<<1));
		System.out.println("�޷������Ʋ�����");
		System.out.println(num+":"+Integer.toBinaryString(num)+";"+(num>>>1)+":"+Integer.toBinaryString(num>>>1));         //�޷��������Ʋ���
		System.out.println(num1+":"+Integer.toBinaryString(num1)+";"+(num1>>>1)+":"+Integer.toBinaryString(num1>>>1));

	}

}
