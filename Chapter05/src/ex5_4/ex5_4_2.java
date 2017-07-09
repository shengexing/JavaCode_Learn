//例5.4.1 计算阶乘
package ex5_4;

public class ex5_4_2 {
	/*计算n!的值，利用公式n!=n*(n-1)*(n-2)...*2*1   */
	public long getFactorial(int n) {
		//因为当n大于17时,n!的值超过了long类型的范围，会出现错误
		//因此这里限定了n必须小于等于17
		//数学上没有负数阶乘的概念，因此n必须大于等于0
		if((n<0)||(n>17)) {
			System.out.println("n的范围必须在区间[0,17]内！");
			return -1;
		} else if(n==0) {
			//0!的值为1
			return 1;
		} else {
			long result=1;
			for(;n>0;n--)
				result*=n;
			return result;
		}
	}
	
	public static void main(String[] args) {
		ex5_4_2 test=new ex5_4_2();
		System.out.println(test.getFactorial(15));
		// TODO 自动生成的方法存根

	}

}
