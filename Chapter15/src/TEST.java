import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class TEST {
	
	public static void main(String[] args) {
		try {
			URL wy = new URL("http://www.baidu.com/");
			// 获得URLConnection对象
			URLConnection wyConnection = wy.openConnection();
			// 连接远程资源
			wyConnection.connect();
		} catch(IOException e) {
			// openConnection()方法失败时，产生此异常
			
		}

	}
}
