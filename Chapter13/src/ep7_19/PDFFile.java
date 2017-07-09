//�½�7.18          ����PDF�ļ�
package ep7_19;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class PDFFile {
	/**
	 * дPDF�ļ���չʾ��PDF�ĵ����½ڡ�С�ڡ����塢���䡢����б��ʹ��
	 * ���չʾ���ʹ��д������
	 */
	public void writePDF(String fileName) {
		File file=new File(fileName);
		FileOutputStream out=null;
		try {
			//��1��ʵ�����ĵ�����
			//��һ��������ҳ���С���������Ĳ����ֱ������ҡ��Ϻ���ҳ�߾ࡣ
			Document document=new Document(PageSize.A4, 50, 50, 50, 50);
			
			//��2������д��������һ�������Ƕ��ĵ����������
			//�ڶ���������������ļ�����out��document��������
			out=new FileOutputStream(file);
			PdfWriter writer=PdfWriter.getInstance(document, out); 
			//���ĵ�׼��д������
			document.open();
			
			//��3�����洴���½ڶ���
			//���ȴ������������Ϊ�½ڵı��⡣FontFactory����ָ�����������
			Font font=FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new Color(0, 0, 255));
			Paragraph chapter1_title=new Paragraph("Chapter 1", font);
			//������һ���½ڶ��󣬱���Ϊ��Chapter 1��
			Chapter chapter1=new Chapter(chapter1_title, 1);
			//����ż�����Ϊ0�Ͳ�����ҳ������ʾ�½ڱ��
			chapter1.setNumberDepth(0);
			
			//��4������С�ڶ���
			font=FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new Color(255, 0, 0));
			//����С�ڶ���ı���
			Paragraph section1_title1=new Paragraph("Section 1 of Chapter 1", font);
			//����һ��С�ڶ��󣬱���Ϊ"This is Section 1 in Chapter 1"������chapter1��
			Section section1=chapter1.addSection(section1_title1);
			
			//��5����С����д�ı�����
			Paragraph text=new Paragraph("This is the first text in section 1 of chapter 1.");
			section1.add(text);
			text=new Paragraph("Following is a 5x5 table:");
			section1.add(text);
			
			//��6����С����д���
			Table table=new Table(5, 5);        //����������
			table.setBorderColor(new Color(220, 255, 100));          //���ñ��߿���ɫ
			//���õ�Ԫ��ı߾�����
			table.setPadding(1);
			table.setSpacing(1);
			table.setBorderWidth(1);
			Cell cell=null;        //��Ԫ�����
			//��ӱ�ͷ��Ϣ
			for(int colNum=0; colNum<5; colNum++) {
				cell=new Cell("header-"+colNum);
				cell.setHeader(true);
				table.addCell(cell);
			}
			table.endHeaders();
			//��ӱ������
			for(int rowNum=1; rowNum<5; rowNum++) {
				for(int colNum=0; colNum<5; colNum++) {
					cell=new Cell("value-"+rowNum+"-"+colNum);
					table.addCell(cell);
				}
			}
			section1.add(table);   //����������ӵ�С�ڶ�����
			
			//��7������б�
			//�б����һ��������ListItem�����Զ��б���б�ţ�Ҳ���Բ����
			//����һ����������Ϊtrue�����봴��һ�����б�ŵ��б�
			//�ڶ�����������Ϊtrue�����б������ĸ���б�ţ�Ϊfalse�������ֽ��б��
			//����������Ϊ�б���������֮��ľ���
			List list=new List(true, false, 20);
			ListItem item=new ListItem("First item of list;");
			list.add(item);
			item=new ListItem("Second item of list;");
			list.add(item);
			item=new ListItem("Third item of list.");
			list.add(item);
			section1.add(list);          //���б������ӵ�С�ڶ�����
			
			//��8���������
			//������PDF��д�����ģ��������ļ�����classPath��
			//simfang.ttf��һ�����������ļ�
			BaseFont bfChinese=BaseFont.createFont("STSong-Light", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			//���Ĵ�СΪ20���Ӵ�
			font=new Font(bfChinese, 20, Font.BOLD);
			text=new Paragraph("PDF ���Ĳ���", font);
			section1.add(text);
			
			//��9�����½ڶ�����뵽�ĵ���
			document.add(chapter1);
			
			//��10���ر��ĵ�
			document.close();
			System.out.println("PDF�ļ����ɳɹ���PDF�ļ�����"+file.getAbsolutePath());
		} catch(DocumentException e) {
			System.out.println("PDF�ļ�"+file.getAbsolutePath()+"����ʧ�ܣ�"+e);
			e.printStackTrace();
		} catch(IOException ee) {
			System.out.println("PDF�ļ�"+file.getAbsolutePath()+"����ʧ�ܣ�"+ee);
			ee.printStackTrace();
		} finally {
			if(out!=null) {
				try {
					//�ر�����ļ���
					out.close();
				} catch(IOException e1) {
					
				}
			}
		}
	}
	
	/**
	 * ��PDF�ļ���ʹ����pdfbox��Դ��Ŀ���µİ汾�Ѿ�֧��������
	 * ��www.padbox.org���ض�PDF��jar��
	 */
	public void readPDF(String fileName) {
		File file=new File(fileName);
		FileInputStream in=null;
		try {
			in=new FileInputStream(fileName);
			//�½�һ��PDF����������
			PDFParser parser=new PDFParser(in);
			//��PDF�ļ����н���
			parser.parse();
			//��ȡ������õ���PDF�ĵ�����
			PDDocument pdfdocument=parser.getPDDocument();
			//�½�һ��PDF�ı�������
			PDFTextStripper stripper=new PDFTextStripper();
			//��PDF�ĵ��а����ı�
 
			System.out.println("PDF�ļ�"+file.getAbsolutePath()+"���ı��������£�");
			//System.out.println(result);
		} catch(Exception e) {
			System.out.println("��ȡPDF�ļ�"+file.getAbsolutePath()+"ʧ�ܣ�"+e);
			e.printStackTrace();
		} finally {
			if(in!=null) {
				try {
					in.close();
				} catch(IOException e1) {
					
				}
			}
		}
	}

	public static void main(String[] args) {
		PDFFile pdf=new PDFFile();
		String fileName="./src/ep7_19/test.pdf";
		pdf.writePDF(fileName);
		pdf.readPDF(fileName);
	}

}
