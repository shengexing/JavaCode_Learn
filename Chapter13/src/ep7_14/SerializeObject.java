//�½�7.14               ���л��ͷ����л�����
package ep7_14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import ep7_08.ReadFromFile;

/**
 * ���л��ͷ����л�����
 */
public class SerializeObject {
	//һ���ڲ��࣬���ڱ����л��ͷ����л�
	//һ��Ҫʵ��Serializable���ܹ������л��ͷ����л�
	static class MyClass implements Serializable {
		private int a,b;             //һ���ʵ�������ᱻ���л��ͷ����л�
		private transient int c;    //transientʵ���������ᱻ���л��ͷ����л�
		private static int d;       //��������ᱻ���л��ͷ����л�
		
		public MyClass() {
			
		}
		
		public MyClass(int a,int b,int c,int d) {
			this.a=a; this.b=b; this.c=c; this.d=d;
		}
		
		public String toString() {
			return this.a+" "+this.b+" "+this.c+" "+this.d;
		}
	}
	
	/**
	 * ���л������ļ�
	 */
	public static void serialize(String fileName) throws Exception {
		//����һ�������������������������ļ�
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject("Today:");               //���л�һ���ַ��������ļ�
		out.writeObject(new Date());           //���л���ǰ���ڶ����ļ�
		//���л�һ��MyClass����
		MyClass my1=new MyClass(5, 6, 7, 8);
		out.writeObject(my1);
		out.close();
	}
	
	/**
	 * ���ļ������л�������
	 */
	public static void deserialize(String fileName) throws Exception {
		//����һ�����������������ļ���ȡ����
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName)); //ע�������ʱ���밴�����л�����ʱ��˳�������������
		//��ȡ�ַ�������
		String today=(String)(in.readObject());
		System.out.println(today);
		//�����ڶ���
		Date date=(Date)(in.readObject());
		System.out.println(date.toString());
		//��MyClass���󣬲���������add����
		MyClass my1=(MyClass)(in.readObject());
		System.out.println(my1.toString());
		in.close();
		//���ָ������ʱ�򣬶����е��������Զ��Ļָ�
		//�����ϣ��ĳ�������л�����������ǰ�����transient�ؼ��֣�����������룺transient int noSer=0;
		//���Ƶģ�������е�ĳ����Ϊ��̬�������ᱻ���л�
	}
	
	public static void main(String[] args) throws Exception {
		String fileName="./src/ep7_14/test.ser";
		SerializeObject.serialize(fileName);            //ע�͵��ڶ��У�ֻ��������һ�У����ᷢ�������ͬ
		SerializeObject.deserialize(fileName);
	}
}
