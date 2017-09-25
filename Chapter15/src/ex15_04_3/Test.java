// �½�15.04.3             �������˳������
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
			server = new ServerSocket(5678);         // ����ServerSocketʵ��������Ϊ�����Ķ˿ں�
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("�����������������ڵȴ�����......");
		
		Socket client = null;
		try {
			client = server.accept();          // �������ȴ��ͻ�������
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("�ͻ������ӽ�����");
		
		// ���Socket���ӵ��ֽ���������ת��Ϊ�����ַ���
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		// ���Socket���ӵĴ�ӡ�����
		PrintWriter out = null;
		try {
			out = new PrintWriter(client.getOutputStream());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {                                             // ѭ����ȡ�������е�����
			String str = in.readLine();                     // ��ȡ�������е�һ������
			System.out.println(str);                         // ���������������̨
			out.println("�ѽ���......");                      // ��������������Ϣ
			out.flush();                                            // ˢ�������
			if(str.equals("end"))                               // ����ͻ��˷�����"end"��˵����������
				break;
		}
		
		in.close();                         // ��˳��ر�����/�����
		out.close();
		client.close();                   // �ر�Socket����
		server.close();                  // �ر�ServerSocket
		
	}

}
