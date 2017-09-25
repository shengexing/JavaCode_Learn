// �½�18.08.2            ��ȡ�����Ϣ
package ex18_08_2;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/**
 * �鿴�����Ϣ�����ı���������������������ı�������ʾ�����Ϣ
 * ��Ϣ�������������������ԡ���Ĺ��췽������ķ���
 */
public class ViewClassInfoFrame extends JFrame implements ActionListener {

	JTextField classNameField = new JTextField();	// �����������ı���
	JButton viewInfoButton = new JButton();	// �鿴����Ϣ�İ�ť
	JLabel hintLabel = new JLabel();	// ��ʾ���������ı�ǩ
	JTextArea infoTextArea = new JTextArea();	// ��ʾ����Ϣ���ı���͹������
	JScrollPane infoScrollPane = new JScrollPane();
	TitledBorder titledBorder;	// һ������߿���ʾ�����Ϣ

	// ����������壬�������ĸ������
	JPanel upPanel = new JPanel();
	JPanel centerPanel = new JPanel();

	// �����ʹ�õĲ��ֹ�����
	BorderLayout mainFrameBorderLayout = new BorderLayout();
	BorderLayout centerPanelBorderLayout = new BorderLayout();
	BorderLayout upPanelBorderLayout = new BorderLayout();

