// 章节15.04.4             客户器端程序设计
package ex15_04_4;

import java.io.IOException;
import java.net.Socket;

public class WebClientDemo {

	public static void main(String[] args) throws IOException {
		Socket client = new Socket("www.sina.com.cn", 80);        // 创建Socket实例，连接到新浪网的80端口
		
		// 输出服务器端信息
		System.out.println("服务器IP是：" + client.getInetAddress());
		System.out.println("服务器端口号是：" + client.getPort());
		
		// 输出客户机信息
		System.out.println("客户机IP是：" + client.getLocalAddress());
		System.out.println("客户机端口号是：" + client.getLocalPort());
		
		client.close();
		
	}

}
