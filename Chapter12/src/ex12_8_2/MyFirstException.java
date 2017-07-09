//章节12.8.2              自定义异常类的使用
package ex12_8_2;

/*
 * 自定义异常类
 * 第一种定义方式，继承Exception类
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
