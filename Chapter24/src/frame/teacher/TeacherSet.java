// �½�24.05.8            ��ѯ��ʦ��Ϣ����
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

public class TeacherSet extends JFrame implements ActionListener {

	JLabel head_label = new JLabel("��ѯ������Ϣ", JLabel.CENTER);		// ʹ���ı�����һ����ͷ������ǩ����

	JLabel number_label = new JLabel("�������ʦ��ţ�");						// ����һ����ѧ�š���ǩ����
	JTextField number_field = new JTextField();						// ����һ����ѧ�š��ı������

	JLabel name_label = new JLabel("������");							// ����һ������������ǩ����
	JTextField name_field = new JTextField();							// ����һ�����������ı������

	JLabel post_label = new JLabel("ְ�ƣ�");								// ����һ����ְ�ơ���ǩ����
	JTextField post_field = new JTextField();								// ����һ����ְ�ơ��ı������

	JLabel sex_label = new JLabel("�Ա�");								// ����һ�����Ա𡱱�ǩ����
	ButtonGroup sex_group = new ButtonGroup();					// ����һ�����Ա�ButtonGroup�������
	JRadioButton boySex_radio = new JRadioButton("��");		// ����һ�������ԡ���ѡ��ť����
	JRadioButton grilSex_radio = new JRadioButton("Ů");			// ����һ����Ů�ԡ���ѡ��ť����

	JLabel academy_label = new JLabel("ѧԺ��");						// ����һ����ѧԺ����ǩ����
	JTextField academy_field = new JTextField();						// ����һ����ѧԺ���ı������

	JLabel birthday_label = new JLabel("���գ�");						// ����һ�������ա���ǩ����
	JTextField birthday_field = new JTextField();						// ����һ�������ա��ı������

	// ������ť����
	JButton query_button = new JButton("��ѯ");
	JButton reset_button = new JButton("����");
	JButton exit_button = new JButton("�˳�");

	String sql = "";				// ����SQL����ַ���

	/** �޲εĹ�����*/
	public TeacherSet() {
		this.setTitle("��ѯ��ʦ��Ϣ"); 				// ���ô��ڱ���
		this.setLayout(null); 								// ���ò��ֹ�����Ϊ��

		// ����ͷ��ǩ���������
		head_label.setForeground(Color.red);
		head_label.setFont(new Font("����", Font.PLAIN, 19));
		head_label.setBounds(100, 30, 200, 40);
		this.add(head_label);

		// ����ѧ�ű�ǩ�����ı�����������
		number_label.setBounds(100, 80, 100, 20);
		this.add(number_label);
		number_field.setBounds(200, 80, 80, 20);
		this.add(number_field);

		// ����������ǩ�����ı�����������
		name_label.setBounds(100, 160	, 60, 20);
		this.add(name_label);
		name_field.setBounds(200, 160, 80, 20);
		name_field.setEditable(false); 					// �����ı����ܱ��༭
		this.add(name_field);

		// �����Ա��ǩ���䵥ѡ��ť���������
		sex_label.setBounds(100, 200, 100, 20);
		this.add(sex_label);
		boySex_radio.setBounds(200, 200, 40, 20);
		grilSex_radio.setBounds(300, 200, 40, 20);
		boySex_radio.setEnabled(false); 				// ���ð�ť���ܱ�ѡ��
		grilSex_radio.setEnabled(false); 				// ���ð�ť���ܱ�ѡ��
		this.add(boySex_radio);
		this.add(grilSex_radio);
		sex_group.add(boySex_radio);
		sex_group.add(grilSex_radio);

		// �������ձ�ǩ�����ı�����������
		birthday_label.setBounds(100, 240, 80, 20);
		this.add(birthday_label);
		birthday_field.setBounds(200, 240, 80, 20);
		birthday_field.setEditable(false); 				// �����ı����ܱ��༭
		this.add(birthday_field);

		// ����ְ�Ʊ�ǩ�����ı�����������
		post_label.setBounds(100, 280, 60, 20);
		this.add(post_label);
		post_field.setBounds(200, 280, 80, 20);
		post_field.setEditable(false); 				// �����ı����ܱ��༭
		this.add(post_field);

		// ����ѧԺ��ǩ�����ı�����������
		academy_label.setBounds(100, 320, 60, 20);
		this.add(academy_label);
		academy_field.setBounds(200, 320, 80, 20);
		academy_field.setEditable(false); 				// �����ı����ܱ��༭
		this.add(academy_field);

		// ����3����ť���������
		query_button.setBounds(80, 120, 90, 20);
		this.add(query_button);
		query_button.addActionListener(this);

		reset_button.setBounds(190, 120, 90, 20);
		this.add(reset_button);
		reset_button.addActionListener(this);

		exit_button.setBounds(300, 120, 90, 20);
		this.add(exit_button);
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

		// ������ѯ���¼�
		if(source == query_button) {
			String number = number_field.getText(), 		// ����ѧ�š��ı����а������ı������ַ���number
					name = name_field.getText(), 				// �����������ı����а������ı������ַ���name
					birthday = birthday_field.getText(), 	// �������ա��ı����а������ı������ַ���birthday
							post = post_field.getText(), 				// �����༶���ı����а������ı������ַ���post
					academy = academy_field.getText(), 	// ����ѧԺ���ı����а������ı������ַ���academy
					sex = "Ů";											// ���ء��Ա𡱵�ѡ��ť��ֵ��Ĭ��Ϊ��Ů��
			if(boySex_radio.isSelected())
				sex = "��";

			// ������ID����number��ѧ����������Ϣ
			sql = "SELECT * FROM teacher WHERE number='" + number + "'";

			try {
				Connection conn = OperateDB.getMySQLConnection("school_schema", "root", "11235813");		// ��ȡ���ݿ�����
				Statement stmt = conn.createStatement();				// �ύ��ѯ
				ResultSet rs = stmt.executeQuery(sql);					// ȡ�ò�ѯ���

				if(rs.next()) {		// �жϽ���Ƿ����
					// ��ȡ��ǰ����ָ���е�ֵ���������ص��ַ������󸳸�name
					name = rs.getString("name");
					name_field.setText(name);

					// ��ȡ��ǰ����ָ���е�ֵ���������ص��ַ������󸳸�sclass
					post = rs.getString("post");
					post_field.setText(post);

					// ��ȡ��ǰ����ָ���е�ֵ���������ص��ַ������󸳸�sex
					sex = rs.getString("sex");
					if("��".equals(sex))
						boySex_radio.setSelected(true);
					else
						grilSex_radio.setSelected(true);

					// ��ȡ��ǰ����ָ���е�ֵ���������ص��ַ������󸳸�academy
					academy = rs.getString("academy");
					academy_field.setText(academy);

					// ��ȡ��ǰ����ָ���е�ֵ���������ص��ַ������󸳸�birthday
					birthday = rs.getString("birthday");
					birthday_field.setText(birthday);

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
			post_field.setText(null);
			academy_field.setText(null);
			birthday_field.setText(null);
		}

		// �������¼�
		if(source == exit_button)
			setVisible(false);

	}

	/** ������*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
