// �½�24.04.8            �˳�ϵͳ����
package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UsingExit extends JFrame implements ActionListener {

	JLabel exit_label = new JLabel("�˳����棺");		// ʹ���ı�����һ����ǩ����
	JButton exit_button = new JButton("�˳�");			// ������ť����
	JButton cancle_button = new JButton("ȡ��");

	/** �޲εĹ�����*/
	public UsingExit() {
		this.setTitle("�˳�����"); 		// ���ô��ڱ���
		this.setLayout(null);				// ���ô��ڲ��ֹ�����

		exit_label.setForeground(Color.black);							// ���ñ�ǩ��ǰ��ɫ
		exit_label.setFont(new Font("����", Font.PLAIN, 19));  // ���ñ�ǩ������
		exit_label.setBounds(100, 40, 200, 40);						// ���ñ�ǩ�ĳ�ʼλ��
		this.add(exit_label);														// ����ǩ��ӵ�����

		exit_button.setBounds(80, 100, 90, 20);		// �����˳���ť�ĳ�ʼλ��
		this.add(exit_button);									// ���˳���ť��ӵ�����
		exit_button.addActionListener(this);				// ����ť��Ӽ�����

		cancle_button.setBounds(190, 100, 90, 20);		// �����˳���ť�ĳ�ʼλ��
		this.add(cancle_button);									// ���˳���ť��ӵ�����
		cancle_button.addActionListener(this);				// ����ť��Ӽ�����

		// ������������������
		this.setBounds(10, 10, 400, 250);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}


	/** ������ť�ļ�������*/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();				// ��ȡ�����¼�Դ
		
		// �����˳����¼�
		if(source == exit_button)
			System.exit(0);
	
		// ����ȡ�����¼�
		if(source == cancle_button)
			setVisible(false);
	}

	/** ������*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
