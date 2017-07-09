package calcultor;

import java.util.ArrayList;
import java.util.List;

public class Calcute {

	//定义存储操作数和操作符的列表
	static List<String> operator_number=new ArrayList<String>();
	static List<chara> operator_charater=new ArrayList<chara>();
	
	//缺省构造函数
	public Calcute() {
		this.operator_number=null;
		this.operator_charater=null;
	}
	
	//带参的构造函数
	public Calcute(List<String> num, List<chara> cha) {
		this.operator_number=num;
		this.operator_charater=cha;
	}
	
	//基本四则运算
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
	public static double Per(double num) {   //百分运算
		return num/100;
	}
	
}
