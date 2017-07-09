//章节13.5.4                 用InputStreamReader来包装System.in成Reader，再包装成BufferedReader使用(过滤流)
package ex13_5_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilterIOTest {

	public static void main(String[] args) throws IOException {
		//创建一个过滤输出流，过滤处理后的数据输出到文件FilterOut.xls
		DataOutputStream filterout=new DataOutputStream(new FileOutputStream("./src//ex13_5_4//FilterOut.xls"));
		
		//创建三个不同数据类型的数组
		double[] prices={11, 22, 21, 41, 23, 8, 9, 10, 29, 13};
		int[] counts={1, 2, 3, 4, 5, 6, 7, 9, 3, 4};
		String[] descs={"Java T-shirt",  "JavaDoc", "Java pin", "Java App", "Hello",
				 "Javac", "Applet", "Java jar", "JDK", "World"};
		
		//将不同类型的数据写入DataOutputStream，结束标志为换行符'\n'
		for(int i=0; i<prices.length; i++) {
			filterout.writeDouble(prices[i]);
			filterout.writeChar('\t');
			filterout.writeInt(counts[i]);
			filterout.writeChar('\t');
			filterout.writeChars(descs[i]);
			filterout.writeChar('\n');
		}
		
		//关闭过滤输出流，不再向文件FilterOut.xls写入数据
		filterout.close();
		
		//在一个FileInputStream流上建立一个DataInputStream流，从文件Filterout.xls中读出数据
		DataInputStream in=new DataInputStream(new FileInputStream("./src//ex13_5_4//FilterOut.xls"));
		double price;
		int unit;
		StringBuffer desc;
		double total=0.0;
		
		/*
		 * 下面try区块循环且顺序读出存入文件的Double型数据，Int型数据，Char型数据，每次循环则打印结果
		 */
		try {
			while(true) {            //文件结束时，in无法识别，会抛出EOFException异常
				price=in.readDouble();
			    in.readChar();
			    unit=in.readInt();
			    in.readChar();
			    char chr;
			    desc=new StringBuffer(20);
			    
			    //判断如果没有找到文件末尾，则继续执行，把读到的char数据放入StringBuffer对象
			    while((chr=in.readChar())!='\n')
			    	desc.append(chr);
			    System.out.println("你定制了 "+unit+" 个 "+desc+" 单价是 "+price+" $");
			    total=total+unit*price;
			}
		} catch(EOFException e) {
			//关闭过滤输入流，不再从过滤输入文件数据
			System.err.println("抛出异常结束！");
			in.close();
		}
	}

}
