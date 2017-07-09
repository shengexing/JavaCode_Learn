//章节7.5.2           求指定范围内的素数
package ex7_5_2;

import java.util.Arrays;

public class PrimeNumber {

	//显示range范围内的质数
	public void showPrimeNumber(int range) {
		boolean[] primes=this.sieve(range);
		int number=0;
		if(primes!=null) {
			int size=primes.length;
			System.out.println("范围在"+range+"内的质数个数有：");
			for(int i=1;i<size;i++) {
				if(primes[i]) {
					System.out.print(i+" ");
					//每输出十个质数换行
					//number先加1，再跟10做模运算，如果余数为0，则换行
					if(++number%10==0)
						System.out.println();
				}
			}
			System.out.println();
		}
		System.out.println("一共有"+number+"个");
	}
	
	//筛选法求质数
	private boolean[] sieve(int range) {
		if(range<=0) {
			System.out.println("求质数的范围range必须大于0！");
			return null;
		}
		
		//用一个布尔数组标示是否为质数，如果下标值为质数，那么该下标值对应的数组元素的值为true
		//如2是质数，isPrime[2]=true；因为数组的下标是从0开始的，所以这里新建的数组大小为rang+1
		boolean[] isPrime=new boolean[range+1];
		isPrime[1]=false;     //1不是质数
		
		//用Arrays的fill方法将数组下标从2到range+1之间的元素的值都赋为true
		Arrays.fill(isPrime, 2,range+1,true);
		
		int n=(int)Math.sqrt(range);       //Math的sqrt方法用于求开方
		for(int i=1;i<n;i++) {
			if(isPrime[i]) {
				//如果i是质数，那么i的倍数不是质数
				for(int j=2*i;j<=range;j+=i)
					isPrime[j]=false;
			}
		}
		return isPrime;
	}
	
	public static void main(String[] args) {
		int range=200;
		PrimeNumber test=new PrimeNumber();
		test.showPrimeNumber(range);
	}
}
