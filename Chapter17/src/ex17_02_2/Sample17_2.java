// �½�17.02.2            ʹ��ImageIcon����ͼƬ����ʾ
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

	// ���幹����
	public Sample17_2() {
		// �����ļ��򿪶Ի���
		JFileChooser jfc = new JFileChooser("d:\\");
		
		// ����jpg��gif�ļ����͹�����
		FileFilter filterJpeg = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
		
		FileFilter filterGif = new FileNameExtensionFilter("GIF file", "gif");
		
		// ɾ��Ĭ�ϵ��ļ���չ���͹�����
		jfc.removeChoosableFileFilter(jfc.getFileFilter());
		
		// Ϊ�ļ��Ի���������չ������
		jfc.addChoosableFileFilter(filterGif);
		jfc.addChoosableFileFilter(filterJpeg);
		
		// ��ʾ�ļ��Ի���
		jfc.showDialog(this, "��ѡ��Ҫ�򿪵�ͼƬ");
		
		// ��ȡͼƬ�ļ�·��
		String path = jfc.getSelectedFile().getAbsolutePath();
		
		// ����ͼ�����
		Icon icon = new ImageIcon(path);
		
		// ����������ʾͼ��ı�ǩ
		JLabel jl = new JLabel(icon, JLabel.CENTER);
		
		// ����ǩ��ӽ�����������
		JScrollPane jsp = new JScrollPane(jl);
		
		// ������������ӽ�������
		this.add(jsp);
		
		// ���ô���Ĺرն��������⡢��Сλ���Լ��ɼ���
		this.setTitle("ͼƬ������ʾ��ʾ");
		this.setBounds(100, 100, 640, 540);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// ������
	public static void main(String[] args) {
		// ����Sample17_3�������
		new Sample17_2();

	}

}
