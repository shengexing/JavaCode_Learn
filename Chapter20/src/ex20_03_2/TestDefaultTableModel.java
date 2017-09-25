// �½�20.03.2            ʹ��DefaultTableModel����JTable���
package ex20_03_2;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ex20_01_1.TestDB;

public class TestDefaultTableModel extends JFrame {
	
	Vector colsv = new Vector();	 	// ����һ������
	JTable table;					// ����һ��JTable����
	DefaultTableModel tablemodel;			// ����DefaultTableModelģ��
	
	public TestDefaultTableModel() {
		this.setLayout(new FlowLayout());
		
		// ��String���󡰱�š������������������䡱�����Ա𡱺͵�ַ����������������ʾ��ͷ
		colsv.add("�û���");
		colsv.add("����");
		tablemodel = new DefaultTableModel(new Vector(), colsv);
		
		// ʵ�������ģ�ͣ���ֵΪ����colsv
		String sql = "SELECT * FROM userlogin";
		TestDB db = new TestDB();
		ResultSet rs = db.query(sql);				// ִ�в�ѯ����
		
		// ����ѯ���Ľ�����е�ֵ�ŵ�vector
		Vector value = new Vector();
		try {
			while(rs.next()) {			// ѭ�����������rs�еļ�¼
				Vector vc = new Vector();		// ������������
				vc.add(rs.getString("username")); 			// ���ӵ�ǰ��¼�л�õ���Ӧ�ֶε�ֵ��ӵ�������
				vc.add(rs.getString("password"));
				value.add(vc);
			}
			
			db.closeAll(); 			// �ͷ���Դ
			
			tablemodel.setDataVector(value, colsv); 			// �ڱ����д���µ��У���ֵΪ����value
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		table = new JTable(tablemodel);				// ʹ��tablemodel���������
		this.add(new JScrollPane(table));				// �������ӵ����������
		this.setSize(500, 300); 					// ���ô����С
		this.setVisible(true); 						// ʹ����ɼ�
		
		// ���ü��������رմ��ں󣬳������
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {	
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new TestDefaultTableModel();

	}

}
