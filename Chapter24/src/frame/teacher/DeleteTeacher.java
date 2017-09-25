// �½�24.05.3            ɾ����ʦ��Ϣ
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import util.OperateDB;

public class DeleteTeacher extends JFrame implements ActionListener {

	JLabel  head_label = new JLabel("ɾ��������Ϣ", JLabel.CENTER);		// ʹ���ı�����һ����ͷ������ǩ����

	JLabel number_label = new JLabel("��ʦ��ţ�");						// ����һ������ʦ��š���ǩ����
	JTextField number_field = new JTextField();						// ����һ����ѧ�š��ı������

	JLabel name_label = new JLabel("������");							// ����һ������������ǩ����
	JTextField name_field = new JTextField();							// ����һ�����������ı������

	// ������ť����
	JButton delete_button = new JButton("ɾ��");
	JButton reset_button = new JButton("����");
	JButton exit_button = new JButton("�˳�");

	String sql = "";				// ����SQL����ַ���

	/** �޲εĹ�����*/
	public DeleteTeacher() {
		this.setTitle("ɾ����ʦ��Ϣ"); 				// ���ô��ڱ���
		getContentPane().setLayout(null); 								// ���ò��ֹ�����Ϊ��

		// ����ͷ��ǩ���������
		head_label.setForeground(Color.red);
		head_label.setFont(new Font("����", Font.PLAIN, 19));
		head_label.setBounds(100, 30, 200, 40);
		getContentPane().add(head_label);

		// ����ѧ�ű�ǩ�����ı�����������
		number_label.setBounds(100, 120, 100, 20);
		getContentPane().add(number_label);
		number_field.setBounds(200, 120, 80, 20);
		getContentPane().add(number_field);

		// ����������ǩ�����ı�����������
		name_label.setBounds(100, 160	, 60, 20);
		getContentPane().add(name_label);
		name_field.setBounds(200, 160, 80, 20);
		getContentPane().add(name_field);

		// ����3����ť���������
		delete_button.setBounds(80, 320, 90, 20);
		getContentPane().add(delete_button);
		delete_button.addActionListener(this);

		reset_button.setBounds(190, 320, 90, 20);
		getContentPane().add(reset_button);
		reset_button.addActionListener(this);

		exit_button.setBounds(300, 320, 90, 20);
		getContentPane().add(exit_button);
		exit_button.addActionListener(this);

		// ������������������
		this.setBounds(10, 10, 500, 400);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	/** ����ť�Ķ����¼�*/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();			// ��ȡ�����¼�Դ

		// ����ɾ�����¼�
		if(source == delete_button) {
			String number = number_field.getText(), 		// ����ѧ�š��ı����а������ı������ַ���number
					name = name_field.getText(); 				// �����������ı����а������ı������ַ���name

			// ������ID����number��ѧ����������Ϣ
			sql = "SELECT * FROM teacher WHERE number='" + number + "'";

			try {
				Connection conn = OperateDB.getMySQLConnection("school_schema", "root", "11235813");		// ��ȡ���ݿ�����
				Statement stmt = conn.createStatement();				// �ύ��ѯ
				ResultSet rs = stmt.executeQuery(sql);					// ȡ�ò�ѯ���

				if(rs.next()) {		// �жϽ���Ƿ����
					// ɾ��ѧ��Ϊnumber��ѧ����������Ϣ
					sql = "DELETE * FROM teacher WHERE number='" + number + "'";
					int line = stmt.executeUpdate(sql);			// �����ݿ���и���

					if(line > 0)
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					else
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
				} else {
					JOptionPane.showMessageDialog(null, "���û������ڣ�");
				}

			} catch(Exception e1) {

			}
		}

		// �������á��¼�
		if(source == reset_button) {
			number_field.setText(null);
			name_field.setText(null);
		}

		// �������¼�
		if(source == exit_button)
			setVisible(false);

	}

	/** ������*/
	public static void main(String[] args) {


	}

}
