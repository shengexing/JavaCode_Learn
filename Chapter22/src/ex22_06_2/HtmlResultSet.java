// 章节22.06.2            使用Servlet实现分页查看数据库
package ex22_06_2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * 将一个SQL查询结果集输出为HTML字符串
 */
public class HtmlResultSet {
	private ResultSet rs; 			// 结果集
	
	public HtmlResultSet(ResultSet rs) {
		this.rs = rs;
	}
	
	/** 生成整个结果集的HTML*/
	public String toString() {
		try {
			rs.last();
			int numrows = rs.getRow();
			return toString(1, numrows);
		} catch(SQLException e) {
			System.err.print("在HtmlResultSet类的toString()方法中捕获到异常！\n");
			StringBuffer out = new StringBuffer();
			out.append("<TABLE border='1'>\n");
			out.append("</TABLE>\n<H1>ERROR:</H1>" + e.getMessage() + "\n");
			return out.toString();
		}
	}
	
	/** 只为结果集部分记录生成HTML*/
	public String toString(int begin, int end) {
		StringBuffer out = new StringBuffer();
		
		// 结果集的数据显示在HTML的Table中
		out.append("<BR><TABLE border='1'>\n");
		try {
			if((begin <= 0) || (end <= 0) || (begin > end))
				throw new Exception("参数错误！");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			// 创建表的头
			int numcols = rsmd.getColumnCount();
			out.append("<TR>");
			for(int i = 1; i <= numcols; i++)
				out.append("<TH align='center'>" + rsmd.getColumnLabel(i));
			out.append("</TR>\n");
			
			rs.absolute(begin);
			
			// 构建表的内容
			do {
				// 每条记录占据一行
				out.append("<TR>");
				for(int i = 1; i <= numcols; i++) {
					out.append("<TD align='center'>");
					Object obj = rs.getObject(i);
					if(obj !=null)
						out.append(obj.toString());
					else
						out.append("&nbsp;");
				}
				
				out.append("</TR>\n");
				if(rs.getRow() == end)
					break;
			} while(rs.next());
			
			// 表格结束
			out.append("</TABLE>\n");
		} catch(Exception e) {
			out.append("</TABLE>\n<H1>ERROR:</H1>" + e.getMessage() + "\n");
		}
		
		return out.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
