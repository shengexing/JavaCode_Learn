//章节13.4.4                   删除文件
package ex13_4_4;

import java.io.File;

public class DeleteFile {
	
	public void delFile(String fileDerecatorAndName) {
		try {
			//以要删除的文件或文件夹名为参数，创建File对象
			File deletedFile=new File(fileDerecatorAndName);
			//调用File类的delete方法删除文件
			deletedFile.delete();
		} catch(Exception ex) {
			System.out.println("删除文件错误");
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//创建类DeleteFile的对象
		DeleteFile deleteFile=new DeleteFile();
		//调用类的delFile方法，参数为要删除的文件或文件夹
		deleteFile.delFile(args[0]);
	}

}
