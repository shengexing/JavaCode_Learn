// �½�17.01.1             ����ͼ�������
package ex17_01_1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sample17_1 extends JFrame{

	// ͨ�������ڲ���ķ����̳в���չJPanel����Ϊ����
	public JPanel jp = new JPanel() {
		// ����ָ��ͼƬ��ȡImage����
		Image img = Toolkit.getDefaultToolkit().getImage("E:\\Pictures\\Saved Pictures\\girl.png");
		// ��ͼ���������
		Image tempimg1 = img.getScaledInstance(141, 106, Image.SCALE_SMOOTH);
		Image tempimg2 = img.getScaledInstance(70, 53, Image.SCALE_SMOOTH);
		
		public void paint(Graphics g) {
			// ����ԭʼͼ��
			g.drawImage(img, 10, 10, this);
			// �������ź�ͼ��
			g.drawImage(tempimg1, 310, 10, this);
			g.drawImage(tempimg2, 465, 10, this);
		}
	};
	
	// ���幹����
	public Sample17_1() {
		// ��������ӽ�������
		this.add(jp);
		// ���ش���ͼ��ͼ��
		Image icon = Toolkit.getDefaultToolkit().getImage("E:\\\\Pictures\\\\Saved Pictures\\joy.jpg");
		// ���ô���ͼ��
		this.setIconImage(icon);
		// ���ô���Ĺرն��������⡢��Сλ���Լ��ɼ���
		this.setTitle("ͼ�������ʾ");
		this.setBounds(100, 100, 550, 260);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// ������
	public static void main(String[] args) {
		// ����Sample17_1�������
		new Sample17_1();
	}

}
