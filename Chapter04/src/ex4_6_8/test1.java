//�½�4.6.8          ���Զ��������(�ж϶����Ƿ��ܱ�ʵ����)
package ex4_6_8;

public class test1 {
	static class Animal {
		String name;
		Animal() {
		}
	}
	
	public static void main(String[] args) {
		int num=0;
		String str=num+"";
		//           System.out.println(num instanceof String);�����﷨����
		Animal dog=new Animal();
		Animal cat=null;
		System.out.println(dog instanceof Animal);
		System.out.println(cat instanceof Animal);
	}
}