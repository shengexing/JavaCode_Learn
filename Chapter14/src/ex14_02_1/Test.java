//章节14.2.1                   继承Thread类创建线程
package ex14_02_1;

public class Test {

	public static void main(String[] args) {
		//获得主线程的引用
		Thread t=Thread.currentThread();
		//获得主线程信息
		System.out.println("主线程："+t);
		//改变主线程的信息
		t.setName("My Thread");
		//主线程的新信息
		System.out.println("改变名称后："+t);
		//线程内容
		try {
			for(int i=0; i<5; i++) {
				System.out.println(i);
				//每隔3秒打印一个数
				t.sleep(3000);
			}
		} catch(Exception e) {
			System.out.println("发现异常 有错误");
		}
		
	}

}
