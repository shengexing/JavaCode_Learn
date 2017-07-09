//章节7.9                     写文件示例
package ep7_09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * 多种方式写文件
 */

public class WriteToFile {
	/**
	 * 以字节为单位写文件。适合于写二进制文件。如图片等
	 * @param fileName 文件名
	 */
	public static void writeFileByBytes(String fileName) {
		File file=new File(fileName);
		OutputStream out=null;
		try {
			//打开文件输出流
			out=new FileOutputStream(file);
			String content="文件内容：\n1，The First line;\n2，The second line.";
			byte[] bytes=content.getBytes();      //读取输入流中的字节
			//写入文件
			out.write(bytes);
			System.out.println("写文件"+file.getAbsolutePath()+"成功！");
		} catch(IOException e) {
			System.out.println("写文件"+file.getAbsolutePath()+"失败！");
			e.printStackTrace();
		} finally {
			if(out!=null) {
				try {
					out.close();  //关闭输出文件流
				} catch(IOException e1) {
					
				}
			}
		}
	}
	
	/**
	 * 以字符为单位写文件
	 * @param fileName 文件名
	 */
	public static void writeFileByChars(String fileName) {
		File file=new File(fileName);
		Writer writer=null;
		try {
			//打开文件输出流
			writer=new OutputStreamWriter(new FileOutputStream(file));
			String content="文件内容：\n1，The First line;\n2，The second line.";
			writer.write(content);
			System.out.println("写文件"+file.getAbsolutePath()+"成功！");
		} catch(IOException e) {
			System.out.println("写文件"+file.getAbsolutePath()+"失败！");
			e.printStackTrace();
		} finally {
			if(writer!=null) {
				try {
					writer.close();      //关闭输出文件流
				} catch(IOException e1) {
					
				}
			}
		}
	}
	
	/**
	 * 以行为单位写文件
	 * @param fileName 文件名
	 */
	public static void writeFileByLines(String fileName) {
		File file=new File(fileName);
		PrintWriter writer=null;
		try {
			writer=new PrintWriter(new FileOutputStream(file));
			writer.print("文件内容：");              //写字符串
			//写入各种基本类型数据
			writer.print(true);
			writer.print(155);
			writer.println();      //换行
			writer.flush();        //写入文件
			System.out.println("写入文件"+file.getAbsolutePath()+"成功！");
		} catch(FileNotFoundException e) {
			System.out.println("写文件"+file.getAbsolutePath()+"失败！");
			e.printStackTrace();
		} finally {
			if(writer!=null) {
				writer.close();        //关闭输出文件流
			}
		}
	}

	public static void main(String[] args) {
		String fileName="./src/ep7_9/test1.txt";
		WriteToFile.writeFileByBytes(fileName);
		fileName="./src/ep7_9/test2.txt";
		WriteToFile.writeFileByChars(fileName);
		fileName="./src/ep7_9/test3.txt";
		WriteToFile.writeFileByLines(fileName);
	}

}
