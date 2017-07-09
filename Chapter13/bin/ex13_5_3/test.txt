//章节13.5.3                       I/O操纵的是字节流，所以采用InputStream和OutputStream流类簇实现输入/输出重定向
package ex13_5_3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Redirecting {

	public static void main(String[] args) throws IOException {
		//设置输入对象，用FileInputStream对文件Redirect.java进行包装，创建一个文件输入流对象
		//接着创建一个缓冲输入流对象in，重定向标准输入
		BufferedInputStream in=new BufferedInputStream(new FileInputStream("./src//ex13_5_3//Redirecting.java"));
		
		//创建输出标准输出重定向，创建文件按输出流对象，并依次用BufferedOutputStream和
		//PrintStream进行包装，最后得到一个PrintStream类对象out
		PrintStream out=new PrintStream(new BufferedOutputStream(new FileOutputStream("./src//ex13_5_3//test.txt")));       //设置输出对象
		
		//设置输入流为in对象，输入数据是Redirecting.java文件
		System.setIn(in);
		System.setOut(out);                 //把输出定向到test.txt文件
		
		//从标准输入读数据，此时是读重定向后的文件中的数据
		BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		//通过中间变量s把文件Redirecting.java中的数据输出，此时是输出到重定向的文件test.txt中
		while((s=breader.readLine())!=null)
			System.out.println(s);
		out.close();                    //关闭输出流，释放流占用的资源
	}

}
