//章节12.8.2              自定义异常类的使用
package ex12_8_2;

/*
 * 自定义异常类的使用
 */

public class TestMyException {
	
	public static void firstException() throws MyFirstException {
		throw new MyFirstException("\"firstException()\"method occurs an exception！");
	}
	
	public static void secondException() throws MySecondException {
		throw new MySecondException("\"secondException()\"method occurs an exception！");
	}
	
	public static void main(String[] args) {
		try {             //这里只会捕获第一个异常
			TestMyException.firstException();
			TestMyException.secondException();
		} catch(MyFirstException e2) {
			System.out.println("Exception："+e2.getMessage());
			e2.printStackTrace();
		} catch(MySecondException e1) {
			System.out.println("Exception："+e1.getMessage());
			e1.printStackTrace();
		}
	}

}
