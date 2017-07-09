//�½�11.3.1                    ����û���¼����
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

	/*�������ķ���*/
	public void addComponentsToPane(Container pane) {
		JButton buttonOK,buttonCancel;            //������ť����
		JLabel labelName,labelPassword;           //������ǩ����
		JTextField textFieldName;                     //�����ı������
		JPasswordField textFieldPwd;               //������������
		JPanel topPane=new JPanel();              //���ñ�ǩ���ı�������
		topPane.setLayout(new GridBagLayout());   //��Ϊ��������֣�GridBagLayout��
		JPanel bottomPane=new JPanel();        //���á�ȷ�����͡�ȡ������ť�����
		FlowLayout flowLayout=new FlowLayout();   //�����������ֹ���������
		flowLayout.setHgap(20);                      //�������������������ˮƽ���
		flowLayout.setVgap(10);                       //������������������䴹ֱ���
		bottomPane.setLayout(flowLayout);
		
		//��ǩ���˻���
		GridBagConstraints conLabelName=new GridBagConstraints();          //����Լ������
		conLabelName.fill=GridBagConstraints.NONE;                 //���������Ȼ��С
		labelName=new JLabel("�˻���");                     
		conLabelName.weightx=0.2;           //���ñ�ǩˮƽ�����ϵ�Ȩ��
		conLabelName.gridx=0;                  //����������Ϊ��һ��
		conLabelName.gridy=0;                  //����������Ϊ��һ��
		conLabelName.anchor=GridBagConstraints.LINE_END;           //��ǩ�ڵ�Ԫ�������Ҷ���
		topPane.add(labelName,conLabelName);                       //����ǩ����topPane����У�������Լ��
		
		//�˻��ı���
		GridBagConstraints conTextFieldName=new GridBagConstraints();          //����Լ������
		conTextFieldName.fill=GridBagConstraints.HORIZONTAL;           //�ı���ˮƽ��չ��������Ԫ��
		textFieldName=new JTextField();
		conTextFieldName.weightx=0.8;
		conTextFieldName.weighty=0.5;
		conTextFieldName.gridx=1;
		conTextFieldName.gridy=0;             //�ڶ��У���һ��
		conTextFieldName.insets=new Insets(10,0,10,20);          //����������ܵļ��
		topPane.add(textFieldName,conTextFieldName);
		
		//��ǩ�����롱
		GridBagConstraints conLabelPassword=new GridBagConstraints();
		conLabelPassword.fill=GridBagConstraints.NONE;
		labelPassword=new JLabel("���룺");
		conLabelPassword.gridx=0;
		conLabelPassword.gridy=1;            //��һ�У��ڶ���
		conLabelPassword.anchor=GridBagConstraints.LINE_END;
		topPane.add(labelPassword,conLabelPassword);
		
		//�����
		GridBagConstraints conTextFieldPwd=new GridBagConstraints();
		conTextFieldPwd.fill=GridBagConstraints.HORIZONTAL;
		textFieldPwd=new JPasswordField();
		conTextFieldPwd.weighty=0.5;
		conTextFieldPwd.gridx=1;
		conTextFieldPwd.gridy=1;            //�ڶ��У��ڶ���
		conTextFieldPwd.insets=new Insets(0,0,0,20);
		topPane.add(textFieldPwd,conTextFieldPwd);
		
		buttonOK=new JButton("ȷ��");
		buttonCancel=new JButton("ȡ��");
		bottomPane.add(buttonOK);
		bottomPane.add(buttonCancel);
		pane.add(topPane,BorderLayout.CENTER);
		pane.add(bottomPane,BorderLayout.PAGE_END);
	}
	
	/*����GUI���沢��ʾ*/
	private void createAndShowGUI() {
		//���������ô���
		JFrame frame=new JFrame("LoginFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�����������
		addComponentsToPane(frame.getContentPane());
		
		//��ʾ����
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);       //�رմ�������ʾ
				new LoginFrame().createAndShowGUI();
			}
		});
		// TODO �Զ����ɵķ������

	}

}
