//章节14.7.3                  管道通信实例
package ex14_07_3;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;

class PipedSender extends Thread{
	
	private Random rand=new Random();
	//创建PipedWriter类对象，通过该对象向管道中写字符数据
	private PipedWriter out=new PipedWriter();
	public PipedWriter getPipedWriter() {
		return out;
	}
	public void run() {
		//通过一个无限循环，向管道写入字符，字符序列从A到Z，且循环输出
		while(true) {
			for(char c='A'; c<='Z'; c++) {
				try {
					//通过对象out向管道写字符数据，每写入一个字符停止500毫秒
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
 * 创建类PipedReceiver，该类的对象读取管道中的字符数据
 */
class PipeReceiver extends Thread {
	
	private PipedReader in;
	//类PipedReceiver的构造函数，通过类PipedReader的带参数构造函数创建一个PipedReader对象in
	public PipeReceiver(PipedSender sender) throws IOException {
		in=new PipedReader(sender.getPipedWriter());
	}
	//通过对象in读取管道中的字符，并把int型数据转换成字符显示到屏幕上
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
		//创建线程对象sender
		PipedSender sender=new PipedSender();
		//创建线程对象receiver，该对象类的构造函数参数为对象sender
		PipeReceiver receiver=new PipeReceiver(sender);
		//启动两个线程
		sender.start();
		receiver.start();
	}

}
