// 章节23.04.5            创建显示参考图像的面板
package frame;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class ModelPane extends JPanel {
	
	AffineTransform transform = new AffineTransform();	// 声明一个仿射变换过滤器
	
	private double scaleX = 0.5;			// 声明在x轴上的缩放比例
	private double scaleY = 0.5;			// 声明在y轴上的缩放比例
	
	private BufferedImage destImage;			// 声明源图像和缩放以后的图像
	
	/** 含参数的构造器*/
	public ModelPane(BufferedImage srcImage) {
		super();
		
		destImage = filterSrcImage(srcImage);			// 对原始图像进行缩放，并返回缩放后的图像
		
		JLabel modelLabel = new JLabel(new ImageIcon(destImage));
		JLabel infoLabel = new JLabel("原始图像", SwingConstants.CENTER);
		
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder(null, "", 
				TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, null, null));			// 为面板添加边框
		this.add(infoLabel, BorderLayout.PAGE_START);
		this.add(modelLabel, BorderLayout.CENTER);
	}
	
	/** 对指定图像进行缩放*/
	public BufferedImage filterSrcImage(BufferedImage srcImage) {
		BufferedImage image;
		
		AffineTransform transform = new AffineTransform();			// 声明一个仿射变换过滤器
		
		double scaleX = 0.5;				// 声明在x轴上的缩放比例
		double scaleY = 0.5;				// 声明在y轴上的缩放比例
		
		transform.setToScale(scaleX, scaleY); 		 	// 设置在x轴和y轴上的缩放比例
		
		// 另创建一个空的缓冲区图像，大小和类型与srcImage相同
		image = new BufferedImage(srcImage.getWidth(this) / 2, 
				srcImage.getHeight(this) / 2, 
				BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = image.createGraphics();			// 获取image对象的绘画上下文环境
		
		// 清空image缓冲区图像中的数据
		g2d.clearRect(0, 0, image.getWidth(this), image.getHeight(this));
		
		// 创建一个仿射变换过滤器
		AffineTransformOp ato = new AffineTransformOp(transform, null);
		
		// 利用过滤器过滤源图像，并将得到解决的处理后图像数据存入image中
		ato.filter(srcImage, image);
		
		return image;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
