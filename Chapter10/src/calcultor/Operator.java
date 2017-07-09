package calcultor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;

public class Operator extends JFrame{

	JPanel jpText=new JPanel();
	JPanel jpOper=new JPanel();
	JButton jbOld=null;
	JButton jbNew=null;
	JPanel cp=(JPanel)this.getContentPane();
	//�ı���ʾ��
	JTextArea jta=new JTextArea();

	//ʮ�����ְ���
	JButton[] jbNum={
			new JButton("0"), new JButton("1"), new JButton("2"), new JButton("3"), new JButton("4"),
			new JButton("5"), new JButton("6"), new JButton("7"), new JButton("8"), new JButton("9")
	};

	//�Ÿ����㰴��
	JButton jbOper_AC=new JButton("AC"); JButton jbOper_Delete=new JButton("del");
	JButton jbOper_Add=new JButton("+"); JButton jbOper_Des=new JButton("-");
	JButton jbOper_Mult=new JButton("*"); JButton jbOper_Div=new JButton("/");
	JButton jbOper_Que=new JButton("="); JButton jbOper_Point=new JButton(".");
	JButton jbOper_Per=new JButton("%");

	public Operator() {

	}

	public Operator(String str) {
		super(str);
		init();
	}

	public void init() {
		jpText.setBorder(new LineBorder(Color.BLACK, 3, true));

		//���ֹ���
		jpText.setLayout(new BorderLayout());
		jpOper.setLayout(null);
		cp.setLayout(null);

		//�ı���ʾ��
		jta.setEditable(false);
		jpText.add(jta,BorderLayout.CENTER);

		//ʮ�����ְ���
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				jbNum[3*i+j+1].setBounds(50*j, 90-30*i,50, 30);
		jbNum[0].setBounds(50, 120, 50, 30);
		for(int i=0;i<10;i++)
			jpOper.add(jbNum[i]);

		//�Ÿ����㰴��
		jbOper_AC.setBounds(0, 0, 50, 30);
		jpOper.add(jbOper_AC);
		jbOper_Delete.setBounds(50, 0, 50, 30);
		jpOper.add(jbOper_Delete);
		jbOper_Add.setBounds(150, 60, 50, 30);
		jpOper.add(jbOper_Add);
		jbOper_Des.setBounds(150, 30, 50, 30);
		jpOper.add(jbOper_Des);
		jbOper_Mult.setBounds(150, 0, 50, 30);
		jpOper.add(jbOper_Mult);
		jbOper_Div.setBounds(100, 0, 50, 30);
		jpOper.add(jbOper_Div);
		jbOper_Que.setBounds(150, 90, 50, 60);
		jpOper.add(jbOper_Que);
		jbOper_Point.setBounds(100, 120, 50, 30);
		jpOper.add(jbOper_Point);
		jbOper_Per.setBounds(0, 120, 50, 30);
		jpOper.add(jbOper_Per);

		//���ð�ť���¼�������
		NumAction numAction=new NumAction();
		ChaAction chaAction=new ChaAction();
		for(int i=0;i<10;i++) {
			jbNum[i].addActionListener(numAction);
		}
		jbOper_Point.addActionListener(numAction);
		jbOper_AC.addActionListener(chaAction);
		jbOper_Delete.addActionListener(chaAction);
		//���岼�ֹ���
		jpText.setBounds(0, 0, 200, 100);
		cp.add(jpText);
		jpOper.setBounds(0, 100, 200, 150);
		cp.add(jpOper);
		this.setBounds(0, 0, 220, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*���尴ť�ı�ķ���*/
	public void changeButton(JButton jb1) {
		jbOld=jbNew; jbNew=jb1;
	}

	/*�������ּ���С������¼�������*/
	public class NumAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source!=jbOper_Point) {
				for(int i=0;i<10;i++)
					if(source==jbNum[i]) {
						changeButton(jbNum[i]);
						jta.append(i+"");
						break;
					}
			}
			else {
				jta.append(".");
			}
		}
	}

	/*����������������¼�������*/
	public class ChaAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();

			if(source==jbOper_AC) {            //��ղ���
				jta.setText(null);
				changeButton(jbOper_AC);
			}
			if(source==jbOper_Delete) {      //ɾ������
				changeButton(jbOper_Delete);
				if(jta.getText()!=null) {
					if(jbOld!=jbOper_Que)
					{
						int index=jta.getLineCount()-1;
						int start=0, end=0;
						try {
							start=jta.getLineStartOffset(index);
							end = jta.getLineEndOffset(index);
							String str=jta.getText(start,end-1);
							jta.replaceRange(str, start, end);
						} catch (BadLocationException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
					}
					else
						jta.setText(null);
				}
			}
			if(source==jbOper_Div) {             //��������
				if(jta.getText()!=null) {
					if(jbOld!=jbOper_Que) {
						int index=jta.getLineCount()-1;
						int start=0, end=0,num1;
						double num2=0;
						try {
							start=jta.getLineStartOffset(index);
							end = jta.getLineEndOffset(index);
							String str=jta.getText(start,end-1);
							Calcute.operator_number.add(str);
							jta.append("/\n");
						} catch (BadLocationException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
					}
				}
			}
		}
	}


	public static void main(String[] args) {
		new Operator("������");
	}
}
