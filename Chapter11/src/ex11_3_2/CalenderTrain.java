//�½�11.3.1                    �������
package ex11_3_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalenderTrain extends JFrame implements ActionListener {
	
	//�·ݺ���ݵ������б�
	private JComboBox MonthBox=new JComboBox();
	private JComboBox YearBox=new JComboBox();
	
	//�·ݺ���ݵı�ǩ
	private JLabel YearLabel=new JLabel("��ݣ�");
	private JLabel MonthLabel=new JLabel("�·ݣ�");
	
	//��ȷ�����͡����족������ť
	private JButton button_ok=new JButton("�鿴");
	private JButton button_today=new JButton("����");
	
	//��ȡ��������ڡ���ݡ��·�
	private Date now_date=new Date();
	private int now_year=now_date.getYear()+1900;           //java�е�����Ǵ�1900�꿪ʼ��
	private int now_month=now_date.getMonth();
	private boolean todayFlag=false;              //�Ƿ���ʾ���������
	
	//��һ�鰴ť��ʾ���ڣ�һ��7��7�У���һ��Ϊ���ڵ�����
	private JButton[] button_day=new JButton[42];
	private final String[] week={"��","һ","��","��","��","��","��"};
	private JButton[] button_week=new JButton[42];
	private String year_int=null;   //�����û�ѡ������
	private int month_int;         //�����û�ѡ����·�
	
	/*���캯��*/
	public CalenderTrain() {
		super();
		this.setTitle("����");         //���ñ���
		this.init();
		this.setLocation(500, 300);
		this.setResizable(false);         //�������Ĵ�С���ܸı�
		pack();
	}
	
	/*��ʼ������*/
	private void init() {
		Font font=new Font("Dialog",Font.BOLD,14);
		YearLabel.setFont(font);
		MonthLabel.setFont(font);
		button_ok.setFont(font);
		button_today.setFont(font);
		
		todayFlag=true;
		
		//�趨������䣬Ϊ��ǰ��ݵĹ�ȥ10�굽��ǰ��ݵ�δ��20��
		for(int i=now_year-10; i<now_year+20; i++)
			YearBox.addItem(i+"");
		
		//�趨��������б�Ϊ��ǰ��ݣ���ǰ��ݴ��ڵ�ʮ��
		YearBox.setSelectedIndex(10);
		
		//�趨�·����䣬12��
		for(int i=1; i<13; i++) {
			MonthBox.addItem(i+"");
		}
		
		//�趨�·������б�Ϊ��ǰ�·�
		MonthBox.setSelectedIndex(now_month);
		
		//���������б�Ϳ��ư�ť�����
		JPanel panel_ym=new JPanel();
		panel_ym.add(YearLabel);
		panel_ym.add(YearBox);
		panel_ym.add(MonthLabel);
		panel_ym.add(MonthBox);
		panel_ym.add(button_ok);
		panel_ym.add(button_today);
		
		//Ϊ������ť����¼�������
		button_ok.addActionListener(this);
		button_today.addActionListener(this);
		
		JPanel panel_day=new JPanel();        //�����������
		
		//���񲼾ֹ�������7��7�У�����֮��ˮƽ�ʹ�ֱ��������Ϊ3
		panel_day.setLayout(new GridLayout(7,7,3,3));
		
		//������ڵ����֣����ŵ������
		for(int i=0; i<7; i++) {
			button_week[i]=new JButton(" ");
			button_week[i].setText(week[i]);
			button_week[i].setForeground(Color.black);
			panel_day.add(button_week[i]);
		}
		button_week[0].setForeground(Color.red);
		button_week[6].setForeground(Color.red);
		
		//������ڣ��ŵ������
		for(int i=0;i<42;i++) {
			button_day[i]=new JButton(" ");
			panel_day.add(button_day[i]);
		}
		
		this.paintDay();         //��ʾ��ǰ���µ�����
		
		JPanel panel_main=new JPanel();  //���������������
		
		//�߽粼�ֹ�����
		panel_main.setLayout(new BorderLayout());
		panel_main.add(panel_day,BorderLayout.SOUTH);
		panel_main.add(panel_ym,BorderLayout.NORTH);
		getContentPane().add(panel_main);
	}
	
	
	/*��ʾ��ǰ��ݵ�����*/
	private void paintDay() {
		if(todayFlag) {
			//Ҫ����ʾ���������
			year_int=now_year+"";
			month_int=now_month;
		} else {
			//���򣬴������б��л�ȡ�û�ѡ�������
			year_int=YearBox.getSelectedItem().toString();
			month_int=MonthBox.getSelectedIndex();             //��ѡ�����
		}
		
		int year_sel=Integer.parseInt(year_int)-1900;   //������ֵ
		Date firstDay=new Date(year_sel,month_int,1);        //������µĵ�һ��
		GregorianCalendar cal=new GregorianCalendar();    //����һ��Calendarʵ��
		cal.setTime(firstDay);
		int days=0;            //���ĳ���·ݵ�����
		int day_week=0;    //���ĳ���µĵ�һ�������ڼ�����ֵ
		
		//�ж��Ǽ��·ݣ����������趨day��ֵ�����ж��·�Ҫ�ж��Ƿ�������
		if(month_int==0||month_int==2||month_int==4
				||month_int==6||month_int==7||month_int==9||month_int==11)
			days=31;
		else if(month_int==3||month_int==5||month_int==8||month_int==10)
			days=30;
		else {
			//���£���������꣬����29�죬������28��
			if(cal.isLeapYear(year_sel))
				days=29;
			else
				days=28;
		}
		
		//getDay������ȡ���������ڼ�
		day_week=firstDay.getDay();
		int count=1;
		
		/*
		 * ���ư�ť����������Ҫ����ѡ�����·ݵĵ�һ�������ڼ���ȷ�����ư�ť����ʼλ��
		 * ����day_week��������Ҫ���Ƶ���ʼλ�ã�������Щû����ֵ������ʾ�İ�ťҪ�ÿա�
		 */
		for(int i=day_week; i<day_week+days; count++, i++) {
			if(i%7==0||i%7==6) {
				//����Ǳ߽��ϵİ�ť�������ú�ɫ���Ա�ʾ��ĩ
				if(i==day_week+now_date.getDate()-1&&(year_int.equals(now_year+"")&&month_int==now_month)) {
					//��������һ������������ɫ���
					button_day[i].setForeground(Color.blue);
					button_day[i].setText(count+"");
				} else {
					//�����߽��ϵİ�ť�е������ú�ɫ
					button_day[i].setForeground(Color.red);
					button_day[i].setText(count+"");
				}
			} else {
				if(i==day_week+now_date.getDate()-1&&(year_int.equals(now_year+"")&&month_int==now_month)) {
					//��������һ������������ɫ���
					button_day[i].setForeground(Color.blue);
					button_day[i].setText(count+"");
				} else {
					//һ��λ�õİ�ť�ϵ������ú�ɫ���
					button_day[i].setForeground(Color.black);
					button_day[i].setText(count+"");
				}
			}
		}
		
		//����û��������ֵ��ʾ�İ�ť�����ÿմ���
		if(day_week==0)
			//�����һ�������գ��򽫺���İ�ť�ϵ����ֶ���Ϊ��
			for(int i=days;i<42;i++)
				button_day[i].setText(" ");
		else {
			//�����һ�첻�����գ��򽫵�һ��ǰ��İ�ť�ÿ�
			for(int i=0; i<day_week; i++)
				button_day[i].setText(" ");
			//���һ�����İ�ť�ÿ�
			for(int i=day_week+days; i<42; i++)
				button_day[i].setText(" ");
		}
	}
	
	
	/*�����¼�*/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_ok) {
			//�������ȷ����ť�͵���setDay()�������»��ư�ť
			todayFlag=false;
			this.paintDay();
		} else if(e.getSource()==button_today) {
			//����������찴ť���õ����������
			todayFlag=true;
			YearBox.setSelectedIndex(10);
			MonthBox.setSelectedIndex(now_month);
			this.paintDay();
		}
	}
	
	
	public static void main(String[] args) {
		CalenderTrain ct=new CalenderTrain();
		ct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ct.setVisible(true);
		//ct.show();
	}

}
