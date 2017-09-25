// 章节24.04.1            自定义按钮设计
package image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton {
	
	private int row = 0;				// 声明用来保存所在行的变量
	private int col = 0; 				// 声明用来保存所在列的变量
	
	/** 默认构造器*/
	public ImageButton() {
		
	}
	
	/** 带有参数的构造器，参数为按钮上要显示的图片*/
	public ImageButton(ImageIcon image) {
		super(image);			// 调用超类的构造器
	}
	
	/** 获取按钮所在的行*/
	public int getRow() {
		return row;
	}

	/** 设置按钮所在行的值*/
	public void setRow(int row) {
		this.row = row;
	}

	/** 获取按钮所在的行*/
	public int getCol() {
		return col;
	}

	/** 设置按钮所在列的值*/
	public void setCol(int col) {
		this.col = col;
	}
	
	public static void main(String[] args) {                    
		// TODO Auto-generated method stub

	}

}
