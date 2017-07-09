//章节10.2.1			      通过两个按钮来显示在JFrame容器上的两个面板
package ex10_2_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MyJPanelTest {
	
	JFrame frame;
	JPanel panel1;
	JPanel panel2;
	
	public MyJPanelTest() {
		//创建JFrame对象，标题是“测试JPanel组件”
		frame=new JFrame("测试JPanel组件");
		//面板对象panel1
		panel1=new JPanel();
		//设置面板对象的边界对象为TitledBorder
		panel1.setBorder(new TitledBorder("panel1"));
		//在面板上增加一个按钮对象
		panel1.add(new JButton("panel1"));
		panel2=new JPanel();
		panel2.add(new JButton("panel2"));
		panel2.setBorder(new TitledBorder("panel2"));
		Container cp=frame.getContentPane();
		//设置容器的布局方式为FlowLayout
		cp.setLayout(new FlowLayout());
		//依次向容器中增加面板对象
		cp.add(panel1,BorderLayout.WEST);
		cp.add(panel2,BorderLayout.CENTER);
		frame.setSize(300,200);
		frame.show();
	}

	public static void main(String[] args) {
		new MyJPanelTest();
		// TODO 自动生成的方法存根
	}

}
