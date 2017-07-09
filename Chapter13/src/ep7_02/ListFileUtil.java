//章节7.2                  列出指定目录下的文件
package ep7_02;

import java.io.File;
import java.io.FilenameFilter;

public class ListFileUtil {
	/**
	 * 这是一个内部类，实现了FilenameFilter接口，用于过滤文件
	 */
	static class MyFilenameFilter implements FilenameFilter {
		private String suffix="";              //文件名后缀
		
		public MyFilenameFilter(String suffix) {
			this.suffix=suffix;
		}
		
		public boolean accept(File dir, String name) {
			//如果文件名以suffix指定的后缀相同，便返回true，否则返回false
			if(new File(dir, name).isFile()) {
				return name.endsWith(suffix);
			}
			else {
				//如果是文件夹，则直接返回true
				return true;
			}
		}
	}
	
	/**
	 * 列出目录下所有文件包括子目录的文件路径
	 * @param dirName文件夹的文件路径
	 */
	public static void listAllFiles(String dirName) {
		//如果dir不以文件分隔符结尾，自动添加文件分隔符。
		if(!dirName.endsWith(File.separator))
			dirName+=File.separator;
		File dirFile=new File(dirName);
		//如果dir对应的文件不存在，或者不是一个文件夹，则退出
		if(!dirFile.exists()||(!dirFile.isDirectory())) {
			System.out.println("List失败！找不到目录："+dirName);
			return;
		}
		//列出源文件下所有文件（包括子目录）
		File[] files=dirFile.listFiles();
		for(int i=0; i<files.length; i++) {
			if(files[i].isFile()) {
				System.out.println(files[i].getAbsolutePath()+" 是文件！");
			}
			else if(files[i].isDirectory()) {
				System.out.println(files[i].getAbsolutePath()+" 是目录！");
				ListFileUtil.listAllFiles(files[i].getAbsolutePath());
			}
		}
	}
	
	/**
	 * 列出目录中通过文件名过滤器过滤后的文件。
	 * @param filter文件名过滤对象
	 * @param dirName目录名
	 */
	public static void listFilesByFilenameFilter(FilenameFilter filter, String dirName) {
		//如果dir不以文件分隔符结尾，自动添加文件分隔符。
		if(!dirName.endsWith(File.separator))
			dirName+=File.separator;
		File dirFile=new File(dirName);
		//如果dir对应的文件不存在，或者不是一个文件夹，则退出
		if(!dirFile.exists()||(!dirFile.isDirectory())) {
			System.out.println("List失败！找不到目录："+dirName);
			return;
		}
		//列出源文件夹下所有能通过过滤器的文件（包括子目录）
		File[] files=dirFile.listFiles(filter);
		for(int i=0; i<files.length; i++) {
			if(files[i].isFile()) {
				System.out.println(files[i].getAbsolutePath()+" 是文件！");
			}
			else if(files[i].isDirectory()) {
				System.out.println(files[i].getAbsolutePath()+" 是目录！");
				ListFileUtil.listFilesByFilenameFilter(filter,files[i].getAbsolutePath());
			}
		}
	}
	
	public static void main(String[] args) {
		String dir="D:/BaiduYunDownload";
		System.out.println(dir+"目录下的内容：");
		ListFileUtil.listAllFiles(dir);
		System.out.println();
		
		System.out.println("经过过滤器过滤后的内容：");
		//新建一个文件名为过滤器，参数为".txt"
		FilenameFilter myFilenameFilter=new ListFileUtil.MyFilenameFilter(".mp4");
		ListFileUtil.listFilesByFilenameFilter(myFilenameFilter, dir);
		
	}
}