//章节11.3.1                    设计用户登录界面
package ex11_3_1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LoginFrame {

	/*添加组件的方法*/
	public void addComponentsToPane(Container pane) {
		JButton buttonOK,buttonCancel;            //创建按钮对象
		JLabel labelName,labelPassword;           //创建标签对象
		JTextField textFieldName;                     //创建文本框对象
		JPasswordField textFieldPwd;               //创建密码框对象
		JPanel topPane=new JPanel();              //放置标签和文本框的面板
		topPane.setLayout(new GridBagLayout());   //设为网格包布局（GridBagLayout）
		JPanel bottomPane=new JPanel();        //放置“确定”和“取消”按钮的面板
		FlowLayout flowLayout=new FlowLayout();   //创建流动布局管理器对象
		flowLayout.setHgap(20);                      //设置流动布局中组件间水平间距
		flowLayout.setVgap(10);                       //设置流动布局中组件间垂直间距
		bottomPane.setLayout(flowLayout);
		
		//标签“账户”
		GridBagConstraints conLabelName=new GridBagConstraints();          //创建约束对象
		conLabelName.fill=GridBagConstraints.NONE;                 //组件保持自然大小
		labelName=new JLabel("账户：");                     
		conLabelName.weightx=0.2;           //设置标签水平方向上的权重
		conLabelName.gridx=0;                  //设置所在列为第一列
		conLabelName.gridy=0;                  //设置所在行为第一行
		conLabelName.anchor=GridBagConstraints.LINE_END;           //标签在单元格内向右对齐
		topPane.add(labelName,conLabelName);                       //将标签加入topPane面板中，并运用约束
		
		//账户文本框
		GridBagConstraints conTextFieldName=new GridBagConstraints();          //创建约束对象
		conTextFieldName.fill=GridBagConstraints.HORIZONTAL;           //文本框水平扩展至整个单元格
		textFieldName=new JTextField();
		conTextFieldName.weightx=0.8;
		conTextFieldName.weighty=0.5;
		conTextFieldName.gridx=1;
		conTextFieldName.gridy=0;             //第二列，第一行
		conTextFieldName.insets=new Insets(10,0,10,20);          //设置组件四周的间距
		topPane.add(textFieldName,conTextFieldName);
		
		//标签“密码”
		GridBagConstraints conLabelPassword=new GridBagConstraints();
		conLabelPassword.fill=GridBagConstraints.NONE;
		labelPassword=new JLabel("密码：");
		conLabelPassword.gridx=0;
		conLabelPassword.gridy=1;            //第一列，第二行
		conLabelPassword.anchor=GridBagConstraints.LINE_END;
		topPane.add(labelPassword,conLabelPassword);
		
		//密码框
		GridBagConstraints conTextFieldPwd=new GridBagConstraints();
		conTextFieldPwd.fill=GridBagConstraints.HORIZONTAL;
		textFieldPwd=new JPasswordField();
		conTextFieldPwd.weighty=0.5;
		conTextFieldPwd.gridx=1;
		conTextFieldPwd.gridy=1;            //第二列，第二行
		conTextFieldPwd.insets=new Insets(0,0,0,20);
		topPane.add(textFieldPwd,conTextFieldPwd);
		
		buttonOK=new JButton("确定");
		buttonCancel=new JButton("取消");
		bottomPane.add(buttonOK);
		bottomPane.add(buttonCancel);
		pane.add(topPane,BorderLayout.CENTER);
		pane.add(bottomPane,BorderLayout.PAGE_END);
	}
	
	/*创建GUI界面并显示*/
	private void createAndShowGUI() {
		//创建并设置窗口
		JFrame frame=new JFrame("LoginFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置内容面板
		addComponentsToPane(frame.getContentPane());
		
		//显示窗口
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);       //关闭粗体字显示
				new LoginFrame().createAndShowGUI();
			}
		});
		// TODO 自动生成的方法存根

	}

}
