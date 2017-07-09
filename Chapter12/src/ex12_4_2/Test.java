//章节12.4.2              使用自定义异常实例
package ex12_4_2;

import java.util.Scanner;

public class Test {
	static int avg(int number1, int number2) throws MyException {        //声明抛出自定义异常
		if(number1<0||number2<0) {
			throw new MyException("不可以使用负数");            //抛出自定义异常
		}
		if(number1>100||number2>100) {
			throw new MyException("数值太大了");           //抛出自定义异常
		}
		return (number1+number2)/2;             //返回语句
	}

	public static void main(String[] args) {
		System.out.println("求两个数的平均数！"+"请输入两个数，要求是都小于100的数：");
		Scanner in=new Scanner(System.in);         //创建一个对象，用于读取用户输入
		int number1=in.nextInt();               //从键盘获得输入
		int number2=in.nextInt();              //从键盘获得输入
		try {
			int result=avg(number1,number2);         //调用方法avg()
			System.out.println(result);
		} catch(MyException e) {
			System.out.println(e);
		}
	}
}

class MyException extends Exception {                //自定义异常继承Exception类
	MyException(String ErrorMessage) {
		super(ErrorMessage);
	}
}
