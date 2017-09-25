// 章节15.06.3             基本的Socket编程
package ex15_06_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 一个简单的Socket服务器，能接受客户端请求，并将请求返回给客户端
 */
public class SimpleServer {
	
	ServerSocket serverSkt = null;          // 服务端侦听的Socket
	Socket clientSkt = null;        // 客户端
	BufferedReader in = null;       // 客户端输入流
	PrintStream out = null;         // 客户端输出流
	
	// 构造方法
	public SimpleServer(int port) {
		System.out.println("服务器代理正在监听，端口：" + port);
		try {
			serverSkt = new ServerSocket(port);         // 创建监听Socket
		} catch(IOException e) {
			System.err.println("监听端口" + port + "失败");
		}
		try {
			clientSkt = serverSkt.accept();          // 接受连接请求
		} catch(IOException e) {
			System.err.println("连接失败");
		}
		try {
			in = new BufferedReader(
					new InputStreamReader(clientSkt.getInputStream()));      // 获得输入/输出流
			out = new PrintStream(clientSkt.getOutputStream());
		} catch(IOException e) {
			
		}
	}
	
	// 收到客户端请求
	public String getRequest() {
		String frmClt = null;
		try {
			frmClt = in.readLine();       // 从客户端的输入流中读取一行数据
			System.out.println("Server 收到请求：" + frmClt);
		} catch(Exception e) {
			System.err.println("无法读取端口......");
			System.exit(0);
		}
		return frmClt;
	}
	
	// 发送响应给客户端
	public void sendResponse(String response) {
		try {
			out.println(response);            // 往客户端输出流中写数据
			System.out.println("Server 响应请求：" + response);
		} catch(Exception e) {
			System.err.println("写端口失败......");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		SimpleServer sa = new SimpleServer(8888);          // 启动服务器
		while(true) {
			// 获取客户端的输入并返回给客户端
			sa.sendResponse(sa.getRequest());
		}
	}

}
