//�½�10.2.1			      ͨ��������ť����ʾ��JFrame�����ϵ��������
package ex10_2_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MyJPanelTest {
	
	JFrame frame;
	JPanel panel1;
	JPanel panel2;
	
	public MyJPanelTest() {
		//����JFrame���󣬱����ǡ�����JPanel�����
		frame=new JFrame("����JPanel���");
		//������panel1
		panel1=new JPanel();
		//����������ı߽����ΪTitledBorder
		panel1.setBorder(new TitledBorder("panel1"));
		//�����������һ����ť����
		panel1.add(new JButton("panel1"));
		panel2=new JPanel();
		panel2.add(new JButton("panel2"));
		panel2.setBorder(new TitledBorder("panel2"));
		Container cp=frame.getContentPane();
		//���������Ĳ��ַ�ʽΪFlowLayout
		cp.setLayout(new FlowLayout());
		//����������������������
		cp.add(panel1,BorderLayout.WEST);
		cp.add(panel2,BorderLayout.CENTER);
		frame.setSize(300,200);
		frame.show();
	}

	public static void main(String[] args) {
		new MyJPanelTest();
		// TODO �Զ����ɵķ������
	}

}
