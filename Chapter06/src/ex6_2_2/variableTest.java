//章节6.2.2_5             成员变量的隐藏
package ex6_2_2;

public class variableTest {
	int intTemp=34;              //成员变量intTemp
	void Method() {
		int intTemp=24;          //局部变量intTemp
		int intValue1,intValue2;
		intValue1=intTemp;
		intValue2=this.intTemp;
		System.out.println(intValue1+"\n"+intValue2);
	}

	public static void main(String[] args) {
		variableTest Test=new variableTest();
		Test.Method();

	}

}
