//章节10.2.1						演示如何创建一个容器
package ex10_2_1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameDemo1 {
	
	//创建一个GUI界面并显示。出于线程安全的考虑，应该从事件分发线程调用此方法
	private static void createAndShowGUI() {
		//创建并设置程序运行窗口
		JFrame frame=new JFrame("FrameDemo");              //创建一个带有标题的窗体对象
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //设置当关闭窗体时退出程序
		JLabel emptyLabel=new JLabel("");                        //创建不带文本内容的标签对象
		emptyLabel.setPreferredSize(new Dimension(175,100));          //设置标签的首选大小
		frame.getContentPane().add(emptyLabel,BorderLayout.CENTER);        //将标签添加到内容面板中间
		//显示窗口
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		//为事件分发线程预定一个工作，创建并显示本程序的GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void  run() {
				createAndShowGUI();
			}
		});
	}

}
