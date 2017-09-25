// 章节23.04.2            自定义按钮设计
package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;

import image.ImageButton;

public class PuzzleGame extends JFrame {
	
	public final static int TYPE = 1;			// 定义游戏难度类型，可扩展
	public static final int[] level = {50, 100};			// 设置拆分图像的大小（像素）。大小决定了游戏的难易度
	
	int len;			// 拆分以后小图像的长度和宽度（以像素为单位）
	int row, col;			// 拼图的行数和列数
	
	private JPanel centerPane;												// 声明拼图按钮所在面板
	private JPanel modelPane;											// 声明显示参考图像的面板
	private BufferedImage image = null;								// 要拼接的原图
	private JMenuBar mBar;												// 声明菜单栏对象
	private ImageButton emptyButton;								// 声明空白按钮对象
	private String filename = "background/game.jpg";				// 要拼接的图片的路径
	
	/** 默认的构造器*/
	public PuzzleGame() {
		super();																		// 调用超类JFrame的构造器
		setResizable(false);														//	将窗体设置为不可改变大小
		setTitle("拼图游戏");														// 设置窗体标题
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 设置关闭窗体时退出程序
		
		this.len = level[TYPE];					// 设置要拆分的图像的大小
		this.image = loadImage();				// 加载原始图像
		
		setRowAndCol();				// 设置要拼接的行和列
		
		this.centerPane = this.createCenterPane();										//	创建拼接面板
		this.getContentPane().add(centerPane, BorderLayout.CENTER);
		this.modelPane = new ModelPane(this.image);									// 创建显示参考图像的面板
		this.getContentPane().add(modelPane, BorderLayout.LINE_END);	
		this.mBar = this.createMenuBar();														// 创建菜单栏
		this.setJMenuBar(mBar);																	// 设置菜单栏
		
		this.pack();				// 设置组件以首选大小排列
		
		this.setLocation(			// 设置程序窗体出现在屏幕中央位置
				this.getToolkit().getScreenSize().width / 2 - this.getWidth() / 2, 
				this.getToolkit().getScreenSize().height / 2 - this.getHeight() / 2);
		
		this.setVisible(true);				// 显示窗体
		
	}
	
	/** 加载图像*/
	public BufferedImage loadImage() {
		BufferedImage image = null;
		
		try {
			File f =new File(filename);
			System.out.println(f.getAbsolutePath());
			image = ImageIO.read(f);
		} catch (IOException e) {
			System.err.print("加载图像错误！！！\n");
		}
		
		return image;
	}
	
	/** 设置图像的行数的列数*/
	public void setRowAndCol() {
		// 如果加载图像成功，既不为null
		if(this.image != null) {
			this.col = image.getWidth() / this.len;
			this.row = image.getHeight() / this.len;
		} else {
			this.row = 0;
			this.col = 0;
		}
	}
	
	/** 拆分图像*/
	public ArrayList<BufferedImage> dividImage(BufferedImage image) {
		ArrayList<BufferedImage> subimage = new ArrayList<BufferedImage>(this.row * this.col);
		
		for(int i = 0; i < this.row; i++)
			for(int j = 0; j < this.col; j++)
				subimage.add((i * this.col + j), image.getSubimage(j * len, i * len, len, len));
		
		BufferedImage firstImage = subimage.remove(0);			// 移除第一个图片
		Collections.shuffle(subimage); 				// 对图像动态数组乱序排列
		subimage.add(0, firstImage);
		
		return subimage;
	}
	
	/** 创建拼接图面板*/
	private JPanel createCenterPane() {
		JPanel centerPane = new JPanel();
		
		centerPane.setBorder(new TitledBorder(null, "", 
				TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, null, null));		// 为面板添加边框
		
		// 设置拼接图面板的大小（行和列数）
		centerPane.setLayout(new GridLayout(row, col, 0, 0));
		JButton[][] imageButton = this.createImgButton();			// 创建要拼接的按钮
		this.addButton(imageButton, centerPane);							// 向面板中添加按钮
		
		return centerPane;
	}
	
	/** 创建按钮对象数组*/
	public ImageButton[][] createImgButton() {
		ArrayList<BufferedImage> images = this.dividImage(this.image);	// 拆分原始图像
		
		// 并保存到数组当中
		ImageButton[][] imageButton = new ImageButton[this.row][this.col];
		for(int row = 0; row < this.row; row++)
			for(int col = 0; col < this.col; col++) {
				imageButton[row][col] = new ImageButton(new ImageIcon(images.get(row * this.col + col)));
				imageButton[row][col].setRow(row);
				imageButton[row][col].setCol(col);
				imageButton[row][col].setPreferredSize(new Dimension(len, len));		// 设置按钮的首选大小
				imageButton[row][col].addActionListener(new ImgButtonAction());
			}
		
		imageButton[0][0].setIcon(null);			// 将第一个按钮设为不带图像的按钮
		emptyButton = imageButton[0][0];		// 将空白按钮对象指向不带图像的按钮
		
		return imageButton;
	}
	
