//章节13.4.1              创建文件夹
package ex13_4_1;

import java.io.File;

public class CreateNewFolder {
	//参数newFolder表示新建目录的名称，该方法在创建新目录时首先判断目录文件是否存在
	//如存在，程序则跳转到异常处理代码，提示一行错误信息，如果不存在则建立该目录
	private void newFolder(String newfolder) {
		try {
			String filepath=newfolder;
			File myPath=new File(filepath);
			if(!myPath.exists()) {             //判断文件夹路径是否存在
				myPath.mkdir();
			}
		} catch(Exception e) {
			System.out.println("新建目录已存在");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//创建该public类的对象，以调用其函数来建立目录
		CreateNewFolder createNewFolder=new CreateNewFolder();
		//获得执行程序时的参数，该参数在执行程序的代码后直接给出
		//该参数放在临时变量mynewpath中
		String mynewpath=args[0];
		//对象调用其函数来创建新目录
		createNewFolder.newFolder(mynewpath);
	}

}
