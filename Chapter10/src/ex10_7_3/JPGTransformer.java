//�½�10.7.3                        ����ͼƬ    
package ex10_7_3;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JPGTransformer {
	
	private boolean isInitFlag=false;          //�����Ƿ��Ѿ���ʼ��
	
	//����Ŀ��ͼƬ�Ŀ�Ⱥ͸߶ȣ�������һ���Ϳ���
	private int targetPicWidth=0;
	private int targetPicHeight=0;
	private double picScale=0;             //����Ŀ��ͼƬ�����ԭͼƬ�ı���
	
	/*���캯��*/
	public JPGTransformer() {
		this.isInitFlag=false;
	}
	
	/*����JPGͼƬ������*/
	public void resetJPGTransformer() {
		this.picScale=0;
		this.targetPicWidth=0;
		this.targetPicHeight=0;
		this.isInitFlag=false;
	}
	
	/*����Ŀ��ͼƬ�����ԴͼƬ�����ű���*/
	public void setPicScale(double scale) throws JPGException {
		if(scale<=0) {
			throw new JPGException("���ű�������Ϊ0�͸�����");
		}
		
		this.resetJPGTransformer();
		this.picScale=scale;
		this.isInitFlag=true;
	}

	/*����Ŀ��ͼƬ�Ŀ��*/
	public void SetSmallWidth(int width) throws JPGException {
		if(width<=0) {
			throw new JPGException("���ű�������Ϊ0�͸�����");
		}
		
		this.resetJPGTransformer();
		this.targetPicWidth=width;
		this.isInitFlag=true;
	}
	
	/*����Ŀ��ͼƬ�ĸ߶�*/
	public void SetSmallHeight(int height) throws JPGException {
		if(height<=0) {
			throw new JPGException("���ű�������Ϊ0�͸�����");
		}
		
		this.resetJPGTransformer();
		this.targetPicWidth=height;
		this.isInitFlag=true;
	}
	
	/*��ʼ����ͼƬ
	 * @param srcPicFileName                ԴͼƬ���ļ���
	 * @param targetPicFileName            ����Ŀ��ͼƬ���ļ���
	 * @throws JPGException                  ����ʱ�������쳣
	 * */
	
	public void transform(String srcPicFileName, String targetPicFileName) throws JPGException {
		if(!this.isInitFlag) {
			throw new JPGException("�������û�г�ʼ����");
		}
		if(srcPicFileName==null||targetPicFileName==null) {
			throw new JPGException("�����ļ�����·��Ϊ�գ�");
		}
		if((!srcPicFileName.toLowerCase().endsWith("jpg"))&&(!srcPicFileName.toLowerCase().endsWith("jpeg"))) {
			throw new JPGException("ֻ�ܴ���JPG/JPEG�ļ���");
		}
		if((!targetPicFileName.toLowerCase().endsWith("jpg"))&&(!targetPicFileName.toLowerCase().endsWith("jpeg"))) {
			throw new JPGException("ֻ�ܴ���JPG/JPEG�ļ�");
		}
		
		//�½�ԴͼƬ������ͼƬ���ļ�����
		File fin=new File(srcPicFileName);
		File fout=new File(targetPicFileName);
		BufferedImage bSrc=null;          //ͨ���������ԴͼƬ�ļ�
		try {
			//��ȡ�ļ�����BufferedImage
			bSrc=ImageIO.read(fin);
		} catch(IOException ex) {
			throw new JPGException("��ȡԴͼ���ļ�����");
		}
		
		//ԴͼƬ�Ŀ�Ⱥ͸߶�
		int srcW=bSrc.getWidth();
		int srcH=bSrc.getHeight();
		
		//����Ŀ��ͼƬ��ʵ�ʿ�Ⱥ͸߶�
		int targetW=0;
		int targetH=0;
		if(this.targetPicWidth!=0) {
			//�����趨�Ŀ���������
			targetW=this.targetPicWidth;
			targetH=(targetW*srcH)/srcW;
		}
		else if(this.targetPicHeight!=0) {
			//�����趨�ĳ���������
			targetH=this.targetPicHeight;
			targetW=(targetH*srcW)/srcH;
		}
		else if(this.picScale!=0) {
			//�������õ����ű�������ͼ��ĳ��Ϳ�
			targetW=(int) ((float)srcW*this.picScale);
			targetH=(int) ((float)srcH*this.picScale);
		}
		else {
			throw new JPGException("���������ʼ������ȷ��");
		}
		
		System.out.println("ԴͼƬ�ķֱ��ʣ�"+srcW+"X"+srcH);
		System.out.println("Ŀ��ͼƬ�ķֱ��ʣ�"+targetW+"X"+targetH);
		
		//Ŀ��ͼƬ�Ļ������
		BufferedImage bTarget=new BufferedImage(targetW,targetH,BufferedImage.TYPE_3BYTE_BGR);
		//���Ŀ��ͼƬ��ԴͼƬ��ȡ��߶ȵı���
		double sx=(double) targetW/srcW;
		double sy=(double) targetH/srcH;
		
		AffineTransform transform=new AffineTransform();            //����ͼ��任����
		transform.setToScale(sx, sy);         //����ͼ��ת���ı���
		
		//����ͼ��ת����������
		AffineTransformOp ato=new AffineTransformOp(transform,null);
		ato.filter(bSrc,bTarget);            //ʵ��ת������bSrcת����bTarget
		
		//���Ŀ��ͼƬ
		try {
			//��Ŀ��ͼƬ��BufferedImageд���ļ���ȥ��jpegΪͼƬ�ĸ�ʽ
			ImageIO.write(bTarget, "jpeg", fout);
		} catch(IOException ex1) {
			throw new JPGException("д������ͼ���ļ�����");
		}
	}
	public static void main(String[] args) throws JPGException {
		JPGTransformer jpg=new JPGTransformer();
		//��ԭͼƬ��Сһ��
		jpg.setPicScale(0.5);
		String srcFileName="scenery.jpg";
		String targetFileName="scenery_new.jpg";
		jpg.transform(srcFileName, targetFileName);
		// TODO �Զ����ɵķ������

	}

}
