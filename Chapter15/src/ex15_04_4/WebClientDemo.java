// �½�15.04.4             �ͻ����˳������
package ex15_04_4;

import java.io.IOException;
import java.net.Socket;

public class WebClientDemo {

	public static void main(String[] args) throws IOException {
		Socket client = new Socket("www.sina.com.cn", 80);        // ����Socketʵ�������ӵ���������80�˿�
		
		// �������������Ϣ
		System.out.println("������IP�ǣ�" + client.getInetAddress());
		System.out.println("�������˿ں��ǣ�" + client.getPort());
		
		// ����ͻ�����Ϣ
		System.out.println("�ͻ���IP�ǣ�" + client.getLocalAddress());
		System.out.println("�ͻ����˿ں��ǣ�" + client.getLocalPort());
		
		client.close();
		
	}

}
