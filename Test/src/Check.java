// ��Ԫ���ֻ��������5Ԫ/ֻ��ĸ��3Ԫ/ֻ��С��3ֻ/Ԫ��
public class Check {
	public static void main(String[] args) {
		
		for(int i=1; i<20; i++)
			for(int j=1; j<34; j++)
				for(int t=1; t<34; t++)
					if((5*i+3*j+t)==100 && (i+j+3*t)==100)
						System.out.println("������"+i+"   ;ĸ����"+j+"   ;С����"+3*t);
	}
}
