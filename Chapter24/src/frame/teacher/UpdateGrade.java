// �½�24.05.7            �޸ĳɼ�
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

public class UpdateGrade extends JFrame implements ActionListener {

	JLabel head_label = new JLabel("�޸�ѧ���ɼ���Ϣ", JLabel.CENTER);		// ʹ���ı�����һ����ͷ������ǩ����

	JLabel number_label = new JLabel("ѧ�ţ�");						// ����һ����ѧ�š���ǩ����
	JTextField number_field = new JTextField();						// ����һ����ѧ�š��ı������

	JLabel name_label = new JLabel("������");							// ����һ������������ǩ����
	JTextField name_field = new JTextField();							// ����һ�����������ı������

	JLabel class_label = new JLabel("�༶��");							// ����һ�����༶����ǩ����
	JTextField class_field = new JTextField();								// ����һ�����༶���ı������

	JLabel sex_label = new JLabel("�Ա�");								// ����һ�����Ա𡱱�ǩ����
	ButtonGroup sex_group = new ButtonGroup();					// ����һ�����Ա�ButtonGroup�������
	JRadioButton boySex_radio = new JRadioButton("��");		// ����һ�������ԡ���ѡ��ť����
	JRadioButton grilSex_radio = new JRadioButton("Ů");			// ����һ����Ů�ԡ���ѡ��ť����

	JLabel chinese_label = new JLabel("���ģ�");						// ����һ�������ġ���ǩ����
	JTextField chinese_field = new JTextField();						// ����һ�������ġ��ı������

	JLabel math_label = new JLabel("��ѧ��");						// ����һ������ѧ����ǩ����
	JTextField math_field = new JTextField();						// ����һ������ѧ���ı������

	// ������ť����
	JButton update_button = new JButton("�޸�");
	JButton reset_button = new JButton("����");
	JButton exit_button = new JButton("�˳�");

	String sql = "";				// ����SQL����ַ���

	/** �޲εĹ�����*/
	public UpdateGrade() {
		this.setTitle("�޸�ѧ���ɼ�"); 				// ���ô��ڱ���
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
		name_label.setBounds(100, 120	, 60, 20);
		this.add(name_label);
		name_field.setBounds(200, 120, 80, 20);
		name_field.setEditable(false);
		this.add(name_field);

		// �����Ա��ǩ���䵥ѡ��ť���������
		sex_label.setBounds(100, 160, 100, 20);
		this.add(sex_label);
		boySex_radio.setBounds(200, 160, 40, 20);
		grilSex_radio.setBounds(300, 160, 40, 20);
		boySex_radio.setEnabled(false);
		grilSex_radio.setEnabled(false);
		this.add(boySex_radio);
		this.add(grilSex_radio);
		sex_group.add(boySex_radio);
		sex_group.add(grilSex_radio);

		// �������ı�ǩ�����ı�����������
		chinese_label.setBounds(100, 200, 80, 20);
		this.add(chinese_label);
		chinese_field.setBounds(200, 200, 80, 20);
		this.add(chinese_field);

		// ���ð༶��ǩ�����ı�����������
		class_label.setBounds(100, 240, 60, 20);
		this.add(class_label);
		class_field.setBounds(200, 240, 80, 20);
		class_field.setEditable(false);
		this.add(class_field);

		// ������ѧ��ǩ�����ı�����������
		math_label.setBounds(100, 280, 60, 20);
		this.add(math_label);
		math_field.setBounds(200, 280, 80, 20);
		this.add(math_field);
		
		// ����3����ť���������
		update_button.setBounds(80, 320, 90, 20);
		this.add(update_button);
		update_button.addActionListener(this);

		reset_button.setBounds(190, 320, 90, 20);
		this.add(reset_button);
		reset_button.addActionListener(this);

		exit_button.setBounds(300, 320, 90, 20);
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

	/** ������ť�Ķ����¼�*/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();			// ��ȡ�����¼�Դ

		// �������޸ġ��¼�
		if(source == update_button) {
			String number = number_field.getText(), 		// ����ѧ�š��ı����а������ı������ַ���number
					name = name_field.getText(), 				// �����������ı����а������ı������ַ���name
					chinese = chinese_field.getText(), 	// �������ա��ı����а������ı������ַ���birthday
					sclass = class_field.getText(), 				// �����༶���ı����а������ı������ַ���sclass
					math = math_field.getText(), 	// ����ѧԺ���ı����а������ı������ַ���academy
					sex = "Ů";											// ���ء��Ա𡱵�ѡ��ť��ֵ��Ĭ��Ϊ��Ů��
			if(boySex_radio.isSelected())
				sex = "��";

			// ������ID����number��ѧ����������Ϣ
			sql = "SELECT * FROM grade WHERE number='" + number + "'";

			try {
				Connection conn = OperateDB.getMySQLConnection("school_schema", "root", "11235813");		// ��ȡ���ݿ�����
				Statement stmt = conn.createStatement();				// �ύ��ѯ
				ResultSet rs = stmt.executeQuery(sql);					// ȡ�ò�ѯ���

				if(rs.next()) {		// �жϽ���Ƿ����
					sql = "UPDATE grade set chinese=''" + chinese + "', math=''" + math + "' WHERE number=" + number;		// �޸�һ������
					int line = stmt.executeUpdate(sql);			// �����ݿ���и���

					if(line > 0)
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
					else
						JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
				} else {
					JOptionPane.showMessageDialog(null, "��ѧ�������ڣ�");		// ͨ��showMessageDialog()������ӡ��Ϣ
				}
			} catch(Exception e1) {

			}
		}

		// ���������á��¼�
		if(source == reset_button) {
			number_field.setText(null);
			name_field.setText(null);
			class_field.setText(null);
			chinese_field.setText(null);
			math_field.setText(null);
		}

		// ���������¼�
		if(source == exit_button)
			setVisible(false);

	}

	/** ������*/
	public static void main(String[] args) {

	}

}