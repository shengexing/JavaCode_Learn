//章节13.5.1                演示如何通过各种文件流实现文件的复制
package ex13_5_1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamTest {
	
	public static void main(String[] args) throws IOException {
		/*
		 * 在两个文件上建立输入和输出流，该文件是两个File实例，从输出流对象filein读数据，
		 * 源文件是FileStreamTest.java，通过输出流对象fileout写数据到指定目标文件
		 */
		FileReader filein=new FileReader(new File("./src//ex13_5_1//FileStreamTest.java"));
		FileWriter fileout=new FileWriter(new File("./src//ex13_5_1//DestriFileStreamTest.txt"));
		int c;
		
		//依次读取输入流中的数据，先存储在变量c中，然后把数据写入输出流
		//写入文件DestiFileStreamTest.txt
		while((c=filein.read())!=-1)
			fileout.write(c);
		//关闭输入流和输出流，释放流占用的资源
		filein.close();
		fileout.close();
	}

}
