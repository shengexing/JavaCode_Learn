//章节13.4.3                演示文件的读入
package ex13_3_4;

import java.io.FileReader;

public class Usefile {

	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("text.txt");          //打开输入文件
			char[] c=new char[1];
			while(fr.read(c)!=-1)                       //读数据
				System.out.print(new String(c));
			fr.close();
		} catch(Exception e) {
			System.out.println(e);                    //输出异常
		}
	}

}
