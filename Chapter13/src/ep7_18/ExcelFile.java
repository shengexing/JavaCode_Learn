//章节7.18          操作Excel文件
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
	 * 新建一个Excel文件，里面添加5行5列的内容，再添加两个高度为2的大单元格
	 */
	public void writeExcel(String fileName) {
		//目标文件
		File file=new File(fileName);
		FileOutputStream fOut=null;
		try {
			//创建新的Excel工作簿
			HSSFWorkbook workbook=new HSSFWorkbook();
			//在Excel工作簿中建一工作表，其名为缺省值。也可以指定工作表的名字
			HSSFSheet sheet=workbook.createSheet("Test_Table");
			//创建字体，红色、粗体
			HSSFFont font=workbook.createFont();
			font.setColor(HSSFFont.COLOR_RED);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			//创建单元格的格式，如居中、左对齐等
			HSSFCellStyle cellStyle=workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);    //水平方向上居中对齐
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);       //垂直方向上居中对齐
			cellStyle.setFont(font);     //设置字体
			
			//下面将建立一个4行3列的表。第一行为表头
			int rowNum=0;   //行标
			int colNum=0;     //列标
			//建立表头信息
			HSSFRow row=sheet.createRow((short) rowNum);     //在索引0的位置创建行
			HSSFCell cell=null;   //单元格
			for(colNum=0; colNum<5; colNum++) {
				//在当前行的colNum列上创建单元格
				cell=row.createCell(colNum);
				//定义单元格为字符类型，也可以指定为日期类型、数字类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				//定义编码方式，为了支持中文，这里使用了ENCODING_UTF_16
				cell.setCellStyle(cellStyle);    //为单元格设置格式
				cell.setCellValue("表头名-"+colNum);     //添加内容至单元格
			}
			rowNum++;
			for(; rowNum<5; rowNum++) {
				//新建第rowNum行
				row=sheet.createRow((short) rowNum);
				for(colNum=0; colNum<5; colNum++) {
					//在当前行的colNum位置创建单元格
					cell=row.createCell(colNum);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("值-"+rowNum+"-"+colNum);
				}
			}
			
			//合并单元格
			//先创建2行5列的单元格，然后将这些单元格合并为2个大单元格
			rowNum=5;
			for(; rowNum<7; rowNum++) {
				row=sheet.createRow((short) rowNum);
				for(colNum=0; colNum<5; colNum++) {
					//在当前行的colNum位置创建单元格
					cell=row.createCell(colNum);
				}
			}
			
			//建立第一个大单元格，高度为2，宽度为2
			rowNum=5;
			colNum=0;
			Region region=new Region(rowNum, (short) colNum, (rowNum+1), (short) (colNum+1));
			sheet.addMergedRegion(region);
			//获得第一大单元格
			cell=sheet.getRow(rowNum).getCell(colNum);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("第一个大单元格");
			
			//建立第二个大单元格，高度为2，宽度为3
			colNum=2;
			region=new Region(rowNum, (short) colNum, (rowNum+1), (short) (colNum+2));
			sheet.addMergedRegion(region);
			//获得第二个大单元格
			cell=sheet.getRow(rowNum).getCell(colNum);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("第二个大单元格");
			
			//工作簿建立完成，下面将工作簿存入文件
			//新建一输出文件流
			fOut=new FileOutputStream(file);
			//把相应的Excel工作簿存盘
			workbook.write(fOut);
			fOut.flush();
			fOut.close();    //操作结束，关闭文件
			System.out.println("Excel文件生成成功！Excel文件名"+file.getAbsolutePath());
		} catch(Exception e) {
			System.out.println("Excel文件"+file.getAbsolutePath()+"生成失败："+e);
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
	 * 读Excel文件内容
	 */
	public void readExcel(String fileName) {
		File file=new File(fileName);
		FileInputStream in=null;
		try {
			//创建对Excel工作簿文件的引用
			in=new FileInputStream(file);
			HSSFWorkbook workbook=new HSSFWorkbook(in);
			//创建对工作表的引用，这里使用按名引用
			HSSFSheet sheet=workbook.getSheet("Test_Table");  //也可用getSheetAt(int index)按索引引用
			//在Excel文档中，第一张工作表的缺省索引是0，其语句是：HSSFSheet sheet=workbook.getSheetAt(0);
			//下面读取Excel的前5行的数据
			System.out.println("下面是Excel文件"+file.getAbsolutePath()+"的内容：");
			HSSFRow row=null;
			HSSFCell cell=null;
			int rowNum=1;    //行标
			int colNum=0;      //列标
			for(; colNum<5; colNum++) {
				row=sheet.getRow(0);
				cell=row.getCell(colNum);
				System.out.print(cell.getStringCellValue()+"\t\t");
			}
			System.out.println();
			for(; rowNum<5; rowNum++) {
				//获取第rowNum行
				row=sheet.getRow(rowNum);
				for(colNum=0; colNum<5; colNum++) {
					//获取当前行的colNum位置的单元格
					cell=row.getCell(colNum);
					System.out.print(cell.getStringCellValue()+"\t\t\t");
				}
				System.out.println();     //换行
			}
			in.close();
		} catch(IOException e) {
			System.out.println("读取Excel文件"+file.getAbsolutePath()+"失败："+e);
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
