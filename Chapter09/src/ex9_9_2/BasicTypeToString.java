//�½�9.9.2                     �����������ַ����Ļ���ת��
package ex9_9_2;

public class BasicTypeToString {
	
	/*����ת�����ַ�����nΪ��ת��������*/
	public String int2str(int n) {
		//3�ַ���ʵ��ת��
		//return new Integer(n).toString();
		//return ""+n;
		return String.valueOf(n);
	}

	/*�ַ���ת����������strΪ��ת�����ַ���*/
	public int str2int(String str) {
		//2�ַ���ʵ��ת��
		//return new Integer(str).intValue();
		return Integer.parseInt(str);
	}
	
	/*С��ת�����ַ�����dΪ��ת����С��*/
	public String double2str(double d) {
		//3�ַ���ʵ��ת��
		//return new Double(d).toString();
		//return ""+d;
		return String.valueOf(d);
	}
	
	/*�ַ���ת����С����strΪ��ת�����ַ���*/
	public double str2double(String str) {
		//2�ַ���ʵ��ת��
		//return new Double(str).doubleValue();
		return Double.parseDouble(str);
	}
	
	/*���������������ַ����Ļ���ת�����ﲻһһ�г�������������*/
	public static void main(String[] args) {
		BasicTypeToString test=new BasicTypeToString();
		int n=156;
		String str1=test.int2str(n);
		System.out.println("test.int2str(n)="+str1);
		System.out.println("test.str2int(str1)="+test.str2int(str1));
		
		double d=12.345;
		String strD=test.double2str(d);
		System.out.println("test.double2str(d)="+strD);
		System.out.println("test.str2Double(strD)="+test.str2double(strD));
		// TODO �Զ����ɵķ������

	}

}
