// �½�23.04.5            ������ʾ�ο�ͼ������
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
	
	AffineTransform transform = new AffineTransform();	// ����һ������任������
	
	private double scaleX = 0.5;			// ������x���ϵ����ű���
	private double scaleY = 0.5;			// ������y���ϵ����ű���
	
	private BufferedImage destImage;			// ����Դͼ��������Ժ��ͼ��
	
	/** �������Ĺ�����*/
	public ModelPane(BufferedImage srcImage) {
		super();
		
		destImage = filterSrcImage(srcImage);			// ��ԭʼͼ��������ţ����������ź��ͼ��
		
		JLabel modelLabel = new JLabel(new ImageIcon(destImage));
		JLabel infoLabel = new JLabel("ԭʼͼ��", SwingConstants.CENTER);
		
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder(null, "", 
				TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, null, null));			// Ϊ�����ӱ߿�
		this.add(infoLabel, BorderLayout.PAGE_START);
		this.add(modelLabel, BorderLayout.CENTER);
	}
	
	/** ��ָ��ͼ���������*/
	public BufferedImage filterSrcImage(BufferedImage srcImage) {
		BufferedImage image;
		
		AffineTransform transform = new AffineTransform();			// ����һ������任������
		
		double scaleX = 0.5;				// ������x���ϵ����ű���
		double scaleY = 0.5;				// ������y���ϵ����ű���
		
		transform.setToScale(scaleX, scaleY); 		 	// ������x���y���ϵ����ű���
		
		// ����һ���յĻ�����ͼ�񣬴�С��������srcImage��ͬ
		image = new BufferedImage(srcImage.getWidth(this) / 2, 
				srcImage.getHeight(this) / 2, 
				BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = image.createGraphics();			// ��ȡimage����Ļ滭�����Ļ���
		
		// ���image������ͼ���е�����
		g2d.clearRect(0, 0, image.getWidth(this), image.getHeight(this));
		
		// ����һ������任������
		AffineTransformOp ato = new AffineTransformOp(transform, null);
		
		// ���ù���������Դͼ�񣬲����õ�����Ĵ����ͼ�����ݴ���image��
		ato.filter(srcImage, image);
		
		return image;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
