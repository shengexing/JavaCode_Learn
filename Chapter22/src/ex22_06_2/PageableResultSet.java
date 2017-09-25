// �½�22.06.2            ʹ��Servletʵ�ַ�ҳ�鿴���ݿ�
package ex22_06_2;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ֧�ַ�ҳ�Ľ�����Ľӿ�
 */
public interface PageableResultSet extends ResultSet{

	/** ������ҳ��*/
	int getPageCount();
	
	/** ���ص�ǰ�ļ�¼����*/
	int getPageRowsCount();
	
	/** ���ط�ҳ��С*/
	int getPageSize();
	
	/** ת��ָ��ҳ*/
	void gotoPage(int page);
	
	/** ���÷�ҳ��С*/
	void setPageSize(int pageSize);
	
	/** �����ܼ�¼����*/
	int getRowsCount();
	
	/** ת����ǰҳ�ĵ�һ����¼
	 * @exception SQLException
	 */
	void pageFirst() throws SQLException;
	
	/** ת����ǰҳ�����һ����¼
	 * @exception SQLException
	 */
	void pageLast() throws SQLException;
	
	/** ���ص�ǰҳ��*/
	int getCurPage();
	
}
