//章节8.3                    线程的互斥
package ep8_03;

/**
 * 线程的互斥，主要展示同步方法与非同步方法的区别
 */
public class Synchronized {
	
	static class Account {
		private double money=1000.0d;        //共享资源，钱数
		
		/*存钱 没有同步机制*/
		public void nonSynDeposit(double fFees) {
			System.out.println("Account nonSynDeposit begin! money="+this.money+"; fFees="+fFees);
			//存钱时先等待300毫秒
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
		
		/*取钱 没有同步机制*/
		public void nonSynWithdraw(double fFees) {
			System.out.println("Account nonSynWithdraw begin! money="+this.money+"; fFees="+fFees);
			//取钱时先等待400毫秒
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
		
		/*存钱 有同步机制*/
		public synchronized void synDepoist(double fFees) {
			System.out.println("Account synDepoist begin! money="+this.money+"; fFees="+fFees);
			//存钱时先等待300毫秒
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
		
		/*取钱 有同步机制*/
		public synchronized void synWithdraw(double fFees) {
			System.out.println("Account synWithdraw begin! money="+this.money+"; fFess="+fFees);
			//取钱时先等待400毫秒
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
		private Account account=null;     //待访问的账号对象
		private String method="";            //访问账号的方法
		
		public AccessThread(Account account, String method) {
			this.method=method;
			this.account=account;
		}
		
		public void run() {
			//对不同的方法名参数调用不同的方法
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
		Account account=new Account();    //待操作的账号对象，所有操作都针对该账号
		System.out.println("使用非同步方法时：");
		//非同步方法存钱的线程
		Thread threadA=new AccessThread(account, "nonSynDepoist");       //非同步方法取钱的线程
		Thread threadB=new AccessThread(account, "nonSynWithdraw");
		threadA.start();
		threadB.start();                
		//等待两个线程运行结束
		try {
			threadA.join();
			threadB.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		//下面测试同步方法
		System.out.println();
		account=new Account();
		System.out.println("使用同步方法时：");
		threadA=new AccessThread(account, "synDeposit");
		threadB=new AccessThread(account, "synWithdraw");
		threadA.start();
		threadB.start();
	}
	
}
