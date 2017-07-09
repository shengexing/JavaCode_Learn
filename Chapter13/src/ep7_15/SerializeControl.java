//�½�7.15                         ���ƶ�������л��ͷ����л�
package ep7_15;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * ������ͨ��ʵ��Externalizable �ӿڿ��ƶ�������л��ͷ����л�
 */
public class SerializeControl{
	/**
	 * �ڲ��࣬���ڲ��Կ��ƶ�������л��ͷ����л�
	 */
	static class MyClassControl implements Externalizable {
		int serialClassInt;
		int a=3, b=4;

		public MyClassControl() {
			System.out.println("MyClass constructor!");
			this.serialClassInt=9;
		}

		public void show() {
			System.out.println("serialClassInt:"+serialClassInt+" a:"+a+" b:"+b);
		}

		//�����л������ʱ�򣬸÷����Զ�������
		public void writeExternal(ObjectOutput out) throws IOException {
			System.out.println("run writeExternal");      //���������л�ʱд������ı���
			Date d=new Date();
			out.writeObject(d);
			//ֻ���л�serialClassInt������a��b���������������л�
			out.writeInt(this.serialClassInt);
		}

		//�������л������ʱ�򣬸÷����Զ�������
		public void  readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			System.out.println("run readExternal");
			Date d=(Date) in.readObject();
			System.out.println(d);
			this.serialClassInt=in.readInt();
		}
	}

	/**
	 * ���л�����
	 */
	public static void serializable(String fileName) throws Exception {
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName));
		MyClassControl my1=new MyClassControl();
		out.writeObject(my1);
		out.close();
	}
	
	/**
	 * �����л�
	 */
	public static void deserializable(String fileName) throws Exception {
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName));
		MyClassControl my2=(MyClassControl)in.readObject();
		my2.show();
		in.close();
	}
	
	public static void main(String[] args) throws Exception {
		String fileName="./src/ep7_15/test.ser";
		SerializeControl.serializable(fileName);
		SerializeControl.deserializable(fileName);
	}

}
