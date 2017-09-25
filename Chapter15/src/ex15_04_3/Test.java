// 章节15.04.3             服务器端程序设计
package ex15_04_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {

	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		try {
			server = new ServerSocket(5678);         // 创建ServerSocket实例，参数为监听的端口号
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("服务器以启动，正在等待连接......");
		
		Socket client = null;
		try {
			client = server.accept();          // 阻塞，等待客户端连接
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("客户端连接建立：");
		
		// 获得Socket连接的字节输入流并转换为缓冲字符流
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		// 获得Socket连接的打印输出流
		PrintWriter out = null;
		try {
			out = new PrintWriter(client.getOutputStream());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {                                             // 循环读取输入流中的内容
			String str = in.readLine();                     // 读取输入流中的一行内容
			System.out.println(str);                         // 将内容输出到控制台
			out.println("已接收......");                      // 向输出流中输出信息
			out.flush();                                            // 刷新输出流
			if(str.equals("end"))                               // 如果客户端发过来"end"，说明结束连接
				break;
		}
		
		in.close();                         // 按顺序关闭输入/输出流
		out.close();
		client.close();                   // 关闭Socket连接
		server.close();                  // 关闭ServerSocket
		
	}

}
