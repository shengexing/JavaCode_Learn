//章节10.7.3                        缩放图片（JPG缩放时可能出现的异常）
package ex10_7_3;

public class JPGException extends Exception{
	public JPGException(String msg) {
		super(msg);
	}
	
	public JPGException(Exception e) {
		super(e);
	}
	
	public JPGException(Throwable t) {
		super(t);
	}
	
	public JPGException(String msg,Throwable t) {
		super(msg,t);
	}

}
