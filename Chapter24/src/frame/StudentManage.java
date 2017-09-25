// �½�24.04.2            ʵ��ѧ����Ϣ������
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

class StudentManage extends JFrame implements ActionListener {

	JMenuBar student_bar = new JMenuBar();			// ����һ���˵�������
	JMenu info_menu = new JMenu("��Ϣ");				// ����һ���˵���Ϊ����Ϣ���Ĳ˵�����
	JMenu query_menu = new JMenu("��ѯ");			// ����һ���˵���Ϊ����ѯ���Ĳ˵�����
	JMenu other_meun = new JMenu("����");			// ����һ���˵���Ϊ���������Ĳ˵�����
	
	JMenuItem addInfo_item = new JMenuItem("������Ϣ");			    // ����һ�����ֱ�ǩΪ��������Ϣ���Ĳ˵������
	JMenuItem deleteInfo_item = new JMenuItem("ɾ����Ϣ");			// ����һ�����ֱ�ǩΪ��ɾ����Ϣ���Ĳ˵������
	JMenuItem updateInfo_item = new JMenuItem("�޸���Ϣ");			// ����һ�����ֱ�ǩΪ���޸���Ϣ���Ĳ˵������
	
	JMenuItem basicQuery_item = new JMenuItem("������Ϣ��ѯ");		// ����һ�����ֱ�ǩΪ��������Ϣ���Ĳ˵������
	JMenuItem gradeQuery_item = new JMenuItem("�ɼ���ѯ");			// ����һ�����ֱ�ǩΪ���ɼ���ѯ���Ĳ˵������
	
	JMenuItem exitOther_item = new JMenuItem("�˳�");				// ����һ�����ֱ�ǩΪ���˳����Ĳ˵������
	
	/** �޲εĹ�����*/
	public StudentManage() {
		this.setTitle("ѧ��������Ϣ");					// ���ô��ڱ���
		this.setLayout(new CardLayout());		// ���ô��ڲ��ֹ�����
		this.setJMenuBar(student_bar);				// ���˵��������ӵ�����
		
		student_bar.add(info_menu);			// 	����Ϣ�˵���ӵ��˵���
		student_bar.add(query_menu);			// ����ѯ�˵���ӵ��˵���
		student_bar.add(other_meun);			// �������˵���ӵ��˵���
		
		info_menu.add(addInfo_item);			// ��������Ϣ�˵�����ӵ���Ϣ�˵�
		info_menu.add(deleteInfo_item);		// ��ɾ����Ϣ�˵�����ӵ���Ϣ�˵�
		info_menu.add(updateInfo_item);		// ���޸���Ϣ�˵�����ӵ���Ϣ�˵�
		
		addInfo_item.addActionListener(this);			// ��������Ϣ�˵�����Ӽ�����
		deleteInfo_item.addActionListener(this);		// ��ɾ����Ϣ�˵�����Ӽ�����
		updateInfo_item.addActionListener(this);		// ���޸���Ϣ�˵�����Ӽ�����
		
		query_menu.add(basicQuery_item);		// ��������Ϣ��ѯ�˵�����ӵ���ѯ�˵�
		query_menu.add(gradeQuery_item);		// ���ɼ���ѯ�˵�����ӵ���ѯ�˵�
		
		query_menu.addActionListener(this);				// ����ѯ�˵���Ӽ�����
		basicQuery_item.addActionListener(this);			// ��������Ϣ��ѯ�˵�����Ӽ�����
		gradeQuery_item.addActionListener(this);			// ���ɼ���ѯ�˵�����Ӽ�����
		
		other_meun.add(exitOther_item);			// ���˳��˵�����ӵ������˵�
		
		other_meun.addActionListener(this);					// �������˵���Ӽ�����
		exitOther_item.addActionListener(this);			// ���˳��˵�����Ӽ�����
		
		this.setBounds(10, 10, 500, 400);		// ���ô��ڳߴ��С
		this.setVisible(true);							// ���ô��ڵĿɼ���
		
		// ͨ���ڲ�����д�رմ��巽��
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	/** �����˵���ѡ��ļ�������*/
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();		// ��ȡ�����¼�Դ
		
		// ���������Ϣ���¼�
		if(source == addInfo_item)
			new AddStudent();			// ����������
		
		// ����ɾ����Ϣ���¼�
		if(source == deleteInfo_item)
			new DeleteStudent();		// ����������
		
		// �����޸���Ϣ���¼�
		if(source == updateInfo_item)
			new UpdateStudent();		// ����������
		
		// ����������Ϣ��ѯ���¼�
		if(source == basicQuery_item)
			new StudentSet();				// ����������
		
		// �����ɼ���ѯ���¼�
		if(source == gradeQuery_item)
			new GradeSet();				// ����������
		
		// �����˳����¼�
		if(source == exitOther_item)
			new UsingExit().setVisible(true); // ����������
		
	}
	
	/** ������*/
	public static void main(String[] args) {
		new StudentManage();			// ����һ������

	}

}
