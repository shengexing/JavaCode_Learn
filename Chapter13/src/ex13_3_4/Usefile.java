//�½�13.4.3                ��ʾ�ļ��Ķ���
package ex13_3_4;

import java.io.FileReader;

public class Usefile {

	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("text.txt");          //�������ļ�
			char[] c=new char[1];
			while(fr.read(c)!=-1)                       //������
				System.out.print(new String(c));
			fr.close();
		} catch(Exception e) {
			System.out.println(e);                    //����쳣
		}
	}

}
