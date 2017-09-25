// �½�15.03.2             URL�ĸ��ַ���
package ex15_03_2;

import java.net.MalformedURLException;
import java.net.URL;

public class Test {

	public static void main(String[] args) {
		URL aURL = null;
		
		try {
			aURL = new URL("http://www.google.com:80");
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		System.out.println("protocol  = " + aURL.getProtocol());            // ���URL�����Э��
		System.out.println("authority = " + aURL.getAuthority());          // ���URL����������Ͷ˿ں�
		
		System.out.println("host = " + aURL.getHost());                 // ���URL��������
		System.out.println("port = " + aURL.getPort());                  // ��ø�URL�Ķ˿ں� 

	}

}
