//���Ƴ��������ʵ��
package ex5_4;

public class ex5_4_1 {
	/*Ŀ������*/
	public static int TARGET_NUMBER=10;
	
	/*ͨ��if�������͵ݹ鷽����n��ֵ�𲽱��TARGET_NUMBER*/
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
	
	/*ͨ��forѭ����佫n��ֵ�𲽱��TARGET_NUMBER*/
	public void forstatement(int n) {
		for(;n>TARGET_NUMBER;n--) {
			System.out.print(n+" ");
		}
		for(;n<TARGET_NUMBER;n++) {
			System.out.print(n+" ");
		}
		System.out.println(n);
	}
	
	/*ͨ��whileѭ����佫n��ֵ�𲽱��TARGET_NUMBER*/
	public void whilestatement(int n) {
		while(n>TARGET_NUMBER)
			System.out.print(n-- +" ");
		while(n<TARGET_NUMBER)
			System.out.print(n++ +" ");
		System.out.println(n);
	}
	
	/*ͨ��do-whileѭ����佫n��ֵ�𲽱��TARGET_NUMBER*/
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
	
	/*switch-caseѡ�����ʵ��*/
	public void switchcasestatement(int n) {
		switch(n) {
		case 10:
			System.out.println("n=10"); break;
		case 9:
			System.out.println("n=9"); break;
		case 8:
			System.out.println("n=8"); break;
		default:
			System.out.println("n!=8��n!=9��n!=10"); break;
		}
	}
	
	public static void main(String[] args) {
		ex5_4_1 test=new ex5_4_1();
		int n=0;
		System.out.println("ifstatement�����������");
		test.ifstatement(n);
		System.out.println("forstatement�����������");
		test.forstatement(n);
		System.out.println("whilestatement�����������");
		test.whilestatement(n);
		System.out.println("dowhilestatement�����������");
		test.dowhilestatement(n);
		System.out.println("switchcasestatement�����������");
		test.switchcasestatement(n);
	}
	}
