// �½�24.05.1            ʵ�ֽ�ʦ��Ϣ������
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

	JMenuBar teacher_bar = new JMenuBar();			// ����һ���˵�������
	JMenu info_menu = new JMenu("��Ϣ");				// ����һ���˵���Ϊ����Ϣ���Ĳ˵�����
	JMenu grade_menu = new JMenu("�ɼ�");			// ����һ���˵���Ϊ���ɼ����Ĳ˵�����
	JMenu query_menu = new JMenu("��ѯ");			// ����һ���˵���Ϊ����ѯ���Ĳ˵�����
	JMenu other_meun = new JMenu("����");			// ����һ���˵���Ϊ���������Ĳ˵�����

	JMenuItem addInfo_item = new JMenuItem("������Ϣ");			    // ����һ�����ֱ�ǩΪ��������Ϣ���Ĳ˵������
	JMenuItem deleteInfo_item = new JMenuItem("ɾ����Ϣ");			// ����һ�����ֱ�ǩΪ��ɾ����Ϣ���Ĳ˵������
	JMenuItem updateInfo_item = new JMenuItem("�޸���Ϣ");			// ����һ�����ֱ�ǩΪ���޸���Ϣ���Ĳ˵������

	JMenuItem addGrade_item = new JMenuItem("¼��ɼ�");		// ����һ�����ֱ�ǩΪ��¼��ɼ����Ĳ˵������
	JMenuItem deleteGrade_item = new JMenuItem("ɾ���ɼ�");			// ����һ�����ֱ�ǩΪ��ɾ���ɼ����Ĳ˵������
	JMenuItem updateGrade_item = new JMenuItem("�޸ĳɼ�");			// ����һ�����ֱ�ǩΪ���޸ĳɼ����Ĳ˵������

	JMenuItem basicQuery_item = new JMenuItem("������Ϣ��ѯ");			// ����һ�����ֱ�ǩΪ��������Ϣ��ѯ���Ĳ˵������

	JMenuItem exitOther_item = new JMenuItem("�˳�");				// ����һ�����ֱ�ǩΪ���˳����Ĳ˵������

	/** �޲εĹ�����*/
	public TeacherManage() {
		this.setTitle("��ʦ������Ϣ");					// ���ô��ڱ���
		this.setLayout(new CardLayout());		// ���ô��ڲ��ֹ�����
		this.setJMenuBar(teacher_bar);				// ���˵��������ӵ�����

		teacher_bar.add(info_menu);			// 	����Ϣ�˵���ӵ��˵���
		teacher_bar.add(grade_menu);			// ����ѯ�˵���ӵ��˵���
		teacher_bar.add(query_menu);			// ����ѯ�˵���ӵ��˵���
		teacher_bar.add(other_meun);			// �������˵���ӵ��˵���

		info_menu.add(addInfo_item);			// ��������Ϣ�˵�����ӵ���Ϣ�˵�
		info_menu.add(deleteInfo_item);		// ��ɾ����Ϣ�˵�����ӵ���Ϣ�˵�
		info_menu.add(updateInfo_item);		// ���޸���Ϣ�˵�����ӵ���Ϣ�˵�

		addInfo_item.addActionListener(this);			// ��������Ϣ�˵�����Ӽ�����
		deleteInfo_item.addActionListener(this);		// ��ɾ����Ϣ�˵�����Ӽ�����
		updateInfo_item.addActionListener(this);		// ���޸���Ϣ�˵�����Ӽ�����

		grade_menu.add(addGrade_item);			// �����ӳɼ��˵�����ӵ��ɼ��˵�
		grade_menu.add(deleteGrade_item);			// ��ɾ���ɼ��˵�����ӵ��ɼ��˵�
		grade_menu.add(updateGrade_item);		// ���޸ĳɼ��˵�����ӵ��ɼ��˵�

		addGrade_item.addActionListener(this);			// �����ӳɼ��˵�����Ӽ�����
		deleteGrade_item.addActionListener(this);		// ��ɾ���ɼ��˵�����Ӽ�����
		updateGrade_item.addActionListener(this);		// ���޸ĳɼ��˵�����Ӽ�����

		query_menu.add(basicQuery_item);		// ��������Ϣ��ѯ�˵�����ӵ���ѯ�˵�

		query_menu.addActionListener(this);				// ����ѯ�˵���Ӽ�����
		basicQuery_item.addActionListener(this);			// ��������Ϣ��ѯ�˵�����Ӽ�����

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
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();		// ��ȡ�����¼�Դ

		// ���������Ϣ���¼�
		if(source == addInfo_item)
			new AddTeacher();			// ����������

		// ����ɾ����Ϣ���¼�
		if(source == deleteInfo_item)
			new DeleteTeacher();		// ����������

		// �����޸���Ϣ���¼�
		if(source == updateInfo_item)
			new UpdateTeacher();		// ����������

		// ������ӳɼ����¼�
		if(source == addGrade_item)
			new AddGrade();			// ����������

		// ����ɾ���ɼ����¼�
		if(source == deleteGrade_item)
			new DeleteGrade();		// ����������

		// �����޸ĳɼ����¼�
		if(source == updateGrade_item)
			new UpdateGrade();		// ����������

		// ����������Ϣ��ѯ���¼�
		if(source == basicQuery_item)
			new TeacherSet();				// ����������

		// �����˳����¼�
		if(source == exitOther_item)
			new UsingExit().setVisible(true); // ����������

	}

	/** ������*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
