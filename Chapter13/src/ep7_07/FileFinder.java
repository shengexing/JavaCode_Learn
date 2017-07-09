//章节7.7                一个简单的文件搜索器
package ep7_07;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现一个支持通配符的基于广度优先算法的文件查找器
 */
public class FileFinder {
	/**
	 * 查找文件
	 * @param baseDirName 带查找的目录
	 * @param targetFileName 目标文件名，支持通配符形式
	 * @param count 期望结果数目，如果为0，则表示查找全部
	 * @return 满足查询条件的文件名列表
	 */
	public static List findFiles(String baseDirName, String targetFileName, int count) {
		/**
		 * 算法简述：
		 * 从某个给定的需查找的文件夹出发，搜索该文件夹的所有子文件夹及文件，
		 * 若为文件，则进行匹配，匹配成功则加入结果集，若为子文件夹，则进队列
		 * 队列不空，重复上述操作，队列为空，程序结束，返回结果
		 */
		List fileList=new ArrayList();           //判断目录是否存在
		File baseDir=new File(baseDirName);
		if(!baseDir.exists()||!baseDir.isDirectory()) {
			System.out.println("文件查找失败："+baseDirName+"不是一个目录！");
			return fileList;
		}

		String tempName=null;
		//创建一个队列，Queue在第四章有定义
		Queue queue=new Queue();          //实例化队列
		queue.add(baseDir);   //入队
		File tempFile=null;
		while(!queue.isEmpty()) {        //从队列中取目录
			tempFile=(File) queue.pop();
			if(tempFile.exists()&&tempFile.isDirectory()) {
				File[] files=tempFile.listFiles();
				if(files!=null) {
					for(int i=0; i<files.length; i++) {    //如果是目录则放进队列
						if(files[i].isDirectory())
							queue.add(files[i]);
						else {   //如果是文件则根据文件名与目标文件名进行匹配
							tempName=files[i].getName();
							if(FileFinder.wildcardMatch(targetFileName, tempName)) {
								//匹配成功，将文件名添加到结果集
								fileList.add(files[i].getAbsoluteFile());
								//如果已经达到指定的数目，则退出循环
								if((count!=0)&&(fileList.size()>=count)) {
									return fileList;
								}
							}
						}
					}
				}
			}
		}
		return fileList;
	}

	/**
	 * 通配符匹配
	 * @param pattern 通配符模式
	 * @param str 待匹配的字符串
	 * @return 匹配成功则返回true，否则返回false
	 */
	private static boolean wildcardMatch(String pattern, String str) {
		int patternLength=pattern.length();
		int strLength=str.length();
		int strIndex=0;
		char ch;
		for(int patternIndex=0; patternIndex<patternLength; patternIndex++) {
			ch=pattern.charAt(patternIndex);
			if(ch=='*') {
				//通配符星号*表示可以匹配任意多个字符
				while(strIndex<strLength) {
					if(wildcardMatch(pattern.substring(patternIndex+1), str.substring(strIndex))) {
						return true;
					}
					strIndex++;
				}
			} else if(ch=='?') {
				//通配符问号?表示匹配任意一个字符
				strIndex++;
				if(strIndex>strLength) {
					//表示str中已经没有字符匹配?了
					return false;
				}
			}
			else {
				if((strIndex>=strLength)||(ch!=str.charAt(strIndex)))
					return false;
				strIndex++;
			}
		}
		return (strIndex==strLength);
	}

	public static void main(String[] parament) {
		String baseDIR="D:\\";     //在此目录中找文件
		String fileName="*.txt";       //找扩展名为txt的文件
		int countNumber=10;     //最多返回5个文件
		List resultList=FileFinder.findFiles(baseDIR, fileName, countNumber);
		if(resultList.size()==0) {
			System.out.println("No File Fount.");
		}
		else {
			for(int i=0; i<resultList.size(); i++) {
				System.out.println(resultList.get(i));         //显示查找结果
			}
		}
	}

}

class Queue {
	private LinkedList data=new LinkedList();

	public Queue() {

	}

	//向队列添加一个元素，只能加入到队尾
	public void add(Object obj) {
		this.data.addLast(obj);
	}

	//查看队首元素，数据还保留在队列中
	public Object peek() {
		if(data.isEmpty()) {
			System.out.println("队列中没有元素！");
			return null;
		}
		return data.getFirst();
	}

	//删除队首元素
	public boolean remove() {
		if(data.isEmpty()) {
			System.out.println("队列中没有元素！");
			return false;
		}
		data.removeFirst();
		return true;
	}

	//弹出元素，即获取队首元素并将其从队列中删除
	public Object pop() {
		if(data.isEmpty()) {
			System.out.println("队列中没有元素！");
			return null;
		}
		return data.removeFirst();
	}

	//在队列中查找元素，返回第一次出现的位置
	public int indexOf(Object obj) {
		return data.indexOf(obj);
	}

	//在队列中查找元素，返回最后一次出现的位置
	public int lastIndexOf(Object obj) {
		return data.lastIndexOf(obj);
	}

	//判断队列是否为空
	public boolean isEmpty() {
		return data.isEmpty();
	}

	//清除队列中所有元素
	public void clear() {
		data.clear();
	}
}