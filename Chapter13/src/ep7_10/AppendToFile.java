//章节7.10                 添加内容到文件尾
package ep7_10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import ep7_08.ReadFromFile;

/**
 * 将内容追加到文件尾部
 */
public class AppendToFile {
	/**
	 * A方法追加文件：使用RandomAccessFile
	 * @param fileName 文件名
	 * @param content 追加的内容
	 */
	public static void appendMethodA(String fileName, String content) {
		try {
			//打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile=new RandomAccessFile(fileName, "rw");
			long fileLength=randomFile.length();      //文件长度，字节数
			//将写文件指针移到文件尾
			randomFile.seek(fileLength);
			randomFile.writeBytes(content);
			randomFile.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * B方法追加文件：使用FileWriter
	 */
	public static void appendMethodB(String fileName, String content) {
		try {
			//打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer=new FileWriter(fileName, true);
			writer.write(content);
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String fileName="./src/ep7_09/test3.txt";
		String content="new append!";
		//按方法A追加文件
		AppendToFile.appendMethodA(fileName, content);
		AppendToFile.appendMethodA(fileName, " append end. \n");
		ReadFromFile.readFileByLines(fileName);     //显示文件内容
		//按方法B追加文件
		AppendToFile.appendMethodB(fileName, content);
		AppendToFile.appendMethodB(fileName, " append end. \n");
		ReadFromFile.readFileByLines(fileName);     //显示文件内容
	}

}
