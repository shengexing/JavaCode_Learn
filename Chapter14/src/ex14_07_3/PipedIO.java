//�½�14.7.3                  �ܵ�ͨ��ʵ��
package ex14_07_3;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;

class PipedSender extends Thread{
	
	private Random rand=new Random();
	//����PipedWriter�����ͨ���ö�����ܵ���д�ַ�����
	private PipedWriter out=new PipedWriter();
	public PipedWriter getPipedWriter() {
		return out;
	}
	public void run() {
		//ͨ��һ������ѭ������ܵ�д���ַ����ַ����д�A��Z����ѭ�����
		while(true) {
			for(char c='A'; c<='Z'; c++) {
				try {
					//ͨ������out��ܵ�д�ַ����ݣ�ÿд��һ���ַ�ֹͣ500����
					out.write(c);
					sleep(rand.nextInt(500));
				} catch(Exception ex) {
					throw new RuntimeException(ex);
				}
			}
		}
	}
}

/**
 * ������PipedReceiver������Ķ����ȡ�ܵ��е��ַ�����
 */
class PipeReceiver extends Thread {
	
	private PipedReader in;
	//��PipedReceiver�Ĺ��캯����ͨ����PipedReader�Ĵ��������캯������һ��PipedReader����in
	public PipeReceiver(PipedSender sender) throws IOException {
		in=new PipedReader(sender.getPipedWriter());
	}
	//ͨ������in��ȡ�ܵ��е��ַ�������int������ת�����ַ���ʾ����Ļ��
	public void run() {
		try {
			while(true) {
				System.out.println("Read_data is :"+(char)in.read());
			}
		} catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}

public class PipedIO {

	public static void main(String[] args) throws Exception{
		//�����̶߳���sender
		PipedSender sender=new PipedSender();
		//�����̶߳���receiver���ö�����Ĺ��캯������Ϊ����sender
		PipeReceiver receiver=new PipeReceiver(sender);
		//���������߳�
		sender.start();
		receiver.start();
	}

}
