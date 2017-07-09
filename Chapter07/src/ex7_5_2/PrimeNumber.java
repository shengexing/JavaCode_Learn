//�½�7.5.2           ��ָ����Χ�ڵ�����
package ex7_5_2;

import java.util.Arrays;

public class PrimeNumber {

	//��ʾrange��Χ�ڵ�����
	public void showPrimeNumber(int range) {
		boolean[] primes=this.sieve(range);
		int number=0;
		if(primes!=null) {
			int size=primes.length;
			System.out.println("��Χ��"+range+"�ڵ����������У�");
			for(int i=1;i<size;i++) {
				if(primes[i]) {
					System.out.print(i+" ");
					//ÿ���ʮ����������
					//number�ȼ�1���ٸ�10��ģ���㣬�������Ϊ0������
					if(++number%10==0)
						System.out.println();
				}
			}
			System.out.println();
		}
		System.out.println("һ����"+number+"��");
	}
	
	//ɸѡ��������
	private boolean[] sieve(int range) {
		if(range<=0) {
			System.out.println("�������ķ�Χrange�������0��");
			return null;
		}
		
		//��һ�����������ʾ�Ƿ�Ϊ����������±�ֵΪ��������ô���±�ֵ��Ӧ������Ԫ�ص�ֵΪtrue
		//��2��������isPrime[2]=true����Ϊ������±��Ǵ�0��ʼ�ģ����������½��������СΪrang+1
		boolean[] isPrime=new boolean[range+1];
		isPrime[1]=false;     //1��������
		
		//��Arrays��fill�����������±��2��range+1֮���Ԫ�ص�ֵ����Ϊtrue
		Arrays.fill(isPrime, 2,range+1,true);
		
		int n=(int)Math.sqrt(range);       //Math��sqrt���������󿪷�
		for(int i=1;i<n;i++) {
			if(isPrime[i]) {
				//���i����������ôi�ı�����������
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
