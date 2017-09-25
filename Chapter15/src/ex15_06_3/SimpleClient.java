// �½�15.06.3             ������Socket���
package ex15_06_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * һ���򵥵�socket�ͻ��ˣ��ܹ�������������socket����
 */
public class SimpleClient {
	
	// �ͻ�������/�����
	PrintStream out;
	BufferedReader in;
	
	// ���췽��
	public SimpleClient(String serverName, int port) {
		try {
			// ���ݷ��������Ͷ˿ںţ����ӷ�����
			Socket clientSocket = new Socket(serverName, port);
			// ��ȡsocket������/�����
			out = new PrintStream(clientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch(Exception e) {
			System.err.println("�޷����ӷ�������");
		}
	}
	
	// ��������
	public void sendRequest(String request) {
		out.println(request);             // ��Socket�������д����
		System.out.println("Client ��������" + request);
	}
	
	public String getResponse() {
		String str = new String();
		try {
			str = in.readLine();             // ��Socket���������ж�ȡ����
			System.out.println("Client�յ�Server���أ�" + str);
		} catch(IOException e) {
			
		}
		return str;
	}

}
