//��5.4.1 ����׳�
package ex5_4;

public class ex5_4_2 {
	/*����n!��ֵ�����ù�ʽn!=n*(n-1)*(n-2)...*2*1   */
	public long getFactorial(int n) {
		//��Ϊ��n����17ʱ,n!��ֵ������long���͵ķ�Χ������ִ���
		//��������޶���n����С�ڵ���17
		//��ѧ��û�и����׳˵ĸ�����n������ڵ���0
		if((n<0)||(n>17)) {
			System.out.println("n�ķ�Χ����������[0,17]�ڣ�");
			return -1;
		} else if(n==0) {
			//0!��ֵΪ1
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
		// TODO �Զ����ɵķ������

	}

}
