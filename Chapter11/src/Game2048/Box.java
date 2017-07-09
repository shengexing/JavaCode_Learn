//2048游戏中的单元格定义
package Game2048;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Box extends JLabel{
	public int indexX=0;            //单元格的横坐标
	public int indexY=0;           //单元格的纵坐标
	private int index=0;      //2048中单元格的指数（2^index）
	Color myFontColor;
	Color myBoxColor;

	/*默认缺省构造函数*/
	public Box() {
		super();
		myFontColor=new Color(0, 0, 0);
		myBoxColor=new Color(255,255,255);
		this.setForeground(myFontColor);
		this.setBackground(myBoxColor);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	/*含参的构造函数*/
	public Box(int x, int y, int index) {
		indexX=x;
		indexY=y;
		setBox(index);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	/*设置单元格的参数*/
	public void setBox(int index) {
		setFontIndex(index);
		setBoxIndex(index);
		this.setForeground(myFontColor);
		this.setBackground(myBoxColor);
		this.setBoxText(index);
	}

	/*设置单元格字体*/
	private void setBoxText(int index) {
		this.index=index;
		if(index==0)
			return;
		this.setText(""+(int)Math.pow(2, index));
	}

	/*设置单元格背景颜色*/
	private void setBoxIndex(int index) {
		this.index=index;
		int temp_index=index%125;
		//定义index被25除的商，被5除的商，被5除的余数
		int quotient25=temp_index/25, quotient5=(temp_index/25>0)?((temp_index%5)/5):(temp_index/5), remainder5=temp_index%5;
		myBoxColor=new Color((int)Math.pow(2, 8-2*quotient25)-1, (int)Math.pow(2, 8-2*quotient5)-1, (int)Math.pow(2, 8-2*remainder5)-1);
	}

	/*设置单元格字体颜色*/
	private void setFontIndex(int index) {
		this.index=index;
		int temp_index=index%125;
		//定义index被25除的商，被5除的商，被5除的余数
		int quotient25=temp_index/25, quotient5=(temp_index/25>0)?((temp_index%5)/5):(temp_index/5), remainder5=temp_index%5;
		myFontColor=new Color((int)Math.pow(2, 2*remainder5)-1, (int)Math.pow(2, 2*quotient5)-1, (int)Math.pow(2, 2*quotient25)-1);
	}

	/*获取单元格的指数*/
	public int getBoxIndex() {
		return this.index;
	}

	/*增加单元格指数方法*/
	public void addBoxIndex() {
		this.index++;
		setFontIndex(this.index);
		setBoxIndex(this.index);
		this.setText(""+(int)Math.pow(2, this.index));
	}

	/*清除单元格指数方法*/
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
