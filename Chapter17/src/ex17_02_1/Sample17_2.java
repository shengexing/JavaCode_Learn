// �½�17.02.1            ʵ��Icon�ӿڿ����Զ���ͼ��
package ex17_02_1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyIcon implements Icon{
	
	// ��������ͼ������߶ȵĳ�Ա����
	private int width=400;
	private int height=300;
	
	// ʵ��paintIcon����
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// �򿪿����
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// �Զ����ͼ����ƴ���
		g.setColor(new Color(10, 10, 10, 125));
		g.fillRect(10, 10, 90, 90);
		g.fillOval(260, 10, 150, 90);
		g.setColor(new Color(100, 100, 100, 125));
		g.fillRect(70, 70, 90, 90);
		g.fillOval(320, 70, 150, 90);
		g.setColor(new Color(190, 190, 190, 125));
		g.fillRect(130, 130, 90, 90);
		g.fillOval(380, 130, 150, 90);
	}
	
	// ʵ��getIconWidth����
	public int getIconWidth() {
		return this.width;
	}
	
	// ʵ��getIconHeight����
	public int getIconHeight() {
		return this.height;
	}


}

// ����
public class Sample17_2 extends JFrame {
	
	// ���幹����
	public Sample17_2() {
		// �����Զ����ͼ�����
		Icon icon = new MyIcon();
		
		// ����������ʾͼ��ı�ǩ
		JLabel jl = new JLabel(icon, JLabel.CENTER);
		
		// ���ñ�ǩ�ı���ɫΪ��ɫ
		jl.setBackground(Color.white);
		
		// ���ñ�ǩ����Ϊ��͸��
		jl.setOpaque(true);
		
		// ����ǩ��ӽ�������
		this.add(jl);
		
		// ���ô���Ĺرն��������⡢��Сλ���Լ��ɼ���
		this.setTitle("�Զ���ͼ����ʾ");
		this.setBounds(100, 100, 550, 260);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// ������
	public static void main(String[] args) {
		// ����Sample17_2�������
		new Sample17_2();

	}
}
