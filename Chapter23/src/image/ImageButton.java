// �½�24.04.1            �Զ��尴ť���
package image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton {
	
	private int row = 0;				// �����������������еı���
	private int col = 0; 				// �����������������еı���
	
	/** Ĭ�Ϲ�����*/
	public ImageButton() {
		
	}
	
	/** ���в����Ĺ�����������Ϊ��ť��Ҫ��ʾ��ͼƬ*/
	public ImageButton(ImageIcon image) {
		super(image);			// ���ó���Ĺ�����
	}
	
	/** ��ȡ��ť���ڵ���*/
	public int getRow() {
		return row;
	}

	/** ���ð�ť�����е�ֵ*/
	public void setRow(int row) {
		this.row = row;
	}

	/** ��ȡ��ť���ڵ���*/
	public int getCol() {
		return col;
	}

	/** ���ð�ť�����е�ֵ*/
	public void setCol(int col) {
		this.col = col;
	}
	
	public static void main(String[] args) {                    
		// TODO Auto-generated method stub

	}

}
