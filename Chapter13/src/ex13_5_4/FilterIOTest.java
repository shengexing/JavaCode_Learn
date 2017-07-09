//�½�13.5.4                 ��InputStreamReader����װSystem.in��Reader���ٰ�װ��BufferedReaderʹ��(������)
package ex13_5_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilterIOTest {

	public static void main(String[] args) throws IOException {
		//����һ����������������˴���������������ļ�FilterOut.xls
		DataOutputStream filterout=new DataOutputStream(new FileOutputStream("./src//ex13_5_4//FilterOut.xls"));
		
		//����������ͬ�������͵�����
		double[] prices={11, 22, 21, 41, 23, 8, 9, 10, 29, 13};
		int[] counts={1, 2, 3, 4, 5, 6, 7, 9, 3, 4};
		String[] descs={"Java T-shirt",  "JavaDoc", "Java pin", "Java App", "Hello",
				 "Javac", "Applet", "Java jar", "JDK", "World"};
		
		//����ͬ���͵�����д��DataOutputStream��������־Ϊ���з�'\n'
		for(int i=0; i<prices.length; i++) {
			filterout.writeDouble(prices[i]);
			filterout.writeChar('\t');
			filterout.writeInt(counts[i]);
			filterout.writeChar('\t');
			filterout.writeChars(descs[i]);
			filterout.writeChar('\n');
		}
		
		//�رչ�����������������ļ�FilterOut.xlsд������
		filterout.close();
		
		//��һ��FileInputStream���Ͻ���һ��DataInputStream�������ļ�Filterout.xls�ж�������
		DataInputStream in=new DataInputStream(new FileInputStream("./src//ex13_5_4//FilterOut.xls"));
		double price;
		int unit;
		StringBuffer desc;
		double total=0.0;
		
		/*
		 * ����try����ѭ����˳����������ļ���Double�����ݣ�Int�����ݣ�Char�����ݣ�ÿ��ѭ�����ӡ���
		 */
		try {
			while(true) {            //�ļ�����ʱ��in�޷�ʶ�𣬻��׳�EOFException�쳣
				price=in.readDouble();
			    in.readChar();
			    unit=in.readInt();
			    in.readChar();
			    char chr;
			    desc=new StringBuffer(20);
			    
			    //�ж����û���ҵ��ļ�ĩβ�������ִ�У��Ѷ�����char���ݷ���StringBuffer����
			    while((chr=in.readChar())!='\n')
			    	desc.append(chr);
			    System.out.println("�㶨���� "+unit+" �� "+desc+" ������ "+price+" $");
			    total=total+unit*price;
			}
		} catch(EOFException e) {
			//�رչ��������������ٴӹ��������ļ�����
			System.err.println("�׳��쳣������");
			in.close();
		}
	}

}
