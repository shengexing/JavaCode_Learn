// �½�24.03.2            ʵ�ֵ�¼ģ��
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

	JLabel userName_label = new JLabel("�û�����");				// ʹ���ı�����һ����ǩ����
	JLabel password_label = new JLabel("�� �룺");				// ʹ���ı�����һ����ǩ����
	JLabel id_label = new JLabel("�� �ݣ�");							// ʹ���ı�����һ����ǩ����
	JTextField userName_field = new JTextField();					// ����һ���ı������
	JPasswordField password_filed = new JPasswordField();	// ����һ����������
	JComboBox id_box = new JComboBox();						// ����һ����Ͽ����
	
	JButton login_button = new JButton("��¼");
	JButton cancle_button = new JButton("ȡ��");
	
	/** �޲εĹ�����*/
	public Info_Manage() {
		this.setTitle("ѧ����Ϣ����ϵͳ"); 			// ���ô��ڱ���
		this.setLayout(null); 								// ���ô��ڲ��ֹ�����
		
		userName_label.setBounds(100, 40, 100, 20);		// ����������ǩ�ĳ�ʼλ��
		this.add(userName_label);										// ��������ǩ�����ӵ�����
		userName_field.setBounds(200, 40, 100, 20);		// �����ı���ĳ�ʼλ��
		this.add(userName_field);										// ���ı��������ӵ�����
		
		password_label.setBounds(100, 100, 60, 20);	// ���������ǩ�ĳ�ʼλ��
		this.add(password_label);									// �������ǩ�����ӵ�����
		password_filed.setBounds(200, 100, 80, 20);		// �����ı���ĳ�ʼλ��
		this.add(password_filed);									// ���ı��������ӵ�����
		
		id_label.setBounds(100, 150, 60, 20);		// ������ݱ�ǩ�ĳ�ʼλ��
		this.add(id_label);										// ����ݱ�ǩ�����ӵ�����
		id_box.setBounds(200, 150, 80, 20);		// ������Ͽ�ĳ�ʼλ��
		this.add(id_box);										// ����Ͽ������ӵ�����
		id_box.addItem(new String("ѧ��")); 	 	// ����Ͽ��������
		id_box.addItem(new String("��ʦ"));
		
		login_button.setBounds(100, 200, 60, 20);	// ���õ�¼��ť�ĳ�ʼλ��
		this.add(login_button);									// ����¼��ť��ӵ�����
		login_button.addActionListener(this);			// ����ť��Ӽ�����
		
		cancle_button.setBounds(200, 200, 60, 20);	// ���õ�¼��ť�ĳ�ʼλ��
		this.add(cancle_button);								// ����¼��ť��ӵ�����
		cancle_button.addActionListener(this);			// ����ť��Ӽ�����
		
		this.setVisible(true);
		this.setBounds(10, 10, 400, 250);
		
		addWindowListener(new WindowAdapter() {		// ͨ���ڲ�����д�رմ���ķ���
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == login_button) {			// �����¼�¼�
			String name  = userName_field.getText();									// ���ı����а������ı������ַ���name
			String password = new String(password_filed.getPassword()); // ���ı����а������ı������ַ���password
			String id = (String)id_box.getSelectedItem();							// ����ǰ��ѡ����ַ���box
			
			if((name != null  && (name.equals("daishu"))) && 			// �ж����
					(password != null && (password.equals("0816")))) {
				if(id.equals("ѧ��")) {		// ѡ��ѧ����ݵ�¼
					new StudentManage();			// ����ѧ����Ϣ������
				} else if(id.equals("��ʦ")) {
					new TeacherManage();			// ���ý�ʦ��Ϣ������
				}
			}
		}
	}
	
	/** ������*/
	public static void main(String[] args) {
		new Info_Manage();			// ����һ����¼����Ķ���
	}

}
