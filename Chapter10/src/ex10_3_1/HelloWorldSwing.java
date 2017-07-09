//章节10.2.1			      创建一个最简单的窗体界面程序HelloWorldSwing，其标题为Hello World
package ex10_3_1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldSwing {
	
	/*创建一个GUI界面并显示*/
	private static void createAndShowGUI() {
	//创建并设置程序运行窗体
	JFrame frame=new JFrame("HelloWorldSwing");                //创建带有标题的窗体
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //设置当关闭窗体时自动关闭窗口
	//添加“Hello World”标签
	JLabel label=new JLabel("Hello World");                     //创建带有文字内容的标签对象
	frame.getContentPane().add(label);                   //将获得的标签对象添加到内容面板中
	//显示窗体
	frame.pack();              //所有组件以首选大小显示
	frame.setVisible(true);       //显示窗体
	}
	
	public static void main(String[] args) {
		//为事件分发线程预定一个工作，创建并显示本程序的GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void  run() {
				createAndShowGUI();            //创建窗体并显示
			}
		});
	}

}
