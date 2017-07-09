//ÕÂ½Ú4.6.6              ÒÆÎ»ÔËËã·ûÊ¾Àı
package ex4_6_6;

public class test1 {

	public static void main(String[] args) {
		int num=-1073741836;
		int num1=-11;
		System.out.println("ÓÒÒÆ²Ù×÷£º");
		System.out.println(num+":"+Integer.toBinaryString(num)+";"+(num>>1)+":"+Integer.toBinaryString(num>>1));         //ÓÒÒÆ²Ù×÷
		System.out.println(num1+":"+Integer.toBinaryString(num1)+";"+(num1>>1)+":"+Integer.toBinaryString(num1>>1));
		System.out.println("×óÒÆ²Ù×÷£º");
		System.out.println(num+":"+Integer.toBinaryString(num)+";"+(num<<1)+":"+Integer.toBinaryString(num<<1));         //×óÒÆ²Ù×÷
		System.out.println(num1+":"+Integer.toBinaryString(num1)+";"+(num1<<1)+":"+Integer.toBinaryString(num1<<1));
		System.out.println("ÎŞ·ûºÅÓÒÒÆ²Ù×÷£º");
		System.out.println(num+":"+Integer.toBinaryString(num)+";"+(num>>>1)+":"+Integer.toBinaryString(num>>>1));         //ÎŞ·ûºÅÓÒÒÆÒÆ²Ù×÷
		System.out.println(num1+":"+Integer.toBinaryString(num1)+";"+(num1>>>1)+":"+Integer.toBinaryString(num1>>>1));

	}

}
