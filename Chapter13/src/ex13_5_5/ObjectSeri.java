//章节13.5.5                  序列化对象的使用
package ex13_5_5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectSeri {

	public static void main(String[] args) {
		try {
			//创建文件输出流对象，该对象指明把对象数据写入参数所指目录中的ObjectSeriOut.txt文件中
			FileOutputStream out=new FileOutputStream(".\\src\\ex13_5_5\\ObjectSeriOut.txt");
			
			//创建对象输出流，该流对象的参数是文件输入流对象
			ObjectOutputStream sOut=new ObjectOutputStream(out);
			sOut.writeObject(new String("current time is:"));         //向对象输出流写对象
			sOut.writeObject(new Date());                //向对象输出流写对象，该对象是Date类型
			sOut.writeInt(1000);                    //向对象输出流写对象，该对象是int类型
			
			//将对象输出流中的对象全部推出缓冲区写入文件
			sOut.flush();
			out.close();               //关闭对象输出流，释放流占用的资源
			
			//创建文件输入流对象，从对象流文件ObjectSeri.txt中读取对象数据
			FileInputStream in=new FileInputStream(".\\src\\ex13_5_5\\ObjectSeriOut.txt");
			
			//创建对象输入流，通过该流的各种方法读取对象数据
			ObjectInputStream sIn=new ObjectInputStream(in);
			//通过对象输入流从文件ObjectSeriOut.txt读取各种对象，并赋予对应类型的变量
			String flag=(String)sIn.readObject();
			Date date=(Date)sIn.readObject();
			int i=(int)sIn.readInt();
			System.out.println(flag+date);
			System.out.println("int型数据："+i);
			
			sIn.close();                           //关闭对象输入流，释放输入流占用资源
			//捕获IOException异常和ClassNotFoundException异常
		} catch(IOException ex) {
			System.err.println("IOException happend");
		} catch(ClassNotFoundException f) {
			System.err.println("ClassNotFoundException happend");
		}
	}

}
