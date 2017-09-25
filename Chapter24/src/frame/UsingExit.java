// 章节24.04.8            退出系统界面
package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UsingExit extends JFrame implements ActionListener {

	JLabel exit_label = new JLabel("退出界面：");		// 使用文本创建一个标签对象
	JButton exit_button = new JButton("退出");			// 创建按钮对象
	JButton cancle_button = new JButton("取消");

	/** 无参的构造器*/
	public UsingExit() {
		this.setTitle("退出界面"); 		// 设置窗口标题
		this.setLayout(null);				// 设置窗口布局管理器

		exit_label.setForeground(Color.black);							// 设置标签的前景色
		exit_label.setFont(new Font("宋体", Font.PLAIN, 19));  // 设置标签的字体
		exit_label.setBounds(100, 40, 200, 40);						// 设置标签的初始位置
		this.add(exit_label);														// 将标签添加到容器

		exit_button.setBounds(80, 100, 90, 20);		// 设置退出按钮的初始位置
		this.add(exit_button);									// 将退出按钮添加到容器
		exit_button.addActionListener(this);				// 给按钮添加监听器

		cancle_button.setBounds(190, 100, 90, 20);		// 设置退出按钮的初始位置
		this.add(cancle_button);									// 将退出按钮添加到容器
		cancle_button.addActionListener(this);				// 给按钮添加监听器

		// 设置主窗体的相关属性
		this.setBounds(10, 10, 400, 250);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}


	/** 监听按钮的监听方法*/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();				// 获取动作事件源
		
		// 处理“退出”事件
		if(source == exit_button)
			System.exit(0);
	
		// 处理“取消”事件
		if(source == cancle_button)
			setVisible(false);
	}

	/** 主方法*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
