//章节7.11                 文件的分割与合并
package ep7_11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 文件分割合并器，将大文件分割成若干小文件；将多个小文件合并到一个大文件
 */
public class FileDivisionUniter {

	public static final String SUFFIX=".pp";            //分割后的文件名后缀
	
	/**
	 * 分割文件
	 * @param fileName 待分割的文件名
	 * @param size 小文件的大小，单位字节
	 * @return 分割成的小文件的文件名
	 * @throws Exception 分割过程中可能抛出的异常
	 */
	public static String[] divide(String fileName, long size) throws Exception {
		File inFile=new File(fileName);
		if((!inFile.exists())||(!inFile.isFile())) {
			throw new Exception("指定文件不存在！");
		}
		//获得被分割文件父文件，将被分割成的小文件便存在这个目录下
		File parentFile=inFile.getParentFile();
		//取得文件大小
		long fileLength=inFile.length();
		if(size<=0) {
			size=fileLength/2;
		}
		//取得被分割后的小文件的数目
		int num=(