// �½�15.06.3             ������Socket���
package ex15_06_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * һ���򵥵�Socket���������ܽ��ܿͻ������󣬲������󷵻ظ��ͻ���
 */
public class SimpleServer {
	
	ServerSocket serverSkt = null;          // �����������Socket
	Socket clientSkt = null;        // �ͻ���
	BufferedReader in = null;       // �ͻ���������
	PrintStream out = null;         // �ͻ��������
	
	// ���췽��
	public SimpleServer(int port) {
		System.out.println("�������������ڼ������˿ڣ�" + port);
		try {
			serverSkt = new ServerSocket(port);         // ��������Socket
		} catch(IOException e) {
			System.err.println("�����˿�" + port + "ʧ��");
		}
		try {
			clientSkt = serverSkt.accept();          // ������������
		} catch(IOException e) {
			System.err.println("����ʧ��");
		}
		try {
			in = new BufferedReader(
					new InputStreamReader(clientSkt.getInputStream()));      // �������/�����
			out = new PrintStream(clientSkt.getOutputStream());
		} catch(IOException e) {
			
		}
	}
	
	// �յ��ͻ�������
	public String getRequest() {
		String frmClt = null;
		try {
			frmClt = in.readLine();       // �ӿͻ��˵��������ж�ȡһ������
			System.out.println("Server �յ�����" + frmClt);
		} catch(Exception e) {
			System.err.println("�޷���ȡ�˿�......");
			System.exit(0);
		}
		return frmClt;
	}
	
	// ������Ӧ���ͻ���
	public void sendResponse(String response) {
		try {
			out.println(response);            // ���ͻ����������д����
			System.out.println("Server ��Ӧ����" + response);
		} catch(Exception e) {
			System.err.println("д�˿�ʧ��......");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		SimpleServer sa = new SimpleServer(8888);          // ����������
		while(true) {
			// ��ȡ�ͻ��˵����벢���ظ��ͻ���
			sa.sendResponse(sa.getRequest());
		}
	}

}
