// 章节22.06.2            使用Servlet实现分页查看数据库
package ex22_06_2;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 支持分页的结果集的接口
 */
public interface PageableResultSet extends ResultSet{

	/** 返回总页数*/
	int getPageCount();
	
	/** 返回当前的记录条数*/
	int getPageRowsCount();
	
	/** 返回分页大小*/
	int getPageSize();
	
	/** 转到指定页*/
	void gotoPage(int page);
	
	/** 设置分页大小*/
	void setPageSize(int pageSize);
	
	/** 返回总记录行数*/
	int getRowsCount();
	
	/** 转到当前页的第一条记录
	 * @exception SQLException
	 */
	void pageFirst() throws SQLException;
	
	/** 转到当前页的最后一条记录
	 * @exception SQLException
	 */
	void pageLast() throws SQLException;
	
	/** 返回当前页号*/
	int getCurPage();
	
}
