//�½�10.2.1						��ʾ��δ���һ������
package ex10_2_1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameDemo1 {
	
	//����һ��GUI���沢��ʾ�������̰߳�ȫ�Ŀ��ǣ�Ӧ�ô��¼��ַ��̵߳��ô˷���
	private static void createAndShowGUI() {
		//���������ó������д���
		JFrame frame=new JFrame("FrameDemo");              //����һ�����б���Ĵ������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //���õ��رմ���ʱ�˳�����
		JLabel emptyLabel=new JLabel("");                        //���������ı����ݵı�ǩ����
		emptyLabel.setPreferredSize(new Dimension(175,100));          //���ñ�ǩ����ѡ��С
		frame.getContentPane().add(emptyLabel,BorderLayout.CENTER);        //����ǩ��ӵ���������м�
		//��ʾ����
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		//Ϊ�¼��ַ��߳�Ԥ��һ����������������ʾ�������GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void  run() {
				createAndShowGUI();
			}
		});
	}

}
