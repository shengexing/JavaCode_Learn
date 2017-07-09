//2048��Ϸ������
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
	JPanel jpButton=new JPanel();         //�Ű�ť�����
	JPanel jpBox=new JPanel();         //�ŵ�Ԫ������

	static Box[][] box=new Box[4][4];         //4X4�ĵ�Ԫ��
	static Box[] colBox={new Box(), new Box(), new Box(), new Box()};     //1X4�ĵ�Ԫ����
	static JButton[] button={     //������ť
		new JButton("up"), new JButton("down"), new JButton("left"), new JButton("right"), new JButton("reset") 
	};
	static boolean GAME_OVER=false;      //��Ϸ�����ı��
	static boolean ISOP=false;            //�Ƿ��ƶ�������
	List<Box> listB=new ArrayList<Box>();     //�հ׸��б�

	/*Ĭ�ϵ�ȱʡ���캯��*/
	Number() {
		//���÷���������Ĳ���
		cp.setLayout(new BorderLayout());
		jpButton.setLayout(new BorderLayout());
		jpBox.setLayout(new GridLayout(4,4));
		init(); //��ʼ��

		for(int i=0; i<4; i++)      //��ʾ��Ԫ��
			for(int j=0; j<4; j++)
				jpBox.add(box[i][j]);
		//��ʾ������ť
		jpButton.add(button[0], BorderLayout.NORTH);
		jpButton.add(button[1], BorderLayout.SOUTH);
		jpButton.add(button[2], BorderLayout.WEST);
		jpButton.add(button[3], BorderLayout.EAST);
		jpButton.add(button[4], BorderLayout.CENTER);
		
		cp.add(jpBox, BorderLayout.NORTH);
		cp.add(jpButton, BorderLayout.SOUTH);

		//���ð�ť�Ķ����¼�������
		ButtonAction buttonAction=new ButtonAction();
		for(int i=0; i<5; i++)
			button[i].addActionListener(buttonAction);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*��ʼ��4X4��Ԫ��*/
	void init() {
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++) {
				box[i][j]=new Box(i, j, 0);
				listB.add(box[i][j]);
			}
		addItem();
		addItem();
	}

	/*�����һ���ո�����ָ��*/
	void addItem() {
		int size=listB.size();     //�ո����Ŀ
		int row, col;                //�ո��λ��
		if(size!=0) {
			int randomIndex=(int)(size*Math.random());    //ȡ������Ŀո�
			int randomNum=(int)(11*Math.random()+1);     //�������Ŀո�ָ����1, 2��1�ĸ���Ϊ9/10
			//ȡ�ÿո��λ��
			row=listB.get(randomIndex).indexX;
			col=listB.get(randomIndex).indexY;
			//�ո�ȡ�����ָ��
			box[row][col].setBox((randomNum<9) ? 1: 2);
			//�ո��б����Ƴ��ÿո�
			listB.remove(randomIndex);
		}

	}

	/*�������ϻ����ĺ���*/
	void opUp() {
		List<Box>[] list=new ArrayList[4];    //��ֵ�ĵ�Ԫ��
		for(int i=0; i<4; i++)
			list[i]=new ArrayList<Box>();
		//��ֵ�ĵ�Ԫ����������
		for(int col=0; col<4; col++) {
			for(int row=0; row<4; row++)
				if(box[row][col].getBoxIndex()!=0) {
					list[col].add(box[row][col]);
				}
		}
		//������Ԫ��
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
		//�ϲ���Ԫ��
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

		list=new ArrayList[4];   //����list
		for(int i=0; i<4; i++)
			list[i]=new ArrayList<Box>();
		//��ֵ�ĵ�Ԫ���ٴ���������
		for(int col=0; col<4; col++) {
			for(int row=0; row<4; row++)
				if(box[row][col].getBoxIndex()!=0) {
					list[col].add(box[row][col]);
				}
		}
		//�ٴλ�����Ԫ��
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

	/*���»����ĺ���*/
	void opDown() {
		List<Box>[] list=new ArrayList[4];    //��ֵ�ĵ�Ԫ��
		//��ֵ�ĵ�Ԫ����������
		for(int col=0; col<4; col++) {
			for(int row=3; row>=0; row--)
				if(box[row][col].getBoxIndex()!=0) {
					list[col].add(box[row][col]);
				}
		}
		//������Ԫ��
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
		//�ϲ���Ԫ��
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

		list=new ArrayList[4];   //����list
		//��ֵ�ĵ�Ԫ����������
		for(int col=0; col<4; col++) {
			for(int row=3; row>=0; row--)
				if(box[row][col].getBoxIndex()!=0) {
					list[col].add(box[row][col]);
				}
		}
		//������Ԫ��
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

	/*���󻬶��ĺ���*/
	void opLeft() {
		List<Box>[] list=new ArrayList[4];    //��ֵ�ĵ�Ԫ��
		//��ֵ�ĵ�Ԫ����������
		for(int row=0; row<4; row++) {
			for(int col=0; col<4; col++)
				if(box[row][col].getBoxIndex()!=0) {
					list[row].add(box[row][col]);
				}
		}
		//������Ԫ��
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
		//�ϲ���Ԫ��
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

		list=new ArrayList[4];   //����list
		//��ֵ�ĵ�Ԫ���ٴ���������
		for(int row=0; row<4; row++) {
			for(int col=0; col<4; col++)
				if(box[row][col].getBoxIndex()!=0) {
					list[row].add(box[row][col]);
				}
		}
		//�ٴλ�����Ԫ��
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

	/*���һ����ĺ���*/
	void opRight() {
		List<Box>[] list=new ArrayList[4];    //��ֵ�ĵ�Ԫ��
		//��ֵ�ĵ�Ԫ����������
		for(int row=0; row<4; row++) {
			for(int col=3; col>=0; col--)
				if(box[row][col].getBoxIndex()!=0) {
					list[row].add(box[row][col]);
				}
		}
		//������Ԫ��
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
		//�ϲ���Ԫ��
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

		list=new ArrayList[4];   //����list
		//��ֵ�ĵ�Ԫ����������
		for(int row=0; row<4; row++) {
			for(int col=3; col>=0; col--)
				if(box[row][col].getBoxIndex()!=0) {
					list[row].add(box[row][col]);
				}
		}
		//������Ԫ��
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

	/*���ú���*/
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
