import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class TEST {
	
	public static void main(String[] args) {
		try {
			URL wy = new URL("http://www.baidu.com/");
			// ���URLConnection����
			URLConnection wyConnection = wy.openConnection();
			// ����Զ����Դ
			wyConnection.connect();
		} catch(IOException e) {
			// openConnection()����ʧ��ʱ���������쳣
			
		}

	}
}
