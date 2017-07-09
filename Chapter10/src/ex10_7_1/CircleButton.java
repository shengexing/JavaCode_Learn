//章节10.7.1                  实现一个圆形的按钮，当单击按钮时，按钮颜色发生变化
package ex10_7_1;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CircleButton extends JButton{
	/*构造函数*/
	public CircleButton(String label) {
		super(label);
		Dimension size=getPreferredSize();         //获取按钮的最佳大小
		
		//调整按钮大小，使之成为一个方形
		size.width=size.height=Math.max(size.width, size.height);
		setPreferredSize(size);
		
		//使JButton不画背景，即不显示方形背景，而允许我们画一个圆的背景
		setContentAreaFilled(false);
	}
	
	/*画圆的按钮的背景和标签*/
	protected void paintComponent(Graphics g) {
		
		//getModel方法是返回鼠标的模型ButtonModel
		
		//如果鼠标按下按钮，则ButtonModel的armed属性为真
		if(getModel().isArmed()) {
			//单击按钮时，用lightGray颜色显示按钮
			g.setColor(Color.lightGray);
		}
		else {
			//其他事件用默认的背景色显示按钮
			g.setColor(getBackground());
		}
		
		//fillOval方法画一个矩形的内切椭圆，并且使用填充这个椭圆
		
		//当矩形为正方形时，画出的椭圆便是圆
		g.fillOval(0, 0, getSize().width-1,getSize().height-1 );
		
		//调用父类的paintComponent画按钮的标签和焦点所在的矩形
		super.paintComponents(g);
	}
	
	/*用简单的弧充当按钮的边界*/
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		
		//drawOval方法画矩形的内切椭圆，但不填充。只画出一个边界
		g.drawOval(0,0,getSize().width-1,getSize().height-1);
	}
	
	Shape shape;    /*用于保存按钮的形状，有助于侦听单击按钮事件*/
	
	/*判断鼠标是否点在按钮上*/
	public boolean contains(int x,int y) {
		
		//如果按钮边框、位置发生改变，则产生一个新的形状对象
		if((shape==null)||(!shape.getBounds().equals(getBounds()))) {
			
			//构造一个椭圆形对象
			shape=new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		
		//判断鼠标的x,y坐标是否落在按钮形状内
		return shape.contains(x,y);
	}
	
	public static void main(String[] args) {
		CircleButton button=new CircleButton("Click me");              //产生一个圆形按钮
		button.setBackground(Color.green);                  //设置背景颜色为绿色
		
		//产生一个框架以显示这个按钮
		JFrame frame=new JFrame("圆形按钮");
		frame.getContentPane().setBackground(Color.yellow);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(button);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
