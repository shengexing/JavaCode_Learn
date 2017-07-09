//�½�7.13                   ʹ��StreamTokenizerͳ���ļ����ַ���
package ep7_13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * ʹ��StreamTokenizer��ͳ���ļ��е��ַ���
 */
public class StatisFileChars {
	/**
	 * ͳ���ַ���
	 * @param fileName �ļ���
	 * @return �ַ���
	 */
	public static long statis(String fileName) {
		FileReader fileReader=null;
		try {
			fileReader=new FileReader(fileName);       //�������������ַ����ı��������
			StreamTokenizer st=new StreamTokenizer(new BufferedReader(fileReader));
			//ordinaryChar����ָ���ַ������ڴ˱�����������ǡ���ͨ���ַ�
			//����ָ�������š�˫���ź�ע�ͷ�������ͨ�ַ�
			st.ordinaryChar('\'');
			st.ordinaryChar('\"');
			st.ordinaryChar('/');
			String s;
			int numberSum=0 ,wordSum=0 ,symbolSum=0 ,total=0;
			//nextToken������ȡ��һ��Token��TT_EOFָ���Ѷ�����ĩβ�ĳ���
			while(st.nextToken()!=StreamTokenizer.TT_EOF) {
				//�ڵ���nextToken����֮��ttype�ֶν������ն�ȡ�ı�ǵ�����
				switch(st.ttype) {
				//TT_EOFֻ���Ѷ�����ĩβ�ĳ���
				case StreamTokenizer.TT_EOF: break;
				//TT_NUMBERֻ���Ѷ���һ�����ֱ�ǵĳ����������ǰ�����һ�����֣�nual�ֶ��ֶν����������ֵ�ֵ
				case StreamTokenizer.TT_NUMBER: s=String.valueOf(st.nval); numberSum+=s.length(); break;
				//TT_WORDָʾ�Ѷ���һ�����ֱ�ǵĳ���������������һ�����ֱ�ǣ�sval�ֶΰ���һ�����������ֱ�ǵ��ַ����ַ���
				case StreamTokenizer.TT_WORD: s=st.sval; wordSum+=s.length(); break;
				//�������3�����Ͷ����ǣ���ΪӢ�ĵı�����
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