	// ���췽��
	public ViewClassInfoFrame() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		init();
		validate();
	}

	/** ��ʼ������ */
	private void init() {
		// ��ʼ�������ı���
		classNameField.setFont(new java.awt.Font("Dialog", 0, 15));
		classNameField.setSelectedTextColor(Color.white);
		classNameField.setText("");

		// ��ʼ����ť�ı�3
		viewInfoButton.setFont(new java.awt.Font("Dialog", 0, 13));
		viewInfoButton.setText("�鿴����Ϣ");
		viewInfoButton.addActionListener(this);
		hintLabel.setFont(new java.awt.Font("Dialog", 0, 13));
		hintLabel.setText("������������������");

		// ��ʼ���ı���
		infoTextArea.setFont(new java.awt.Font("Dialog", 0, 14));
		infoTextArea.setEditable(false);
		infoTextArea.setText("");

		// ��ʼ������߿�
		titledBorder = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(134, 134, 134)), "�����Ϣ");
		infoScrollPane.setBorder(titledBorder);
		infoScrollPane.getViewport().add(infoTextArea, null);

		// �������������
		upPanel.setLayout(upPanelBorderLayout);
		centerPanel.setLayout(centerPanelBorderLayout);
		upPanel.add(hintLabel, BorderLayout.NORTH);
		upPanel.add(classNameField, BorderLayout.CENTER);
		upPanel.add(viewInfoButton, BorderLayout.SOUTH);
		centerPanel.add(infoScrollPane);

		// �������봰��
		this.getContentPane().setLayout(mainFrameBorderLayout);
		this.setSize(new Dimension(450, 360));
		this.setTitle("ʹ�÷�����Ʋ鿴Java�����Ϣ");

		this.getContentPane().add(upPanel, BorderLayout.NORTH);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);

		this.getRootPane().setDefaultButton(viewInfoButton);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/** ʵ��ActionListener�ӿڣ���������¼� */
	public void actionPerformed(ActionEvent e) {
		// �������ı�������ȡ����
		String className = classNameField.getText();
		StringBuffer buf = new StringBuffer();
		try {
			// ��̬�����࣬������Class����
			Class<?> c = Class.forName(className);
			buf.append("     /** ������� **/\n");
			buf.append(getClassStatement(c));
			buf.append("\n");

			buf.append("     /** �ֶ� **/\n");
			buf.append(getFields(c));

			buf.append("     /** ������ **/\n");
			buf.append(getConstructors(c));

			buf.append("     /** ���� **/\n");
			buf.append(getMethods(c));
			buf.append("}\n");
		} catch(Exception ep) {
			JOptionPane.showMessageDialog(this, "û�ҵ����ࣺ" + ep.getMessage());
		}
		infoTextArea.setText(buf.toString());
	}

	/** ��ȡ������� */
	private String getClassStatement(Class<?> c) {
		StringBuffer buf = new StringBuffer();

		if(c.getName().equals("java.lang.Object")) {
			buf.append("public class Object {");
			return buf.toString();
		} else {
			// �õ�����ĸ�����
			String superName = c.getSuperclass().getName();
			buf.append("public class ").append(c.getName());
			buf.append(" extends ").append(superName).append(" {");
		}

		return buf.toString();
	}

	/** ��ȡ������� */
	private String getFields(Class<?> c) {
		StringBuffer buf = new StringBuffer();
		Field[] fields = c.getDeclaredFields();	// ���������������

		// �������ԣ���ȡ������Ϣ
		Field f = null;
		for(int i = 0; i < fields.length; i++) {
			f = fields[i];

			// ��ȡ���Եķ������η�
			buf.append(Modifier.toString(f.getModifiers())).append(" ");
			Class<?> type = f.getType();	// ��ȡ���Ե�����
			buf.append(type.getName()).append(" ");
			buf.append(f.getName()).append(";\n");	// ��ȡ������
		}

		return buf.toString();
	}

	/** ��ȡ��Ĺ��췽��*/
	private String getConstructors(Class<?> c) {
		StringBuffer buf = new StringBuffer();
		Constructor<?>[] cons = c.getDeclaredConstructors();		// ��ȡ��Ĺ��췽��
		Constructor<?> con = null;

		// �������췽��
		for(int i = 0; i < cons.length; i++) {
			con = cons[i];

			// ��ȡ���췽���ķ������η�
			buf.append(Modifier.toString(con.getModifiers())).append(" ");
			buf.append(con.getName()).append("(");	// ��ȡ���췽��������

			// ��ȡ���췽���Ĳ�������
			Class<?>[] paramTypes = con.getParameterTypes();
			for(int j = 0; j < paramTypes.length; j++) {
				if(j == (paramTypes.length - 1))
					buf.append(paramTypes[j].getName());
				else
					buf.append(paramTypes[j].getName()).append(", ");
			}
			buf.append(")");

			// ��ȡ�����������쳣
			Class<?>[] excepTypes = con.getExceptionTypes();
			for(int j = 0; j < excepTypes.length; j++) {
				if(j == 0)
					buf.append(" throws ");
				if(j == excepTypes.length - 1)
					buf.append(excepTypes[j].getName());
				else
					buf.append(excepTypes[j].getName()).append(", ");
			}
			buf.append("\n");
		}
		return buf.toString();
	}

	/** ��ȡ�������ķ��� */
	private String getMethods(Class<?> c) {
		StringBuffer buf = new StringBuffer();
		Method[] methods = c.getMethods();	// ���������з���

		// �������з���
		Method method = null;
		for(int i = 0; i < methods.length; i++) {
			method = methods[i];

			// ��ȡ�����ķ������η�
			buf.append(Modifier.toString(method.getModifiers())).append(" ");

			// ��ȡ�����ķ�������
			Class<?> returnType = method.getReturnType();
			buf.append(returnType.getName()).append(" ");
			buf.append(method.getName()).append("(");	// ��ȡ������

			// ��ȡ�����Ĳ�������
			Class<?>[] paramTypes = method.getParameterTypes();
			for(int j = 0; j < paramTypes.length; j++) {
				if(j == paramTypes.length - 1)
					buf.append(paramTypes[j].getName());
				else
					buf.append(paramTypes[j].getName()).append(", ");
			}
			buf.append(")");

			// ��ȡ�����������쳣
			Class<?>[] excepTypes = method.getExceptionTypes();
			for(int j = 0; j < excepTypes.length; j++) {
				if(j == 0)
					buf.append(" throws ");
				if(j == excepTypes.length - 1)
					buf.append(excepTypes[j].getName());
				else
					buf.append(excepTypes[j].getName()).append(", ");
			}
			buf.append("\n");
		}
		return buf.toString();

	}

	// ������
	public static void main(String[] args) {
		try {
			// ���ý������ۣ�Ϊϵͳ���
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ViewClassInfoFrame frame = new ViewClassInfoFrame();
		
		// ��ȡ��Ļ�ķֱ��ʣ�ʹ���������ʾ
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		
		if(frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if(frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);

	}

}
