//章节4.6.8          测试对象运算符(判断对象是否能被实例化)
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
		//           System.out.println(num instanceof String);出现语法错误
		Animal dog=new Animal();
		Animal cat=null;
		System.out.println(dog instanceof Animal);
		System.out.println(cat instanceof Animal);
	}
}