//�½�8.3                    �̵߳Ļ���
package ep8_03;

/**
 * �̵߳Ļ��⣬��Ҫչʾͬ���������ͬ������������
 */
public class Synchronized {
	
	static class Account {
		private double money=1000.0d;        //������Դ��Ǯ��
		
		/*��Ǯ û��ͬ������*/
		public void nonSynDeposit(double fFees) {
			System.out.println("Account nonSynDeposit begin! money="+this.money+"; fFees="+fFees);
			//��Ǯʱ�ȵȴ�300����
			System.out.println("Account nonSynDepoist sleep begin!");
			try {
				Thread.sleep(300);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Account nonSynDepoist sleep end!");
			this.money=this.money+fFees;
			System.out.println("Account nonSynDeposit end! money="+this.money);
		}
		
		/*ȡǮ û��ͬ������*/
		public void nonSynWithdraw(double fFees) {
			System.out.println("Account nonSynWithdraw begin! money="+this.money+"; fFees="+fFees);
			//ȡǮʱ�ȵȴ�400����
			System.out.println("Account nonSynWithdraw sleep begin!");
			try {
				Thread.sleep(400);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Account nonSynWithdraw sleep end!");
			this.money-=fFees;
			System.out.println("Account nonSynWithdraw end! money="+this.money);
		}
		
		/*��Ǯ ��ͬ������*/
		public synchronized void synDepoist(double fFees) {
			System.out.println("Account synDepoist begin! money="+this.money+"; fFees="+fFees);
			//��Ǯʱ�ȵȴ�300����
			System.out.println("Account synDeposit sleep begin!");
			try {
				Thread.sleep(300);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Account synDeposit sleep end!");
			this.money+=fFees;
			System.out.println("Account synDeposit end! money="+this.money);
		}
		
		/*ȡǮ ��ͬ������*/
		public synchronized void synWithdraw(double fFees) {
			System.out.println("Account synWithdraw begin! money="+this.money+"; fFess="+fFees);
			//ȡǮʱ�ȵȴ�400����
			System.out.println("Account synWithdraw sleep begin!");
			try {
				Thread.sleep(400);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Account synWithdraw sleep end!");
			this.money-=fFees;
			System.out.println("Account synWithdraw end! money="+this.money);
		}
	}
	
	static class AccessThread extends Thread {
		private Account account=null;     //�����ʵ��˺Ŷ���
		private String method="";            //�����˺ŵķ���
		
		public AccessThread(Account account, String method) {
			this.method=method;
			this.account=account;
		}
		
		public void run() {
			//�Բ�ͬ�ķ������������ò�ͬ�ķ���
			if(method.equals("nonSynDeposit")) {
				account.nonSynDeposit(500.0);
			} else if(method.equals("nonSynWithdraw")) {
				account.nonSynWithdraw(200.0);
			} else if(method.equals("synDeposit")) {
				account.synDepoist(500.0);
			} else if(method.equals("synWithdraw")) {
				account.synWithdraw(200.0);
			}
		}
	}
	
	public static void main(String[] args) {
		Account account=new Account();    //���������˺Ŷ������в�������Ը��˺�
		System.out.println("ʹ�÷�ͬ������ʱ��");
		//��ͬ��������Ǯ���߳�
		Thread threadA=new AccessThread(account, "nonSynDepoist");       //��ͬ������ȡǮ���߳�
		Thread threadB=new AccessThread(account, "nonSynWithdraw");
		threadA.start();
		threadB.start();                
		//�ȴ������߳����н���
		try {
			threadA.join();
			threadB.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		//�������ͬ������
		System.out.println();
		account=new Account();
		System.out.println("ʹ��ͬ������ʱ��");
		threadA=new AccessThread(account, "synDeposit");
		threadB=new AccessThread(account, "synWithdraw");
		threadA.start();
		threadB.start();
	}
	
}
