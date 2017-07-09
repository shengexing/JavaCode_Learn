//2048��Ϸ�еĵ�Ԫ����
package Game2048;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Box extends JLabel{
	public int indexX=0;            //��Ԫ��ĺ�����
	public int indexY=0;           //��Ԫ���������
	private int index=0;      //2048�е�Ԫ���ָ����2^index��
	Color myFontColor;
	Color myBoxColor;

	/*Ĭ��ȱʡ���캯��*/
	public Box() {
		super();
		myFontColor=new Color(0, 0, 0);
		myBoxColor=new Color(255,255,255);
		this.setForeground(myFontColor);
		this.setBackground(myBoxColor);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	/*���εĹ��캯��*/
	public Box(int x, int y, int index) {
		indexX=x;
		indexY=y;
		setBox(index);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	/*���õ�Ԫ��Ĳ���*/
	public void setBox(int index) {
		setFontIndex(index);
		setBoxIndex(index);
		this.setForeground(myFontColor);
		this.setBackground(myBoxColor);
		this.setBoxText(index);
	}

	/*���õ�Ԫ������*/
	private void setBoxText(int index) {
		this.index=index;
		if(index==0)
			return;
		this.setText(""+(int)Math.pow(2, index));
	}

	/*���õ�Ԫ�񱳾���ɫ*/
	private void setBoxIndex(int index) {
		this.index=index;
		int temp_index=index%125;
		//����index��25�����̣���5�����̣���5��������
		int quotient25=temp_index/25, quotient5=(temp_index/25>0)?((temp_index%5)/5):(temp_index/5), remainder5=temp_index%5;
		myBoxColor=new Color((int)Math.pow(2, 8-2*quotient25)-1, (int)Math.pow(2, 8-2*quotient5)-1, (int)Math.pow(2, 8-2*remainder5)-1);
	}

	/*���õ�Ԫ��������ɫ*/
	private void setFontIndex(int index) {
		this.index=index;
		int temp_index=index%125;
		//����index��25�����̣���5�����̣���5��������
		int quotient25=temp_index/25, quotient5=(temp_index/25>0)?((temp_index%5)/5):(temp_index/5), remainder5=temp_index%5;
		myFontColor=new Color((int)Math.pow(2, 2*remainder5)-1, (int)Math.pow(2, 2*quotient5)-1, (int)Math.pow(2, 2*quotient25)-1);
	}

	/*��ȡ��Ԫ���ָ��*/
	public int getBoxIndex() {
		return this.index;
	}

	/*���ӵ�Ԫ��ָ������*/
	public void addBoxIndex() {
		this.index++;
		setFontIndex(this.index);
		setBoxIndex(this.index);
		this.setText(""+(int)Math.pow(2, this.index));
	}

	/*�����Ԫ��ָ������*/
	public void removeBoxIndex() {
		this.index=0;
	}

	public static void main(String[] args) {
		Box[] box={
				null, null, null, null,
				null, null, null, null,
				null, null, null, null,
				null, null, null, null,
		};
		for(int i=0; i<16; i++) {
			box[i]=new Box(0, 0, i);
			System.out.println(box[i].myBoxColor.toString()+box[i].myFontColor.toString());
		}
	}

}
