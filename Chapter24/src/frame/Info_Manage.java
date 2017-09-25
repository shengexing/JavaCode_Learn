// 章节24.03.2            实现登录模块
package frame;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Info_Manage extends Frame implements ActionListener{

	JLabel userName_label = new JLabel("用户名：");				// 使用文本创建一个标签对象
	JLabel password_label = new JLabel("密 码：");				// 使用文本创建一个标签对象
	JLabel id_label = new JLabel("身 份：");							// 使用文本创建一个标签对象
	JTextField userName_field = new JTextField();					// 创建一个文本框对象
	JPasswordField password_filed = new JPasswordField();	// 创建一个密码框对象
	JComboBox id_box = new JComboBox();						// 创建一个组合框对象
	
	JButton login_button = new JButton("登录");
	JButton cancle_button = new JButton("取消");
	
	/** 无参的构造器*/
	public Info_Manage() {
		this.setTitle("学生信息管理系统"); 			// 设置窗口标题
		this.setLayout(null); 								// 设置窗口布局管理器
		
		userName_label.setBounds(100, 40, 100, 20);		// 设置姓名标签的初始位置
		this.add(userName_label);										// 将姓名标签组件添加到容器
		userName_field.setBounds(200, 40, 100, 20);		// 设置文本框的初始位置
		this.add(userName_field);										// 将文本框组件添加到容器
		
		password_label.setBounds(100, 100, 60, 20);	// 设置密码标签的初始位置
		this.add(password_label);									// 将密码标签组件添加到容器
		password_filed.setBounds(200, 100, 80, 20);		// 设置文本框的初始位置
		this.add(password_filed);									// 将文本框组件添加到容器
		
		id_label.setBounds(100, 150, 60, 20);		// 设置身份标签的初始位置
		this.add(id_label);										// 将身份标签组件添加到容器
		id_box.setBounds(200, 150, 80, 20);		// 设置组合框的初始位置
		this.add(id_box);										// 将组合框组件添加到容器
		id_box.addItem(new String("学生")); 	 	// 给组合框添加内容
		id_box.addItem(new String("教师"));
		
		login_button.setBounds(100, 200, 60, 20);	// 设置登录按钮的初始位置
		this.add(login_button);									// 将登录按钮添加到容器
		login_button.addActionListener(this);			// 给按钮添加监听器
		
		cancle_button.setBounds(200, 200, 60, 20);	// 设置登录按钮的初始位置
		this.add(cancle_button);								// 将登录按钮添加到容器
		cancle_button.addActionListener(this);			// 给按钮添加监听器
		
		this.setVisible(true);
		this.setBounds(10, 10, 400, 250);
		
		addWindowListener(new WindowAdapter() {		// 通过内部类重写关闭窗体的方法
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == login_button) {			// 处理登录事件
			String name  = userName_field.getText();									// 将文本框中包含的文本传给字符串name
			String password = new String(password_filed.getPassword()); // 将文本框中包含的文本传给字符串password
			String id = (String)id_box.getSelectedItem();							// 将当前所选项传给字符串box
			
			if((name != null  && (name.equals("daishu"))) && 			// 判断语句
					(password != null && (password.equals("0816")))) {
				if(id.equals("学生")) {		// 选择学生身份登录
					new StudentManage();			// 调用学生信息主窗体
				} else if(id.equals("教师")) {
					new TeacherManage();			// 调用教师信息主窗体
				}
			}
		}
	}
	
	/** 主方法*/
	public static void main(String[] args) {
		new Info_Manage();			// 创建一个登录窗体的对象
	}

}
