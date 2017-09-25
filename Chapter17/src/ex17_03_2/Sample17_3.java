// �½�17.03.2            ʹ��GIF��������ָ��JPEGͼ�����±���ΪGIF��ʽͼƬ������
package ex17_03_2;

import java.awt.Image;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.squareup.gifencoder.GifEncoder;


public class Sample17_3 {

	public static void main(String[] args) throws Exception{
		// �����ļ��򿪶Ի���
		JFileChooser jfc = new JFileChooser("d:\\");
		
		// ����jpg�ļ����͹�����
		FileFilter filterJpeg = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
		
		// ɾ��Ĭ�ϵ��ļ���չ���͹�����
		jfc.removeChoosableFileFilter(jfc.getFileFilter());
		
		// Ϊ�ļ��Ի���������չ������
		jfc.addChoosableFileFilter(filterJpeg);
		
		// ��ʾ�ļ��Ի���
		jfc.showDialog(null, "��ѡ��Ҫת����ͼƬ");
		
		// ��ȡͼƬ�ļ�·��
		String path = jfc.getSelectedFile().getAbsolutePath();
		
		// ��ȡ�ļ���
		String jpegName = jfc.getSelectedFile().getName();
		
		// �����µ�gif�ļ���
		String gifName = jpegName.substring(0, jpegName.indexOf(".")) + ".gif";
		
		// ����ͼƬ��ȡImage����
		Image image = (new ImageIcon(path)).getImage();
		System.out.println("����1��ͼƬ�ļ�" + jpegName + "���سɹ�������");
		
		// ���������
		OutputStream fout = new FileOutputStream(gifName);
		
		// ����GifEncoder����
		GifEncoder ge = new GifEncoder(fout, 100, 100, 0);
		
		
		// ���б���
		ge.finishEncoding();
		
		// ˢ�������
		fout.flush();
		
		// �ر������
		fout.close();
		
		System.out.println("����2��ͼƬ�ļ�" + gifName + "���ɳɹ�������");
	}

}
