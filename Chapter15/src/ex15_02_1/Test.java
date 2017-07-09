// �½�15.02.1             InetAddress��
package ex15_02_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) throws Exception {
		InetAddress ia = null;            // �������ia
		try {
			ia = InetAddress.getLocalHost();            // ��ñ���������InetAddress����
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println("������������Ϊ��" + ia.getHostName());
		System.out.println("������IPΪ��" + ia.getHostAddress());
	}

}