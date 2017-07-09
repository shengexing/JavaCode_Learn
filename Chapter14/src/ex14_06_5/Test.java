//章节14.6.5          中断线程示例
package ex14_06_5;

public class Test {

	public static void main(String[] args) {
		String messages[]= {
				"消息1", "消息2", "消息3", "消息4"
		};
		for(int i=0; i<messages.length; i++) {
			try {
				Thread.sleep(3000);       //执行到此暂停3秒
			} catch(InterruptedException e) {
				return;        //没有更多消息了，中断线程
			}
			System.out.println(messages[i]);
		}
	}

}
