package calcultor;

import java.util.ArrayList;
import java.util.List;

public class Calcute {

	//����洢�������Ͳ��������б�
	static List<String> operator_number=new ArrayList<String>();
	static List<chara> operator_charater=new ArrayList<chara>();
	
	//ȱʡ���캯��
	public Calcute() {
		this.operator_number=null;
		this.operator_charater=null;
	}
	
	//���εĹ��캯��
	public Calcute(List<String> num, List<chara> cha) {
		this.operator_number=num;
		this.operator_charater=cha;
	}
	
	//������������
	public static double Add(double num1,double num2) {
		return num1+num2;
	}
	public static double Des(double num1,double num2) {
		return num1-num2;
	}
	public static double Mult(double num1,double num2) {
		return num1*num2;
	}
	public static double Div(double num1,double num2) {
		return num1/num2;
	}
	public static double Per(double num) {   //�ٷ�����
		return num/100;
	}
	
}
