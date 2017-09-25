// 章节24.05.2            增加老师信息
package frame.teacher;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import util.OperateDB;

public class AddTeacher extends JFrame implements ActionListener {

	JLabel head_label = new JLabel("添加基本信息", JLabel.CENTER);		// 使用文本创建一个“头部”标签对象

	JLabel number_label = new JLabel("教师编号：");						// 创建一个“教师编号”标签对象
	JTextField number_field = new JTextField();							// 创建一个“教师编号”文本框对象

	JLabel name_label = new JLabel("姓名：");							// 创建一个“姓名”标签对象
	JTextField name_field = new JTextField();							// 创建一个“姓名”文本框对象

	JLabel post_label = new JLabel("职称：");								// 创建一个“职称”标签对象
	JTextField post_field = new JTextField();								// 创建一个“职称”文本框对象

	JLabel sex_label = new JLabel("性别：");								// 创建一个“性别”标签对象
	ButtonGroup sex_group = new ButtonGroup();					// 创建一个“性别”ButtonGroup组件对象
	JRadioButton boySex_radio = new JRadioButton("男");		// 创建一个“男性”单选按钮对象
	JRadioButton grilSex_radio = new JRadioButton("女");			// 创建一个“女性”单选按钮对象

	JLabel academy_label = new JLabel("学院：");						// 创建一个“学院”标签对象
	JTextField academy_field = new JTextField();						// 创建一个“学院”文本框对象

	JLabel birthday_label = new JLabel("生日：");						// 创建一个“生日”标签对象
	JTextField birthday_field = new JTextField();						// 创建一个“生日”文本框对象

	// 创建按钮对象
	JButton add_button = new JButton("添加");
	JButton reset_button = new JButton("重置");
	JButton exit_button = new JButton("退出");

	String sql = "";				// 定义SQL语句字符串

	/** 无参的构造器*/
	public AddTeacher() {
		this.setTitle("添加教师信息"); 				// 设置窗口标题
		this.setLayout(null); 								// 设置布局管理器为空

		// 设置头标签的相关属性
		head_label.setForeground(Color.red);
		head_label.setFont(new Font("宋体", Font.PLAIN, 19));
		head_label.setBounds(100, 30, 200, 40);
		this.add(head_label);

		// 设置学号标签及其文本框的相关属性
		number_label.setBounds(100, 80, 100, 20);
		this.add(number_label);
		number_field.setBounds(200, 80, 80, 20);
		this.add(number_field);

		// 设置姓名标签及其文本框的相关属性
		name_label.setBounds(100, 120	, 60, 20);
		this.add(name_label);
		name_field.setBounds(200, 120, 80, 20);
		this.add(name_field);

		// 设置性别标签及其单选按钮的相关属性
		sex_label.setBounds(100, 160, 100, 20);
		this.add(sex_label);
		boySex_radio.setSelected(true);
		boySex_radio.setBounds(200, 160, 40, 20);
		grilSex_radio.setBounds(300, 160, 40, 20);
		this.add(boySex_radio);
		this.add(grilSex_radio);
		sex_group.add(boySex_radio);
		sex_group.add(grilSex_radio);

		// 设置生日标签及其文本框的相关属性
		birthday_label.setBounds(100, 200, 80, 20);
		this.add(birthday_label);
		birthday_field.setBounds(200, 200, 80, 20);
		this.add(birthday_field);

		// 设置职称标签及其文本框的相关属性
		post_label.setBounds(100, 240, 60, 20);
		this.add(post_label);
		post_field.setBounds(200, 240, 80, 20);
		this.add(post_field);

		// 设置学院标签及其文本框的相关属性
		academy_label.setBounds(100, 280, 60, 20);
		this.add(academy_label);
		academy_field.setBounds(200, 280, 80, 20);
		this.add(academy_field);

		// 设置3个按钮的相关属性
		add_button.setBounds(80, 320, 90, 20);
		this.add(add_button);
		add_button.addActionListener(this);

		reset_button.setBounds(190, 320, 90, 20);
		this.add(reset_button);
		reset_button.addActionListener(this);

		exit_button.setBounds(300, 320, 90, 20);
		this.add(exit_button);
		exit_button.addActionListener(this);

		// 设置主窗体的相关属性
		this.setBounds(10, 10, 500, 400);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}

	/** 处理按钮的动作事件*/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();			// 获取监听事件源
		
		// 处理“添加”事件
		if(source == add_button) {
			String number = number_field.getText(), 		// 将“学号”文本框中包含的文本传给字符串number
					name = name_field.getText(), 				// 将“姓名”文本框中包含的文本传给字符串name
					birthday = birthday_field.getText(), 	// 将“生日”文本框中包含的文本传给字符串birthday
					post = post_field.getText(), 				// 将“班级”文本框中包含的文本传给字符串post
					academy = academy_field.getText(), 	// 将“学院”文本框中包含的文本传给字符串academy
					sex = "女";											// 返回“性别”单选按钮的值，默认为“女”
			if(boySex_radio.isSelected())
				sex = "男";
			
			// 检索出ID等于number的学生的所有信息
			sql = "SELECT * FROM teacher WHERE number='" + number + "'";
			
			try {
				Connection conn = OperateDB.getMySQLConnection("school_schema", "root", "11235813");		// 获取数据库连接
				Statement stmt = conn.createStatement();				// 提交查询
				ResultSet rs = stmt.executeQuery(sql);					// 取得查询结果
				
				if(rs.next())		// 判断结果是否存在
					JOptionPane.showMessageDialog(null, "该学生已经存在！");		// 通过showMessageDialog()方法打印信息
				else {
					sql = "INSERT INTO teacher values('" + number + "', '" + name + "', '"
							 + post + "', '" + sex + "', '" + academy + "', '" + birthday + "')";		// 插入一组数据
					int line = stmt.executeUpdate(sql);			// 对数据库进行更新
					
					if(line > 0)
						JOptionPane.showMessageDialog(null, "添加成功！");
					else
						JOptionPane.showMessageDialog(null, "添加失败！");
				}
			} catch(Exception e1) {
				
			}
		}
		
		// 处理“重置”事件
		if(source == reset_button) {
			number_field.setText(null);
			name_field.setText(null);
			post_field.setText(null);
			academy_field.setText(null);
			birthday_field.setText(null);
		}
		
		// 处理“”事件
		if(source == exit_button)
			setVisible(false);

	}
	
	/** 主方法*/
	public static void main(String[] args) {

	}
	
}
