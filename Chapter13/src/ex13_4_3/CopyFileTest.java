//章节13.4.3                    复制文件
package ex13_4_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class CopyFileTest {
	//参数oldFile  如d:/old.txt,参数newFile如d:/new.txt
	public void copyFile(String oldFile, String newFile) {
		try {
			int bytesum=0;
			int byteread=0;
			File oldfile=new File(oldFile);
			//判断文件是否存在，如果文件存在，则实现该文件向新文件的复制
			if(oldfile.exists()) {
				//读取原文件
				InputStream ins=new FileInputStream(oldFile);
				//创建文件输出流，写入文件
				FileOutputStream outs=new FileOutputStream(newFile);
				//创建缓冲区，大小为500字节
				byte[] buffer=new byte[500];
				//每次从文件输入流中读取500字节数据，计算当前为止读取的数据总数
				while((byteread=ins.read(buffer))!=-1) {
					bytesum+=byteread;
					System.out.println(bytesum);
					//把当前缓冲区中的数据写入新文件
					outs.write(buffer,0,byteread);
				}
				ins.close();        //关闭文件输入流
			}
		} catch(Exception ex) {
			System.out.println("原文件不存在");
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//创建类对象实例，并调用copyFile()函数，函数参数在执行程序时在控制台输入
		//第一个参数表示老文件，第二个参数表示新文件
		CopyFileTest copyfile=new CopyFileTest();
		copyfile.copyFile(args[0], args[1]);
	}

}
