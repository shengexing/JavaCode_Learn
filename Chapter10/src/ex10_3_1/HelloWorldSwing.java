//�½�10.2.1			      ����һ����򵥵Ĵ���������HelloWorldSwing�������ΪHello World
package ex10_3_1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldSwing {
	
	/*����һ��GUI���沢��ʾ*/
	private static void createAndShowGUI() {
	//���������ó������д���
	JFrame frame=new JFrame("HelloWorldSwing");                //�������б���Ĵ���
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //���õ��رմ���ʱ�Զ��رմ���
	//��ӡ�Hello World����ǩ
	JLabel label=new JLabel("Hello World");                     //���������������ݵı�ǩ����
	frame.getContentPane().add(label);                   //����õı�ǩ������ӵ����������
	//��ʾ����
	frame.pack();              //�����������ѡ��С��ʾ
	frame.setVisible(true);       //��ʾ����
	}
	
	public static void main(String[] args) {
		//Ϊ�¼��ַ��߳�Ԥ��һ����������������ʾ�������GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void  run() {
				createAndShowGUI();            //�������岢��ʾ
			}
		});
	}

}
