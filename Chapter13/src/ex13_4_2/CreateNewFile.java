//章节13.4.2                 首先创建一个用户指定名称和类型的数据，并向文件中写入数据
package ex13_4_2;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CreateNewFile {
	//创建一个方法完成创建文件的目的，文件的第一个参数是文件路径和文件名，第二个参数是文件内容
	public void createNewFile(String fileDerectoryAndName, String fileContent) {
		try {
			String fileName=fileDerectoryAndName;
			//创建File对象，参数为String类型，表示目录名
			File myFile=new File(fileName);
			//判断目录是否存在，如果存在则调用creatNewFile()方法创建新目录，否则跳转至异常处理代码
			if(!myFile.exists())
				myFile.createNewFile();
			else {
				System.out.println("文件已存在！");
				return;
			}
			
			//下面把数据写入创建的文件，首先新建文件名为参数创建FileWriter对象
			FileWriter resultFile=new FileWriter(myFile);
			//把该对象包装进PrinterWriter对象
			PrintWriter myNewFile=new PrintWriter(resultFile);
			//再通过PrintWriter对象的println()方法吧字符串数据写入新建文件
			myNewFile.println(fileContent);
			resultFile.close();               //关闭文件写入流
		} catch(Exception ex) {
			System.out.println("无法新建文件");
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//创建类的对象并调用该对象的createNewFile()方法，创建新文件并写入数据
		CreateNewFile createFile=new CreateNewFile();
		createFile.createNewFile(args[0], args[1]);
	}

}
