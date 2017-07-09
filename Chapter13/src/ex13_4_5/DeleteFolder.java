//章节13.4.5              删除文件夹
package ex13_4_5;

import java.io.File;

public class DeleteFolder {
	//定义删除文件夹函数，参数为文件路径
	public void delFolder(String folderPath) {
		try {
			//调用删除所有文件函数，删除该目录侠的所有文件
			delAllFile(folderPath);
			//创建文件对象，参数为欲删除的目录
			File myFilePath=new File(folderPath);
			myFilePath.delete();              //调用删除目录函数
		} catch(Exception ex) {
			System.out.println("删除文件夹错误！");
			ex.printStackTrace();
		}
	}
	
	public void delAllFile(String path) {      //定义并创建删除所有文件方法，参数为文件路径
		File file=new File(path);               //创建文件对象，参数为文件路径
		if(!file.exists()) {              //如果文件不存在，则跳出函数
			return;
		}
		if(!file.isDirectory()) {            //如果该file对象不是目录也跳出函数
			return;
		}
		
		String[] tempList=file.list();                  //取出目录下的文件名或目录名
		File temp=null;
		for(int i=0; i<tempList.length; i++) {
			//列出当前文件夹下的文件或目录，可以方便地观察删除了的那些文件
			System.out.println(tempList[i].toString());
			if(path.endsWith(File.separator)) {
				temp=new File(path+tempList[i]);
			}
			else {
				//为欲删除目录下的每一个文件或目录创建临时File对象，参数为全路径
				temp=new File(path+File.separator+tempList[i]);
			}
			
			//如果temp是文件则删除该文件
			if(temp.isFile())
				temp.delete();
			
			//如果temp是目录名则调用删除所有文件的方法，此时出现了delAllFile()方法的迭代调用
			if(temp.isDirectory()) {
				delAllFile(path+"/"+tempList[i]);
				delFolder(path+"/"+tempList[i]);
			}
		}	
	}

	public static void main(String[] args) {           //参数中的“./”表示当前路径 
		DeleteFolder deleteFolder=new DeleteFolder();
		deleteFolder.delFolder(args[0]);
	}

}
