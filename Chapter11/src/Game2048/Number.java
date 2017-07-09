//2048游戏主代码
package Game2048;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Number extends JFrame {
	JPanel cp=(JPanel)this.getContentPane();
	JPanel jpButton=new JPanel();         //放按钮的面板
	JPanel jpBox=new JPanel();         //放单元格的面板

	static Box[][] box=new Box[4][4];         //4X4的单元格
	static Box[] colBox={new Box(), new Box(), new Box(), new Box()};     //1X4的单元格列
	static JButton[] button={     //操作按钮
		new JButton("up"), new JButton("down"), new JButton("left"), new JButton("right"), new JButton("reset") 
	};
	static boolean GAME_OVER=false;      //游戏结束的标记
	static boolean ISOP=false;            //是否移动或消除
	List<Box> listB=new ArrayList<Box>();     //空白格列表

	/*默认的缺省构造函数*/
	Number() {
		//设置放置组件面板的布局
		cp.setLayout(new BorderLayout());
		jpButton.setLayout(new BorderLayout());
		jpBox.setLayout(new GridLayout(4,4));
		init(); //初始化

		for(int i=0; i<4; i++)      //显示单元格
			for(int j=0; j<4; j++)
				jpBox.add(box[i][j]);
		//显示操作按钮
		jpButton.add(button[0], BorderLayout.NORTH);
		jpButton.add(button[1], BorderLayout.SOUTH);
		jpButton.add(button[2], BorderLayout.WEST);
		jpButton.add(button[3], BorderLayout.EAST);
		jpButton.add(button[4], BorderLayout.CENTER);
		
		cp.add(jpBox, BorderLayout.NORTH);
		cp.add(jpButton, BorderLayout.SOUTH);

		//设置按钮的动作事件监听者
		ButtonAction buttonAction=new ButtonAction();
		for(int i=0; i<5; i++)
			button[i].addActionListener(buttonAction);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*初始化4X4单元格*/
	void init() {
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++) {
				box[i][j]=new Box(i, j, 0);
				listB.add(box[i][j]);
			}
		addItem();
		addItem();
	}

	/*随机将一个空格设置指数*/
	void addItem() {
		int size=listB.size();     //空格的数目
		int row, col;                //空格的位置
		if(size!=0) {
			int randomIndex=(int)(size*Math.random());    //取得随机的空格
			int randomNum=(int)(11*Math.random()+1);     //设计随机的空格指数（1, 2）1的概率为9/10
			//取得空格的位置
			row=listB.get(randomIndex).indexX;
			col=listB.get(randomIndex).indexY;
			//空格取得随机指数
			box[row][col].setBox((randomNum<9) ? 1: 2);
			//空格列表中移除该空格
			listB.remove(randomIndex);
		}

	}

	/*定义向上滑动的函数*/
	void opUp() {
		List<Box>[] list=new ArrayList[4];    //有值的单元格
		for(int i=0; i<4; i++)
			list[i]=new ArrayList<Box>();
		//有值的单元格连续排列
		for(int col=0; col<4; col++) {
			for(int row=0; row<4; row++)
				if(box[row][col].getBoxIndex()!=0) {
					list[col].add(box[row][col]);
				}
		}
		//滑动单元格
		for(int col=0, row=0; col<4; col++) {
			for(; row<list[col].size(); row++) {
				if(box[row][col].getBoxIndex()==0) {
					listB.remove(listB.indexOf(box[row][col]));
					ISOP=true;
				}
				box[row][col].setBox(list[col].get(row).getBoxIndex());
			}
			for(; row<4; row++) {
				box[row][col].setBox(0);
				listB.add(box[row][col]);
			}
		}
		//合并单元格
		for(int col=0, row=0; col<4; col++) {
			for(int index1, index2; row<list[col].size()-1; row++) {
				index1=box[row][col].getBoxIndex(); index2=box[row+1][col].getBoxIndex();
				if(index1!=0&&index1==index2) {
					box[row][col].setBox(index1+1);
					box[row+1][col].setBox(0);
					listB.add(box[row+1][col]);
					ISOP=true;
				}
			}
		}

		list=new ArrayList[4];   //重置list
		for(int i=0; i<4; i++)
			list[i]=new ArrayList<Box>();
		//有值的单元格再次连续排列
		for(int col=0; col<4; col++) {
			for(int row=0; row<4; row++)
				if(box[row][col].getBoxIndex()!=0) {
					list[col].add(box[row][col]);
				}
		}
		//再次滑动单元格
		for(int col=0, row=0; col<4; col++) {
			for(; row<list[col].size(); row++) {
				if(box[row][col].getBoxIndex()==0) {
					listB.remove(listB.indexOf(box[row][col]));
					ISOP=true;
				}
				box[row][col].setBox(list[col].get(row).getBoxIndex());
			}
			for(; row<4; row++) {
				box[row][col].setBox(0);
				listB.add(box[row][col]);
			}
		}

		if(!ISOP&&listB.size()==0)
			GAME_OVER=true;
		else
			addItem();
	}

	/*向下滑动的函数*/
	void opDown() {
		List<Box>[] list=new ArrayList[4];    //有值的单元格
		//有值的单元格连续排列
		for(int col=0; col<4; col++) {
			for(int row=3; row>=0; row--)
				if(box[row][col].getBoxIndex()!=0) {
					list[col].add(box[row][col]);
				}
		}
		//滑动单元格
		for(int col=0, row=3; col<4; col++) {
			for(; row>3-list[col].size(); row--) {
				if(box[row][col].getBoxIndex()==0)
					listB.remove(listB.indexOf(box[row][col]));
				box[row][col].setBox(list[col].get(row-list[col].size()).getBoxIndex());
			}
			for(; row>=0; row--) {
				box[row][col].setBox(0);
				listB.add(box[row][col]);
			}
		}
		//合并单元格
		for(int col=0, row=3; col<4; col++) {
			for(int index1, index2; row>3-list[col].size(); row--) {
				index1=box[row][col].getBoxIndex(); index2=box[row-1][col].getBoxIndex();
				if(index1!=0&&index1==index2) {
					box[row][col].setBox(index1+1);
					box[row-1][col].setBox(0);
					listB.add(box[row-1][col]);
				}
			}
		}

		list=new ArrayList[4];   //重置list
		//有值的单元格连续排列
		for(int col=0; col<4; col++) {
			for(int row=3; row>=0; row--)
				if(box[row][col].getBoxIndex()!=0) {
					list[col].add(box[row][col]);
				}
		}
		//滑动单元格
		for(int col=0, row=3; col<4; col++) {
			for(; row>3-list[col].size(); row--) {
				if(box[row][col].getBoxIndex()==0)
					listB.remove(listB.indexOf(box[row][col]));
				box[row][col].setBox(list[col].get(row-list[col].size()).getBoxIndex());
			}
			for(; row>=0; row--) {
				box[row][col].setBox(0);
				listB.add(box[row][col]);
			}
		}
	}

	/*向左滑动的函数*/
	void opLeft() {
		List<Box>[] list=new ArrayList[4];    //有值的单元格
		//有值的单元格连续排列
		for(int row=0; row<4; row++) {
			for(int col=0; col<4; col++)
				if(box[row][col].getBoxIndex()!=0) {
					list[row].add(box[row][col]);
				}
		}
		//滑动单元格
		for(int row=0, col=0; row<4; row++) {
			for(; col<list[row].size(); col++) {
				if(box[row][col].getBoxIndex()==0)
					listB.remove(listB.indexOf(box[row][col]));
				box[row][col].setBox(list[row].get(col).getBoxIndex());
			}
			for(; col<4; col++) {
				box[row][col].setBox(0);
				listB.add(box[row][col]);
			}
		}
		//合并单元格
		for(int row=0, col=0; row<4; row++) {
			for(int index1, index2; col<list[row].size()-1; col++) {
				index1=box[row][col].getBoxIndex(); index2=box[row][col+1].getBoxIndex();
				if(index1!=0&&index1==index2) {
					box[row][col].setBox(index1+1);
					box[row][col+1].setBox(0);
					listB.add(box[row][col+1]);
				}
			}
		}

		list=new ArrayList[4];   //重置list
		//有值的单元格再次连续排列
		for(int row=0; row<4; row++) {
			for(int col=0; col<4; col++)
				if(box[row][col].getBoxIndex()!=0) {
					list[row].add(box[row][col]);
				}
		}
		//再次滑动单元格
		for(int row=0, col=0; row<4; row++) {
			for(; col<list[row].size(); col++) {
				if(box[row][col].getBoxIndex()==0)
					listB.remove(listB.indexOf(box[row][col]));
				box[row][col].setBox(list[row].get(col).getBoxIndex());
			}
			for(; col<4; col++) {
				box[row][col].setBox(0);
				listB.add(box[row][col]);
			}
		}

	}

	/*向右滑动的函数*/
	void opRight() {
		List<Box>[] list=new ArrayList[4];    //有值的单元格
		//有值的单元格连续排列
		for(int row=0; row<4; row++) {
			for(int col=3; col>=0; col--)
				if(box[row][col].getBoxIndex()!=0) {
					list[row].add(box[row][col]);
				}
		}
		//滑动单元格
		for(int row=0, col=3; row<4; row++) {
			for(; col>3-list[row].size(); col--) {
				if(box[row][col].getBoxIndex()==0)
					listB.remove(listB.indexOf(box[row][col]));
				box[row][col].setBox(list[row].get(col-list[row].size()).getBoxIndex());
			}
			for(; col>=0; col--) {
				box[row][col].setBox(0);
				listB.add(box[row][col]);
			}
		}
		//合并单元格
		for(int row=0, col=3; row<4; row++) {
			for(int index1, index2; col>3-list[row].size(); col--) {
				index1=box[row][col].getBoxIndex(); index2=box[row][col-1].getBoxIndex();
				if(index1!=0&&index1==index2) {
					box[row][col].setBox(index1+1);
					box[row][col-1].setBox(0);
					listB.add(box[row][col-1]);
				}
			}
		}

		list=new ArrayList[4];   //重置list
		//有值的单元格连续排列
		for(int row=0; row<4; row++) {
			for(int col=3; col>=0; col--)
				if(box[row][col].getBoxIndex()!=0) {
					list[row].add(box[row][col]);
				}
		}
		//滑动单元格
		for(int row=0, col=3; row<4; row++) {
			for(; col>3-list[row].size(); col--) {
				if(box[row][col].getBoxIndex()==0)
					listB.remove(listB.indexOf(box[row][col]));
				box[row][col].setBox(list[row].get(col-list[row].size()).getBoxIndex());
			}
			for(; col>=0; col--) {
				box[row][col].setBox(0);
				listB.add(box[row][col]);
			}
		}

	}

	/*重置函数*/
	void opReset() {
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++) {
				box[i][j].setBox(0);
			}
		addItem();
		addItem();
	}

	class ButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source==button[0])
				opUp();
			if(source==button[1])
				opDown();
			if(source==button[2])
				opLeft();
			if(source==button[3])
				opRight();
			if(source==button[4])
				opReset();
		}

	}

	public static void main(String[] args) {
		Number my=new Number();
	}

}
