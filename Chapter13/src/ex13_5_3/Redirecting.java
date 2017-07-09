//�½�13.5.3                       I/O���ݵ����ֽ��������Բ���InputStream��OutputStream�����ʵ������/����ض���
package ex13_5_3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Redirecting {

	public static void main(String[] args) throws IOException {
		//�������������FileInputStream���ļ�Redirect.java���а�װ������һ���ļ�����������
		//���Ŵ���һ����������������in���ض����׼����
		BufferedInputStream in=new BufferedInputStream(new FileInputStream("./src//ex13_5_3//Redirecting.java"));
		
		//���������׼����ض��򣬴����ļ�����������󣬲�������BufferedOutputStream��
		//PrintStream���а�װ�����õ�һ��PrintStream�����out
		PrintStream out=new PrintStream(new BufferedOutputStream(new FileOutputStream("./src//ex13_5_3//test.txt")));       //�����������
		
		//����������Ϊin��������������Redirecting.java�ļ�
		System.setIn(in);
		System.setOut(out);                 //���������test.txt�ļ�
		
		//�ӱ�׼��������ݣ���ʱ�Ƕ��ض������ļ��е�����
		BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		//ͨ���м����s���ļ�Redirecting.java�е������������ʱ��������ض�����ļ�test.txt��
		while((s=breader.readLine())!=null)
			System.out.println(s);
		out.close();                    //�ر���������ͷ���ռ�õ���Դ
	}

}
