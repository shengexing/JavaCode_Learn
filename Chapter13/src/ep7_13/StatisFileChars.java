//章节7.13                   使用StreamTokenizer统计文件的字符数
package ep7_13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * 使用StreamTokenizer来统计文件中的字符数
 */
public class StatisFileChars {
	/**
	 * 统计字符数
	 * @param fileName 文件名
	 * @return 字符数
	 */
	public static long statis(String fileName) {
		FileReader fileReader=null;
		try {
			fileReader=new FileReader(fileName);       //创建分析给定字符流的标记生成器
			StreamTokenizer st=new StreamTokenizer(new BufferedReader(fileReader));
			//ordinaryChar方法指定字符参数在此标记生成器中是“普通”字符
			//下面指定单引号、双引号和注释符号是普通字符
			st.ordinaryChar('\'');
			st.ordinaryChar('\"');
			st.ordinaryChar('/');
			String s;
			int numberSum=0 ,wordSum=0 ,symbolSum=0 ,total=0;
			//nextToken方法读取下一个Token，TT_EOF指定已读到流末尾的常量
			while(st.nextToken()!=StreamTokenizer.TT_EOF) {
				//在调用nextToken方法之后，ttype字段将包含刚读取的标记的类型
				switch(st.ttype) {
				//TT_EOF只是已读到行末尾的常量
				case StreamTokenizer.TT_EOF: break;
				//TT_NUMBER只是已读到一个数字标记的常量，如果当前标记是一个数字，nual字段字段将包含该数字的值
				case StreamTokenizer.TT_NUMBER: s=String.valueOf(st.nval); numberSum+=s.length(); break;
				//TT_WORD指示已读到一个文字标记的常量，如果当标记是一个文字标记，sval字段包含一个给出该文字标记的字符的字符串
				case StreamTokenizer.TT_WORD: s=st.sval; wordSum+=s.length(); break;
				//如果以上3种类型都不是，则为英文的标点符号
				default: s=String.valueOf((char)st.ttype); symbolSum+=s.length();
				}
			}
			System.out.println("sum of number = "+numberSum);
			System.out.println("sum of word = "+wordSum);
			System.out.println("sum of symbol = "+symbolSum);
			total=symbolSum+numberSum+wordSum;
			System.out.println("Total = "+total);
			return total;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if(fileReader!=null) {
				try {
					fileReader.close();
				} catch(IOException e1) {
					
				}
			}
		}
	}

	public static void main(String[] args) {
		String fileName="./src/ep7_13/StatisFileChars.java";
		StatisFileChars.statis(fileName);
	}

}
