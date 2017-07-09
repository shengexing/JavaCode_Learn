//习题5.6.2    打印9x9乘法表
package ex5_6;

public class ex5_6_2 {
	
	private void printMultByFor() {
		for(int i=1;i<10;i++) {
			for(int j=1;j<=i;j++)
				System.out.print(j+"x"+i+"="+(i*j)+"  ");
			System.out.println();
		}
	}
	
	private void printMultByWhile() {
		int i=1,j=1;
		while(i<10) {
			while(j<=i) {
				System.out.print(j+"x"+i+"="+(i*(j++))+"  ");
			}
			System.out.println(); i++; j=1;
		}
	}
	
	public static void main(String[] args) {
		ex5_6_2 test=new ex5_6_2();
		test.printMultByFor();
		test.printMultByWhile();
	}

}