	/** 向组件中添加按钮的方法*/
	public void addButton(JButton[][] imageButton, JPanel centerPane) {
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				centerPane.add(imageButton[i][j]);
	}
	
	/** 创建菜单栏*/
	private JMenuBar createMenuBar() {
		JMenu[] m = {new JMenu("开始(B)"), new JMenu("关于(A)")};				// 创建两个菜单
		JMenuBar mBar = new JMenuBar();				// 创建一个菜单栏对象
		
		// this.setJMenuBar(mBar);
		mBar.add(m[0]); 						// 为菜单栏添加第一个菜单
		mBar.add(m[1]);						// 为菜单栏添加第二个菜单
		m[0].setMnemonic('B'); 			// 设置快捷键
		m[1].setMnemonic('A'); 			// 设置快捷键
		initMenuBegin(m);					// 初始化“开始”菜单
		initMenuAbout(m);					// 初始化“关于”菜单
		
		return mBar;
	}
	
	/** 初始化“开始”菜单*/
	private void initMenuBegin(JMenu[] m) {
		JMenuItem[] mI = {			// 创建子菜单项
				new JMenuItem("新开局(N)"),
				new JMenuItem("退出(E)")
		};
		
		mI[0].setMnemonic('N'); 				// 设置子菜单项的快捷键
		mI[1].setMnemonic('E'); 				// 设置子菜单项的快捷键
		
		mI[0].setAccelerator(KeyStroke.getKeyStroke("ctrl N")); 				// 设置子菜单项的加速键
		mI[1].setAccelerator(KeyStroke.getKeyStroke("ctrl E")); 				// 设置子菜单项的加速键
		
		mI[0].addActionListener(new ActionListener() {				// 为“新开局”菜单项添加事件监听器
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuNewClick();				// 调用方法进行响应	
			}
		});
		
		mI[1].addActionListener(new ActionListener() {				// 为“退出”菜单项添加事件监听器
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				// 退出程序
			}
		});
		
		m[0].add(mI[0]);				// 将第一个子菜单项添加到菜单中
		m[0].add(mI[1]);				// 将第二个子菜单项添加到菜单中
		m[0].insertSeparator(1);   // 插入分隔线
	}
	
	/** 响应用户单击“新开局”菜单项的方法*/
	private void menuNewClick() {
		this.getContentPane().remove(centerPane); 			// 移除当前拼接图面板
		this.centerPane = this.createCenterPane();			// 创建一个新的拼接图面板
		this.getContentPane().add(this.centerPane, BorderLayout.CENTER);
		this.validate(); 			// 重新布置组件
	}
	
	/** 初始化“关于”菜单*/
	private void initMenuAbout(JMenu[] m) {
		JMenuItem[] mI = {new JMenuItem("游戏说明(H)"), new JMenuItem("关于作者(A)")};
		
		mI[0].setMnemonic('H');				// 设置子菜单项的快捷键
		mI[0].setMnemonic('A');				// 设置子菜单项的快捷键
		mI[0].setAccelerator(KeyStroke.getKeyStroke("F1"));
		
		mI[0].addActionListener(new ActionListener() {				// 当单击“游戏说明”菜单时
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String help0 = "移动小图片，组合成如右边所示原始图像。\n\n";
				String help1 = "操作方法：在邻近空白图片上单击，将其位置与空白图片位置互换。";
				JOptionPane.showMessageDialog(null, help0 + help1); 			// 显示消息对话框
			}
		});
		
		mI[1].addActionListener(new ActionListener() {				// 当单击“关于作者”菜单时
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String version = "版本：1.0\n";
				String author = "作者：程伟\n";
				String email = "E-mail：shengexing1995@163.com";
				JOptionPane.showMessageDialog(null, version + author + email);
			}
		});
		
		m[1].add(mI[0]);				// 将第一个子菜单项添加到菜单中
		m[1].add(mI[1]);				// 将第二个子菜单项添加到菜单中
	}
	
	/**
	 * 内部类，充当监听器
	 */
	class ImgButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ImageButton clickButton = (ImageButton)e.getSource();				// 获得被单击的按钮对象
			
			int clickRow = clickButton.getRow();				// 获得被单击的按钮所在的行
			int clickCol = clickButton.getCol();					// 获得被单击的按钮所在的列
			int emptyRow = emptyButton.getRow();			// 获得空白按钮所在的行
			int emptyCol = emptyButton.getCol();				// 获得空白按钮所在的列
			
			// 判断被单击按钮与空白按钮是否相邻
			if(Math.abs(clickRow - emptyRow) + Math.abs(clickCol - emptyCol) == 1) {
				// 将被单击按钮的图片移动到空白按钮上
				emptyButton.setIcon(clickButton.getIcon());
				
				// 将被单击的按钮的图片设置为空
				clickButton.setIcon(null);
				
				// 将空白按钮指向被单击的按钮，设置新的空白按钮
				emptyButton = clickButton;
			}
		}
		
	}

	/** 主方法*/
	public static void main(String[] args) {
		PuzzleGame game = new PuzzleGame();
	}

}
