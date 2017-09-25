// 章节24.05.1            实现教师信息主界面
package frame;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import frame.student.AddStudent;
import frame.student.DeleteStudent;
import frame.student.GradeSet;
import frame.student.StudentSet;
import frame.student.UpdateStudent;
import frame.teacher.AddGrade;
import frame.teacher.AddTeacher;
import frame.teacher.DeleteGrade;
import frame.teacher.DeleteTeacher;
import frame.teacher.TeacherSet;
import frame.teacher.UpdateGrade;
import frame.teacher.UpdateTeacher;

public class TeacherManage extends JFrame implements ActionListener {

	JMenuBar teacher_bar = new JMenuBar();			// 创建一个菜单栏对象
	JMenu info_menu = new JMenu("信息");				// 创建一个菜单名为“信息”的菜单对象
	JMenu grade_menu = new JMenu("成绩");			// 创建一个菜单名为“成绩”的菜单对象
	JMenu query_menu = new JMenu("查询");			// 创建一个菜单名为“查询”的菜单对象
	JMenu other_meun = new JMenu("其他");			// 创建一个菜单名为“其他”的菜单对象

	JMenuItem addInfo_item = new JMenuItem("增加信息");			    // 创建一个文字标签为“增加信息”的菜单项对象
	JMenuItem deleteInfo_item = new JMenuItem("删除信息");			// 创建一个文字标签为“删除信息”的菜单项对象
	JMenuItem updateInfo_item = new JMenuItem("修改信息");			// 创建一个文字标签为“修改信息”的菜单项对象

	JMenuItem addGrade_item = new JMenuItem("录入成绩");		// 创建一个文字标签为“录入成绩”的菜单项对象
	JMenuItem deleteGrade_item = new JMenuItem("删除成绩");			// 创建一个文字标签为“删除成绩”的菜单项对象
	JMenuItem updateGrade_item = new JMenuItem("修改成绩");			// 创建一个文字标签为“修改成绩”的菜单项对象

	JMenuItem basicQuery_item = new JMenuItem("基本信息查询");			// 创建一个文字标签为“基本信息查询”的菜单项对象

	JMenuItem exitOther_item = new JMenuItem("退出");				// 创建一个文字标签为“退出”的菜单项对象

	/** 无参的构造器*/
	public TeacherManage() {
		this.setTitle("教师基本信息");					// 设置窗口标题
		this.setLayout(new CardLayout());		// 设置窗口布局管理器
		this.setJMenuBar(teacher_bar);				// 将菜单栏组件添加到容器

		teacher_bar.add(info_menu);			// 	将信息菜单添加到菜单栏
		teacher_bar.add(grade_menu);			// 将查询菜单添加到菜单栏
		teacher_bar.add(query_menu);			// 将查询菜单添加到菜单栏
		teacher_bar.add(other_meun);			// 将其他菜单添加到菜单栏

		info_menu.add(addInfo_item);			// 将增加信息菜单项添加到信息菜单
		info_menu.add(deleteInfo_item);		// 将删除信息菜单项添加到信息菜单
		info_menu.add(updateInfo_item);		// 将修改信息菜单项添加到信息菜单

		addInfo_item.addActionListener(this);			// 给增加信息菜单项添加监听器
		deleteInfo_item.addActionListener(this);		// 给删除信息菜单项添加监听器
		updateInfo_item.addActionListener(this);		// 给修改信息菜单项添加监听器

		grade_menu.add(addGrade_item);			// 将增加成绩菜单项添加到成绩菜单
		grade_menu.add(deleteGrade_item);			// 将删除成绩菜单项添加到成绩菜单
		grade_menu.add(updateGrade_item);		// 将修改成绩菜单项添加到成绩菜单

		addGrade_item.addActionListener(this);			// 给增加成绩菜单项添加监听器
		deleteGrade_item.addActionListener(this);		// 给删除成绩菜单项添加监听器
		updateGrade_item.addActionListener(this);		// 给修改成绩菜单项添加监听器

		query_menu.add(basicQuery_item);		// 将基本信息查询菜单项添加到查询菜单

		query_menu.addActionListener(this);				// 给查询菜单添加监听器
		basicQuery_item.addActionListener(this);			// 给基本信息查询菜单项添加监听器

		other_meun.add(exitOther_item);			// 将退出菜单项添加到其他菜单

		other_meun.addActionListener(this);					// 给其他菜单添加监听器
		exitOther_item.addActionListener(this);			// 给退出菜单项添加监听器

		this.setBounds(10, 10, 500, 400);		// 设置窗口尺寸大小
		this.setVisible(true);							// 设置窗口的可见性

		// 通过内部类重写关闭窗体方法
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	/** 监听菜单栏选项的监听方法*/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();		// 获取动作事件源

		// 处理“添加信息”事件
		if(source == addInfo_item)
			new AddTeacher();			// 调用主窗体

		// 处理“删除信息”事件
		if(source == deleteInfo_item)
			new DeleteTeacher();		// 调用主窗体

		// 处理“修改信息”事件
		if(source == updateInfo_item)
			new UpdateTeacher();		// 调用主窗体

		// 处理“添加成绩”事件
		if(source == addGrade_item)
			new AddGrade();			// 调用主窗体

		// 处理“删除成绩”事件
		if(source == deleteGrade_item)
			new DeleteGrade();		// 调用主窗体

		// 处理“修改成绩”事件
		if(source == updateGrade_item)
			new UpdateGrade();		// 调用主窗体

		// 处理“基本信息查询”事件
		if(source == basicQuery_item)
			new TeacherSet();				// 调用主窗体

		// 处理“退出”事件
		if(source == exitOther_item)
			new UsingExit().setVisible(true); // 调用主窗体

	}

	/** 主方法*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
