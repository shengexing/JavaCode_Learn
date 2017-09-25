// 章节17.02.2            使用ImageIcon加载图片并显示
package ex17_02_2;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Sample17_2 extends JFrame{

	// 窗体构造器
	public Sample17_2() {
		// 创建文件打开对话框
		JFileChooser jfc = new JFileChooser("d:\\");
		
		// 创建jpg、gif文件类型过滤器
		FileFilter filterJpeg = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
		
		FileFilter filterGif = new FileNameExtensionFilter("GIF file", "gif");
		
		// 删除默认的文件扩展类型过滤器
		jfc.removeChoosableFileFilter(jfc.getFileFilter());
		
		// 为文件对话框设置扩展过滤器
		jfc.addChoosableFileFilter(filterGif);
		jfc.addChoosableFileFilter(filterJpeg);
		
		// 显示文件对话框
		jfc.showDialog(this, "请选择要打开的图片");
		
		// 获取图片文件路径
		String path = jfc.getSelectedFile().getAbsolutePath();
		
		// 创建图标对象
		Icon icon = new ImageIcon(path);
		
		// 创建用于显示图标的标签
		JLabel jl = new JLabel(icon, JLabel.CENTER);
		
		// 将标签添加进滚动窗体中
		JScrollPane jsp = new JScrollPane(jl);
		
		// 将滚动窗体添加进窗体中
		this.add(jsp);
		
		// 设置窗体的关闭动作、标题、大小位置以及可见性
		this.setTitle("图片加载显示演示");
		this.setBounds(100, 100, 640, 540);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// 主方法
	public static void main(String[] args) {
		// 创建Sample17_3窗体对象
		new Sample17_2();

	}

}
