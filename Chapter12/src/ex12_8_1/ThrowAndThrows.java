//章节12.8.1              throw、throws、try和catch的使用
package ex12_8_1;

public class ThrowAndThrows {
	
	/*
	 * 计算一个数字的平方根
	 * @param nStr   以字符串的形式提供数字
	 * @return   返回平方根
	 * @throws   Exception当用户输入的字符串为空
	 * 									或者字符串无法转换成数字，或者转换成的数字小于0，都会抛出异常
	 */
	public static double sqrt(String nStr) throws Exception {
		if(nStr==null) {
			//用throw关键字抛出异常，当异常被抛出时，程序会跳出该方法
			throw new Exception("输入的字符串不能为空！");
		}
		double n=0;
		try {
			n=Double.parseDouble(nStr);
		} catch(NumberFormatException e) {
			//将parseDouble方法可能抛出的异常NumberFormatException捕获，然后将捕获的异常重新封装并抛出
			throw new Exception("输入的字符串必须能够转换成数字！",e);
		}
		if(n<0) {
			throw new Exception("输入的字符串转化成的数字必须大于等于0！");
		}
		return Math.sqrt(n);      //计算平方根
	}

	public static void main(String[] args) throws Exception{
		try {
			ThrowAndThrows.sqrt("-124.56");
		} catch (Exception e) {
			//将sqrt方法声明的可能抛出的Exception异常捕获
			//提示捕获的异常的堆栈信息，从堆栈信息中可以发现异常发生的位置和原因
			System.out.println("Got a Exception："+e.getMessage());
			e.printStackTrace();
			throw e;           //不做进一步的处理，将异常向外抛出
		}
		
		//将sqrt声明了可能会抛出的异常向外抛，必须在方法声明中使用throws
		ThrowAndThrows.sqrt("-124.56");     //不会继续执行
		
		//主函数抛出异常
		System.out.println(Math.sqrt(Double.parseDouble("-124.56")));   //不会继续执行

	}

}
