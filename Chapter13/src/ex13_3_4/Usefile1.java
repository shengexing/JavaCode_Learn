//章节13.4.3                演示文件的写入
package ex13_3_4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Usefile1 {

	public static void main(String[] args) throws IOException{
		
		int i;
		FileReader fr;
		FileWriter fw;
		
		try {
			fr=new FileReader("text.txt");      //打开输入文件
		} catch(FileNotFoundException e) {
			System.out.println("not found this file");
			return;
		}
		
		try {
			fw=new FileWriter("text1.txt");        //打开输出文件
		} catch(FileNotFoundException e) {        //若未找到输出文件，则会自动创建文件，故catch块的内容不会执行
			System.out.println("error");
			return;
		}
		
		try {
			i=fr.read();        //读数据
			while(i!=-1) {
				fw.write(i);          //写数据
				i=fr.read();
			}
			fr.close();
			fw.close();
		} catch(IOException e) {
			System.out.println("error");
		}
	}

}
