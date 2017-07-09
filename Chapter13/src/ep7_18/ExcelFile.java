//�½�7.18          ����Excel�ļ�
package ep7_18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

public class ExcelFile {
	/**
	 * �½�һ��Excel�ļ�����������5��5�е����ݣ������������߶�Ϊ2�Ĵ�Ԫ��
	 */
	public void writeExcel(String fileName) {
		//Ŀ���ļ�
		File file=new File(fileName);
		FileOutputStream fOut=null;
		try {
			//�����µ�Excel������
			HSSFWorkbook workbook=new HSSFWorkbook();
			//��Excel�������н�һ������������Ϊȱʡֵ��Ҳ����ָ��������������
			HSSFSheet sheet=workbook.createSheet("Test_Table");
			//�������壬��ɫ������
			HSSFFont font=workbook.createFont();
			font.setColor(HSSFFont.COLOR_RED);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			//������Ԫ��ĸ�ʽ������С�������
			HSSFCellStyle cellStyle=workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);    //ˮƽ�����Ͼ��ж���
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);       //��ֱ�����Ͼ��ж���
			cellStyle.setFont(font);     //��������
			
			//���潫����һ��4��3�еı�����һ��Ϊ��ͷ
			int rowNum=0;   //�б�
			int colNum=0;     //�б�
			//������ͷ��Ϣ
			HSSFRow row=sheet.createRow((short) rowNum);     //������0��λ�ô�����
			HSSFCell cell=null;   //��Ԫ��
			for(colNum=0; colNum<5; colNum++) {
				//�ڵ�ǰ�е�colNum���ϴ�����Ԫ��
				cell=row.createCell(colNum);
				//���嵥Ԫ��Ϊ�ַ����ͣ�Ҳ����ָ��Ϊ�������͡���������
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				//������뷽ʽ��Ϊ��֧�����ģ�����ʹ����ENCODING_UTF_16
				cell.setCellStyle(cellStyle);    //Ϊ��Ԫ�����ø�ʽ
				cell.setCellValue("��ͷ��-"+colNum);     //������������Ԫ��
			}
			rowNum++;
			for(; rowNum<5; rowNum++) {
				//�½���rowNum��
				row=sheet.createRow((short) rowNum);
				for(colNum=0; colNum<5; colNum++) {
					//�ڵ�ǰ�е�colNumλ�ô�����Ԫ��
					cell=row.createCell(colNum);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("ֵ-"+rowNum+"-"+colNum);
				}
			}
			
			//�ϲ���Ԫ��
			//�ȴ���2��5�еĵ�Ԫ��Ȼ����Щ��Ԫ��ϲ�Ϊ2����Ԫ��
			rowNum=5;
			for(; rowNum<7; rowNum++) {
				row=sheet.createRow((short) rowNum);
				for(colNum=0; colNum<5; colNum++) {
					//�ڵ�ǰ�е�colNumλ�ô�����Ԫ��
					cell=row.createCell(colNum);
				}
			}
			
			//������һ����Ԫ�񣬸߶�Ϊ2������Ϊ2
			rowNum=5;
			colNum=0;
			Region region=new Region(rowNum, (short) colNum, (rowNum+1), (short) (colNum+1));
			sheet.addMergedRegion(region);
			//��õ�һ��Ԫ��
			cell=sheet.getRow(rowNum).getCell(colNum);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("��һ����Ԫ��");
			
			//�����ڶ�����Ԫ�񣬸߶�Ϊ2������Ϊ3
			colNum=2;
			region=new Region(rowNum, (short) colNum, (rowNum+1), (short) (colNum+2));
			sheet.addMergedRegion(region);
			//��õڶ�����Ԫ��
			cell=sheet.getRow(rowNum).getCell(colNum);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("�ڶ�����Ԫ��");
			
			//������������ɣ����潫�����������ļ�
			//�½�һ����ļ���
			fOut=new FileOutputStream(file);
			//����Ӧ��Excel����������
			workbook.write(fOut);
			fOut.flush();
			fOut.close();    //�����������ر��ļ�
			System.out.println("Excel�ļ����ɳɹ���Excel�ļ���"+file.getAbsolutePath());
		} catch(Exception e) {
			System.out.println("Excel�ļ�"+file.getAbsolutePath()+"����ʧ�ܣ�"+e);
		}
		finally {
			if(fOut!=null) {
				try {
					fOut.close();
				} catch(IOException e1) {
					
				}
			}
		}
	}
	
	/**
	 * ��Excel�ļ�����
	 */
	public void readExcel(String fileName) {
		File file=new File(fileName);
		FileInputStream in=null;
		try {
			//������Excel�������ļ�������
			in=new FileInputStream(file);
			HSSFWorkbook workbook=new HSSFWorkbook(in);
			//�����Թ����������ã�����ʹ�ð�������
			HSSFSheet sheet=workbook.getSheet("Test_Table");  //Ҳ����getSheetAt(int index)����������
			//��Excel�ĵ��У���һ�Ź�������ȱʡ������0��������ǣ�HSSFSheet sheet=workbook.getSheetAt(0);
			//�����ȡExcel��ǰ5�е�����
			System.out.println("������Excel�ļ�"+file.getAbsolutePath()+"�����ݣ�");
			HSSFRow row=null;
			HSSFCell cell=null;
			int rowNum=1;    //�б�
			int colNum=0;      //�б�
			for(; colNum<5; colNum++) {
				row=sheet.getRow(0);
				cell=row.getCell(colNum);
				System.out.print(cell.getStringCellValue()+"\t\t");
			}
			System.out.println();
			for(; rowNum<5; rowNum++) {
				//��ȡ��rowNum��
				row=sheet.getRow(rowNum);
				for(colNum=0; colNum<5; colNum++) {
					//��ȡ��ǰ�е�colNumλ�õĵ�Ԫ��
					cell=row.getCell(colNum);
					System.out.print(cell.getStringCellValue()+"\t\t\t");
				}
				System.out.println();     //����
			}
			in.close();
		} catch(IOException e) {
			System.out.println("��ȡExcel�ļ�"+file.getAbsolutePath()+"ʧ�ܣ�"+e);
		} finally {
			if(in!=null) {
				try {
					in.close();
				} catch(IOException e1) {
					
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ExcelFile excel=new ExcelFile();
		String fileName="./src/ep7_18/test.xls";
		excel.writeExcel(fileName);
		excel.readExcel(fileName);
	}
}