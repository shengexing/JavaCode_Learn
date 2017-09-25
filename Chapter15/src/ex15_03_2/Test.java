// 章节15.03.2             URL的各种方法
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
		
		System.out.println("protocol  = " + aURL.getProtocol());            // 输出URL对象的协议
		System.out.println("authority = " + aURL.getAuthority());          // 输出URL对象的主机和端口号
		
		System.out.println("host = " + aURL.getHost());                 // 输出URL的主机名
		System.out.println("port = " + aURL.getPort());                  // 获得该URL的端口号 

	}

}
