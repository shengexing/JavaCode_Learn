//控制程序的流程实例
package ex5_4;

public class ex5_4_1 {
	/*目标数字*/
	public static int TARGET_NUMBER=10;
	
	/*通过if条件语句和递归方法将n的值逐步变成TARGET_NUMBER*/
	public void ifstatement(int n) {
		System.out.print(n+" ");
		if(n==TARGET_NUMBER) {
			System.out.println();
		} else if(n<TARGET_NUMBER) {
			this.ifstatement(++n);
		} else {
			this.ifstatement(--n);
		}
	}
	
	/*通过for循环语句将n的值逐步变成TARGET_NUMBER*/
	public void forstatement(int n) {
		for(;n>TARGET_NUMBER;n--) {
			System.out.print(n+" ");
		}
		for(;n<TARGET_NUMBER;n++) {
			System.out.print(n+" ");
		}
		System.out.println(n);
	}
	
	/*通过while循环语句将n的值逐步变成TARGET_NUMBER*/
	public void whilestatement(int n) {
		while(n>TARGET_NUMBER)
			System.out.print(n-- +" ");
		while(n<TARGET_NUMBER)
			System.out.print(n++ +" ");
		System.out.println(n);
	}
	
	/*通过do-while循环语句将n的值逐步变成TARGET_NUMBER*/
	public void dowhilestatement(int n) {
		if(n>TARGET_NUMBER) {
			do {
				System.out.print(n-- +" ");
			} while(n>TARGET_NUMBER);
		} else if(n<TARGET_NUMBER) {
			do {
				System.out.print(n++ +" ");
			} while(n<TARGET_NUMBER);
		}
		System.out.println(n);
	}
	
	/*switch-case选择语句实例*/
	public void switchcasestatement(int n) {
		switch(n) {
		case 10:
			System.out.println("n=10"); break;
		case 9:
			System.out.println("n=9"); break;
		case 8:
			System.out.println("n=8"); break;
		default:
			System.out.println("n!=8且n!=9且n!=10"); break;
		}
	}
	
	public static void main(String[] args) {
		ex5_4_1 test=new ex5_4_1();
		int n=0;
		System.out.println("ifstatement方法的输出：");
		test.ifstatement(n);
		System.out.println("forstatement方法的输出：");
		test.forstatement(n);
		System.out.println("whilestatement方法的输出：");
		test.whilestatement(n);
		System.out.println("dowhilestatement方法的输出：");
		test.dowhilestatement(n);
		System.out.println("switchcasestatement方法的输出：");
		test.switchcasestatement(n);
	}
	}
