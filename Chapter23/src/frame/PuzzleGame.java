// �½�23.04.2            �Զ��尴ť���
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
	
	public final static int TYPE = 1;			// ������Ϸ�Ѷ����ͣ�����չ
	public static final int[] level = {50, 100};			// ���ò��ͼ��Ĵ�С�����أ�����С��������Ϸ�����׶�
	
	int len;			// ����Ժ�Сͼ��ĳ��ȺͿ�ȣ�������Ϊ��λ��
	int row, col;			// ƴͼ������������
	
	private JPanel centerPane;												// ����ƴͼ��ť�������
	private JPanel modelPane;											// ������ʾ�ο�ͼ������
	private BufferedImage image = null;								// Ҫƴ�ӵ�ԭͼ
	private JMenuBar mBar;												// �����˵�������
	private ImageButton emptyButton;								// �����հװ�ť����
	private String filename = "background/game.jpg";				// Ҫƴ�ӵ�ͼƬ��·��
	
	/** Ĭ�ϵĹ�����*/
	public PuzzleGame() {
		super();																		// ���ó���JFrame�Ĺ�����
		setResizable(false);														//	����������Ϊ���ɸı��С
		setTitle("ƴͼ��Ϸ");														// ���ô������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// ���ùرմ���ʱ�˳�����
		
		this.len = level[TYPE];					// ����Ҫ��ֵ�ͼ��Ĵ�С
		this.image = loadImage();				// ����ԭʼͼ��
		
		setRowAndCol();				// ����Ҫƴ�ӵ��к���
		
		this.centerPane = this.createCenterPane();										//	����ƴ�����
		this.getContentPane().add(centerPane, BorderLayout.CENTER);
		this.modelPane = new ModelPane(this.image);									// ������ʾ�ο�ͼ������
		this.getContentPane().add(modelPane, BorderLayout.LINE_END);	
		this.mBar = this.createMenuBar();														// �����˵���
		this.setJMenuBar(mBar);																	// ���ò˵���
		
		this.pack();				// �����������ѡ��С����
		
		this.setLocation(			// ���ó������������Ļ����λ��
				this.getToolkit().getScreenSize().width / 2 - this.getWidth() / 2, 
				this.getToolkit().getScreenSize().height / 2 - this.getHeight() / 2);
		
		this.setVisible(true);				// ��ʾ����
		
	}
	
	/** ����ͼ��*/
	public BufferedImage loadImage() {
		BufferedImage image = null;
		
		try {
			File f =new File(filename);
			System.out.println(f.getAbsolutePath());
			image = ImageIO.read(f);
		} catch (IOException e) {
			System.err.print("����ͼ����󣡣���\n");
		}
		
		return image;
	}
	
	/** ����ͼ�������������*/
	public void setRowAndCol() {
		// �������ͼ��ɹ����Ȳ�Ϊnull
		if(this.image != null) {
			this.col = image.getWidth() / this.len;
			this.row = image.getHeight() / this.len;
		} else {
			this.row = 0;
			this.col = 0;
		}
	}
	
	/** ���ͼ��*/
	public ArrayList<BufferedImage> dividImage(BufferedImage image) {
		ArrayList<BufferedImage> subimage = new ArrayList<BufferedImage>(this.row * this.col);
		
		for(int i = 0; i < this.row; i++)
			for(int j = 0; j < this.col; j++)
				subimage.add((i * this.col + j), image.getSubimage(j * len, i * len, len, len));
		
		BufferedImage firstImage = subimage.remove(0);			// �Ƴ���һ��ͼƬ
		Collections.shuffle(subimage); 				// ��ͼ��̬������������
		subimage.add(0, firstImage);
		
		return subimage;
	}
	
	/** ����ƴ��ͼ���*/
	private JPanel createCenterPane() {
		JPanel centerPane = new JPanel();
		
		centerPane.setBorder(new TitledBorder(null, "", 
				TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, null, null));		// Ϊ�����ӱ߿�
		
		// ����ƴ��ͼ���Ĵ�С���к�������
		centerPane.setLayout(new GridLayout(row, col, 0, 0));
		JButton[][] imageButton = this.createImgButton();			// ����Ҫƴ�ӵİ�ť
		this.addButton(imageButton, centerPane);							// ���������Ӱ�ť
		
		return centerPane;
	}
	
	/** ������ť��������*/
	public ImageButton[][] createImgButton() {
		ArrayList<BufferedImage> images = this.dividImage(this.image);	// ���ԭʼͼ��
		
		// �����浽���鵱��
		ImageButton[][] imageButton = new ImageButton[this.row][this.col];
		for(int row = 0; row < this.row; row++)
			for(int col = 0; col < this.col; col++) {
				imageButton[row][col] = new ImageButton(new ImageIcon(images.get(row * this.col + col)));
				imageButton[row][col].setRow(row);
				imageButton[row][col].setCol(col);
				imageButton[row][col].setPreferredSize(new Dimension(len, len));		// ���ð�ť����ѡ��С
				imageButton[row][col].addActionListener(new ImgButtonAction());
			}
		
		imageButton[0][0].setIcon(null);			// ����һ����ť��Ϊ����ͼ��İ�ť
		emptyButton = imageButton[0][0];		// ���հװ�ť����ָ�򲻴�ͼ��İ�ť
		
		return imageButton;
	}
	
	/** ���������Ӱ�ť�ķ���*/
	public void addButton(JButton[][] imageButton, JPanel centerPane) {
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				centerPane.add(imageButton[i][j]);
	}
	
	/** �����˵���*/
	private JMenuBar createMenuBar() {
		JMenu[] m = {new JMenu("��ʼ(B)"), new JMenu("����(A)")};				// ���������˵�
		JMenuBar mBar = new JMenuBar();				// ����һ���˵�������
		
		// this.setJMenuBar(mBar);
		mBar.add(m[0]); 						// Ϊ�˵�����ӵ�һ���˵�
		mBar.add(m[1]);						// Ϊ�˵�����ӵڶ����˵�
		m[0].setMnemonic('B'); 			// ���ÿ�ݼ�
		m[1].setMnemonic('A'); 			// ���ÿ�ݼ�
		initMenuBegin(m);					// ��ʼ������ʼ���˵�
		initMenuAbout(m);					// ��ʼ�������ڡ��˵�
		
		return mBar;
	}
	
	/** ��ʼ������ʼ���˵�*/
	private void initMenuBegin(JMenu[] m) {
		JMenuItem[] mI = {			// �����Ӳ˵���
				new JMenuItem("�¿���(N)"),
				new JMenuItem("�˳�(E)")
		};
		
		mI[0].setMnemonic('N'); 				// �����Ӳ˵���Ŀ�ݼ�
		mI[1].setMnemonic('E'); 				// �����Ӳ˵���Ŀ�ݼ�
		
		mI[0].setAccelerator(KeyStroke.getKeyStroke("ctrl N")); 				// �����Ӳ˵���ļ��ټ�
		mI[1].setAccelerator(KeyStroke.getKeyStroke("ctrl E")); 				// �����Ӳ˵���ļ��ټ�
		
		mI[0].addActionListener(new ActionListener() {				// Ϊ���¿��֡��˵�������¼�������
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuNewClick();				// ���÷���������Ӧ	
			}
		});
		
		mI[1].addActionListener(new ActionListener() {				// Ϊ���˳����˵�������¼�������
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				// �˳�����
			}
		});
		
		m[0].add(mI[0]);				// ����һ���Ӳ˵�����ӵ��˵���
		m[0].add(mI[1]);				// ���ڶ����Ӳ˵�����ӵ��˵���
		m[0].insertSeparator(1);   // ����ָ���
	}
	
	/** ��Ӧ�û��������¿��֡��˵���ķ���*/
	private void menuNewClick() {
		this.getContentPane().remove(centerPane); 			// �Ƴ���ǰƴ��ͼ���
		this.centerPane = this.createCenterPane();			// ����һ���µ�ƴ��ͼ���
		this.getContentPane().add(this.centerPane, BorderLayout.CENTER);
		this.validate(); 			// ���²������
	}
	
	/** ��ʼ�������ڡ��˵�*/
	private void initMenuAbout(JMenu[] m) {
		JMenuItem[] mI = {new JMenuItem("��Ϸ˵��(H)"), new JMenuItem("��������(A)")};
		
		mI[0].setMnemonic('H');				// �����Ӳ˵���Ŀ�ݼ�
		mI[0].setMnemonic('A');				// �����Ӳ˵���Ŀ�ݼ�
		mI[0].setAccelerator(KeyStroke.getKeyStroke("F1"));
		
		mI[0].addActionListener(new ActionListener() {				// ����������Ϸ˵�����˵�ʱ
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String help0 = "�ƶ�СͼƬ����ϳ����ұ���ʾԭʼͼ��\n\n";
				String help1 = "�������������ڽ��հ�ͼƬ�ϵ���������λ����հ�ͼƬλ�û�����";
				JOptionPane.showMessageDialog(null, help0 + help1); 			// ��ʾ��Ϣ�Ի���
			}
		});
		
		mI[1].addActionListener(new ActionListener() {				// ���������������ߡ��˵�ʱ
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String version = "�汾��1.0\n";
				String author = "���ߣ���ΰ\n";
				String email = "E-mail��shengexing1995@163.com";
				JOptionPane.showMessageDialog(null, version + author + email);
			}
		});
		
		m[1].add(mI[0]);				// ����һ���Ӳ˵�����ӵ��˵���
		m[1].add(mI[1]);				// ���ڶ����Ӳ˵�����ӵ��˵���
	}
	
	/**
	 * �ڲ��࣬�䵱������
	 */
	class ImgButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ImageButton clickButton = (ImageButton)e.getSource();				// ��ñ������İ�ť����
			
			int clickRow = clickButton.getRow();				// ��ñ������İ�ť���ڵ���
			int clickCol = clickButton.getCol();					// ��ñ������İ�ť���ڵ���
			int emptyRow = emptyButton.getRow();			// ��ÿհװ�ť���ڵ���
			int emptyCol = emptyButton.getCol();				// ��ÿհװ�ť���ڵ���
			
			// �жϱ�������ť��հװ�ť�Ƿ�����
			if(Math.abs(clickRow - emptyRow) + Math.abs(clickCol - emptyCol) == 1) {
				// ����������ť��ͼƬ�ƶ����հװ�ť��
				emptyButton.setIcon(clickButton.getIcon());
				
				// ���������İ�ť��ͼƬ����Ϊ��
				clickButton.setIcon(null);
				
				// ���հװ�ťָ�򱻵����İ�ť�������µĿհװ�ť
				emptyButton = clickButton;
			}
		}
		
	}

	/** ������*/
	public static void main(String[] args) {
		PuzzleGame game = new PuzzleGame();
	}

}
