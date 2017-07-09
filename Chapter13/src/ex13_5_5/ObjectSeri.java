//�½�13.5.5                  ���л������ʹ��
package ex13_5_5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectSeri {

	public static void main(String[] args) {
		try {
			//�����ļ���������󣬸ö���ָ���Ѷ�������д�������ָĿ¼�е�ObjectSeriOut.txt�ļ���
			FileOutputStream out=new FileOutputStream(".\\src\\ex13_5_5\\ObjectSeriOut.txt");
			
			//�����������������������Ĳ������ļ�����������
			ObjectOutputStream sOut=new ObjectOutputStream(out);
			sOut.writeObject(new String("current time is:"));         //����������д����
			sOut.writeObject(new Date());                //����������д���󣬸ö�����Date����
			sOut.writeInt(1000);                    //����������д���󣬸ö�����int����
			
			//������������еĶ���ȫ���Ƴ�������д���ļ�
			sOut.flush();
			out.close();               //�رն�����������ͷ���ռ�õ���Դ
			
			//�����ļ����������󣬴Ӷ������ļ�ObjectSeri.txt�ж�ȡ��������
			FileInputStream in=new FileInputStream(".\\src\\ex13_5_5\\ObjectSeriOut.txt");
			
			//����������������ͨ�������ĸ��ַ�����ȡ��������
			ObjectInputStream sIn=new ObjectInputStream(in);
			//ͨ���������������ļ�ObjectSeriOut.txt��ȡ���ֶ��󣬲������Ӧ���͵ı���
			String flag=(String)sIn.readObject();
			Date date=(Date)sIn.readObject();
			int i=(int)sIn.readInt();
			System.out.println(flag+date);
			System.out.println("int�����ݣ�"+i);
			
			sIn.close();                           //�رն������������ͷ�������ռ����Դ
			//����IOException�쳣��ClassNotFoundException�쳣
		} catch(IOException ex) {
			System.err.println("IOException happend");
		} catch(ClassNotFoundException f) {
			System.err.println("ClassNotFoundException happend");
		}
	}

}
