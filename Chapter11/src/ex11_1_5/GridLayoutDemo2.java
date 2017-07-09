//章节11.1.5                    GridLayout网格布局
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
	private JButton[][] buttons=new JButton[4][4];         //创建显示界面的数组按钮
	GridLayout experimentLayout=new GridLayout(4,4);      //创建一个GridLayout布局管理器的界面
	public GridLayoutDemo2() {
		experimentLayout.setHgap(10);             //设置单元格水平间距为10像素
		experimentLayout.setVgap(10);             //设置单元格垂直间距为10像素
	}
	
	//将组件添加到容器面板中的方法
	public void addComponentsToPane(final Container pane) {
		final JPanel compsToExperiment=new JPanel();          //创建添加按钮组件的面板对象
		compsToExperiment.setLayout(experimentLayout);     //设置布局管理器
		//添加按钮到网格单元中
		for(int row=0;row<names.length;row++)
			for(int col=0;col<names.length;col++)
				compsToExperiment.add(new JButton(names[row][col]));      //创建按钮对象，并添加到面板中
		pane.add(compsToExperiment,BorderLayout.NORTH);
	}

	//创建GUI界面并显示
	private void createAndShowGUI() {
		//创建并设置窗口
		JFrame frame=new JFrame("GridLayoutDemo2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置内容面板
		addComponentsToPane(frame.getContentPane());
		//显示窗口
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		//设定程序外观风格
		try {
			//     UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			//应用跨平台的外观
		} catch(Exception ex) {
			
		}
		//关闭组体字显示
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		//启动主程序线程
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GridLayoutDemo2().createAndShowGUI();
			}
		});
		// TODO 自动生成的方法存根

	}

}
