//章节12.8.2              自定义异常类的使用
package ex12_8_2;

/*
 * 自定义异常类
 * 第二种定义方式：继承Throwable类
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
