//�½�10.7.1                  ʵ��һ��Բ�εİ�ť����������ťʱ����ť��ɫ�����仯
package ex10_7_1;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CircleButton extends JButton{
	/*���캯��*/
	public CircleButton(String label) {
		super(label);
		Dimension size=getPreferredSize();         //��ȡ��ť����Ѵ�С
		
		//������ť��С��ʹ֮��Ϊһ������
		size.width=size.height=Math.max(size.width, size.height);
		setPreferredSize(size);
		
		//ʹJButton����������������ʾ���α��������������ǻ�һ��Բ�ı���
		setContentAreaFilled(false);
	}
	
	/*��Բ�İ�ť�ı����ͱ�ǩ*/
	protected void paintComponent(Graphics g) {
		
		//getModel�����Ƿ�������ģ��ButtonModel
		
		//�����갴�°�ť����ButtonModel��armed����Ϊ��
		if(getModel().isArmed()) {
			//������ťʱ����lightGray��ɫ��ʾ��ť
			g.setColor(Color.lightGray);
		}
		else {
			//�����¼���Ĭ�ϵı���ɫ��ʾ��ť
			g.setColor(getBackground());
		}
		
		//fillOval������һ�����ε�������Բ������ʹ����������Բ
		
		//������Ϊ������ʱ����������Բ����Բ
		g.fillOval(0, 0, getSize().width-1,getSize().height-1 );
		
		//���ø����paintComponent����ť�ı�ǩ�ͽ������ڵľ���
		super.paintComponents(g);
	}
	
	/*�ü򵥵Ļ��䵱��ť�ı߽�*/
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		
		//drawOval���������ε�������Բ��������䡣ֻ����һ���߽�
		g.drawOval(0,0,getSize().width-1,getSize().height-1);
	}
	
	Shape shape;    /*���ڱ��水ť����״������������������ť�¼�*/
	
	/*�ж�����Ƿ���ڰ�ť��*/
	public boolean contains(int x,int y) {
		
		//�����ť�߿�λ�÷����ı䣬�����һ���µ���״����
		if((shape==null)||(!shape.getBounds().equals(getBounds()))) {
			
			//����һ����Բ�ζ���
			shape=new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		
		//�ж�����x,y�����Ƿ����ڰ�ť��״��
		return shape.contains(x,y);
	}
	
	public static void main(String[] args) {
		CircleButton button=new CircleButton("Click me");              //����һ��Բ�ΰ�ť
		button.setBackground(Color.green);                  //���ñ�����ɫΪ��ɫ
		
		//����һ���������ʾ�����ť
		JFrame frame=new JFrame("Բ�ΰ�ť");
		frame.getContentPane().setBackground(Color.yellow);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(button);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
