// 章节15.02.1             InetAddress类
package ex15_02_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) throws Exception {
		InetAddress ia = null;            // 定义变量ia
		try {
			ia = InetAddress.getLocalHost();            // 获得本地主机的InetAddress对象
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println("本机的主机名为：" + ia.getHostName());
		System.out.println("本机的IP为：" + ia.getHostAddress());
	}

}