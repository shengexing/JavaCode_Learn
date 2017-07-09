//�½�9.9.1            ʹ���ַ�����String
package ex9_9_1;

public class UsingString {
	
	/*�������ַ���*/
	public static void testFindStr(String str) {
		//�������ַ��������ȳ��ֵ�λ�ã���������ڣ����ظ���
		System.out.println("str.indexOf(\"is\")="+str.indexOf("is"));
		//���Ը�indexOf�������ò�����ָ�����ҵ���ʼλ��
		System.out.println("str.indexOf(\"is\",4)="+str.indexOf("is",4));
		//�������ַ������ַ����е������ֵ�λ�ã���������ڣ����ظ���
		System.out.println("str.lastIndexOf(\"is\")="+str.lastIndexOf("is"));
		//���Ը�lastIndexOf�������ò�����ָ�����ҵĽ���λ��
		System.out.println("str.lastIndexOf(\"is\",1)="+str.lastIndexOf("is",1));
	}

	/*��ȡ���ַ���*/
	public static void testSubStr(String str) {
		//substring������ȡ�ַ���������ָ����ȡ����ʼλ�ú���ֹλ��
		//Ĭ����ֹλ��Ϊ�ַ���ĩβ
		System.out.println("str.substring(2)="+str.substring(2));
		System.out.println("str.substring(2,9)="+str.substring(2,9));
	}
	
	/*�滻�ַ���*/
	public static void testReplaceStr(String str) {
		//���ַ����е�ĳ���ַ��滻����һ���ַ�
		System.out.println("str.replace('i','I')="+str.replace('i', 'I'));
		//���ַ����е�ĳ�����ַ����滻����һ���ַ���
		System.out.println("str.replaceAll(\"is\",\"IS\")="+str.replaceAll("is", "IS"));
		//���ַ����е�ĳ�����ַ����ĵ�һ���滻����һ���ַ���
		System.out.println("str.replaceFirst(\"is\",\"IS\")="+str.replaceFirst("is", "IS"));
	}
	
	/*ת����Сд*/
	public static void testToUpperOrLower(String str) {
		//���ַ�ȫ����ɴ�д��ʽ
		System.out.println("str.toUpperCase()="+str.toUpperCase());
		//���ַ�ȫ����ɴ�д��ʽ
		System.out.println("str.toLowerCase()="+str.toLowerCase());
	}
	
	/*��ȡ�ַ�����ĳ��λ���ϵ��ַ�*/
	public static void testChatAt(String str) {
		//�����ַ�����ĳ��λ���ϵ��ַ�
		System.out.println("str.charAt(2)="+str.charAt(2));
		//���ַ���ת�����ַ����飬���鳤��Ϊ�ַ����ĳ���
		System.out.println(str.toCharArray());
	}
	
	/*�Ƚ��ַ�����С*/
	public static void testCompareStr(String str) {
		//compareTo�����Ƚ������ַ����Ĵ�С���ȽϹ����ֵ���ǰ�ߴ󣬷������������ߴ󣬷��ظ���
		System.out.println("str.compareTo(\"I am in Beijing\")="+str.compareTo("I am in Beijing"));
		//compareToIgnoreCase�ڱȽ�ʱ�����ַ����Ĵ�Сд����Ϊͬһ�ַ��Ĵ�Сд���
		System.out.println("str.compareToIgnoreCase(\"I am in Beijing\")="+str.compareToIgnoreCase("I am in Beijing"));
	}
	
	/*�Ƚ��ַ����Ƿ����*/
	public static void testEqualsStr(String str) {
		//�Ƚ��ַ�����ֵ�Ƿ����
		System.out.println("str.equals(\"I am in Beijing\")="+str.equals("I am in Beijing"));
		//�Ƚ��ַ�����ֵʱ�����ִ�Сд
		System.out.println("str.equalsIgnoreCase(\"I am in Beijing\")="+str.equalsIgnoreCase("I am in Beijing"));
		//�ж��ַ����Ƿ���ĳ�����ַ�����ʼ
		System.out.println("str.startsWith(\"Th\")="+str.startsWith("Th"));
		//�ж��ַ����Ƿ���ĳ�����ַ�������
		System.out.println("str.startsWith(\"t!\")="+str.startsWith("t!"));
	}
	
	/*String��Ҳ�ɸ����������ʽ�����ַ����������ַ���ƥ�䡢�滻�ͷֽ�*/
	
	public static void testRegex() {
		String str="aab         aaa   bb     ab";
		String pattern1="^[a-zA-Z| ]*$";            //���������ʽ��ʾ����������Ӣ����ĸ���߿ո�
		System.out.println("���������ʽƥ��ɹ���"+str.matches(pattern1));
		System.out.println(str.replaceAll("\\s{2,}"," "));           //���ַ����е������ո񻻳�һ���ո�
		System.out.println(str.replaceFirst("\\s{2,}"," "));           //���ַ����е�һ�������ո񻻳�һ���ո�
		
		//�ֽ��ַ��������ո�ֽ⣬��������Ŀո���һ���ո�
		String[] ss=str.split("\\s{1,}");
		System.out.println("���������ʽ���ո�ֽ⣺");
		for(int i=0;i<ss.length;i++)
			System.out.println(ss[i]);
		
		//���Ʒֽ��������С
		System.out.println("���������ʽ���ո�ֽ⣬ָ�����ֽ����Ϊ3��");
		ss=str.split("\\s{1,}",3);
		for(int i=0;i<ss.length;i++)
			System.out.println(ss[i]);
	}
	
	
	public static void main(String[] args) {
		String str="This is a String object!";
		System.out.println("str��ֵ��"+str);
		
		UsingString.testFindStr(str);
		System.out.println();
		UsingString.testSubStr(str);
		System.out.println();
		UsingString.testReplaceStr(str);
		System.out.println();
		UsingString.testToUpperOrLower(str);
		System.out.println();
		UsingString.testChatAt(str);
		System.out.println();
		UsingString.testCompareStr(str);
		System.out.println();
		UsingString.testEqualsStr(str);
		System.out.println();
		UsingString.testRegex();
		System.out.println();
		// TODO �Զ����ɵķ������
	}

}