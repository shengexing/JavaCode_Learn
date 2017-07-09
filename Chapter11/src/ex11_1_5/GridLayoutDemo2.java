//�½�11.1.5                    GridLayout���񲼾�
package ex11_1_5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GridLayoutDemo2 {
	private String[][] names={
			{"1","2","3","+"},
			{"4","5","6","-"},
			{"7","8","9","*"},
			{".","0","=","/"}
	};
	private JButton[][] buttons=new JButton[4][4];         //������ʾ��������鰴ť
	GridLayout experimentLayout=new GridLayout(4,4);      //����һ��GridLayout���ֹ������Ľ���
	public GridLayoutDemo2() {
		experimentLayout.setHgap(10);             //���õ�Ԫ��ˮƽ���Ϊ10����
		experimentLayout.setVgap(10);             //���õ�Ԫ��ֱ���Ϊ10����
	}
	
	//�������ӵ���������еķ���
	public void addComponentsToPane(final Container pane) {
		final JPanel compsToExperiment=new JPanel();          //������Ӱ�ť�����������
		compsToExperiment.setLayout(experimentLayout);     //���ò��ֹ�����
		//��Ӱ�ť������Ԫ��
		for(int row=0;row<names.length;row++)
			for(int col=0;col<names.length;col++)
				compsToExperiment.add(new JButton(names[row][col]));      //������ť���󣬲���ӵ������
		pane.add(compsToExperiment,BorderLayout.NORTH);
	}

	//����GUI���沢��ʾ
	private void createAndShowGUI() {
		//���������ô���
		JFrame frame=new JFrame("GridLayoutDemo2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�����������
		addComponentsToPane(frame.getContentPane());
		//��ʾ����
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		//�趨������۷��
		try {
			//     UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			//Ӧ�ÿ�ƽ̨�����
		} catch(Exception ex) {
			
		}
		//�ر���������ʾ
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		//�����������߳�
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GridLayoutDemo2().createAndShowGUI();
			}
		});
		// TODO �Զ����ɵķ������

	}

}
