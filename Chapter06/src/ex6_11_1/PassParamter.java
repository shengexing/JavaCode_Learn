package ex6_11_1;

class ComplexNumber {
	int real;
	int viture;

	void setRealpart(int real) {
		this.real=real;
	}

	void setViturepart(int viture) {
		this.viture=viture;
	}

	public String toString() {
		return real+"+"+viture+"i";
	}
}

public class PassParamter {

	public PassParamter() {

	}

	public void methodA(ComplexNumber comNum) {
		comNum=new ComplexNumber();
		comNum.setRealpart(1);
	}

	public void methodB(ComplexNumber comNum) {
		comNum.setRealpart(2);
	}

	public void methodC(int num) {
		num++;
	}

	public void methodD(int num) {
		num=num+1;
	}


	public static void main(String[] args) {
		PassParamter test=new PassParamter();
		ComplexNumber comNum=new ComplexNumber();
		int num=0;
		System.out.println("comNum="+comNum.toString()+", num="+num);

		test.methodA(comNum); test.methodC(num);
		System.out.println("comNum="+comNum.toString()+", num="+num);

		test.methodB(comNum); test.methodD(num);
		System.out.println("comNum="+comNum.toString()+", num="+num);
		// TODO 自动生成的方法存根

	}

}
