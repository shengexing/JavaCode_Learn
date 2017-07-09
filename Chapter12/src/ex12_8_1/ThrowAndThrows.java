//�½�12.8.1              throw��throws��try��catch��ʹ��
package ex12_8_1;

public class ThrowAndThrows {
	
	/*
	 * ����һ�����ֵ�ƽ����
	 * @param nStr   ���ַ�������ʽ�ṩ����
	 * @return   ����ƽ����
	 * @throws   Exception���û�������ַ���Ϊ��
	 * 									�����ַ����޷�ת�������֣�����ת���ɵ�����С��0�������׳��쳣
	 */
	public static double sqrt(String nStr) throws Exception {
		if(nStr==null) {
			//��throw�ؼ����׳��쳣�����쳣���׳�ʱ������������÷���
			throw new Exception("������ַ�������Ϊ�գ�");
		}
		double n=0;
		try {
			n=Double.parseDouble(nStr);
		} catch(NumberFormatException e) {
			//��parseDouble���������׳����쳣NumberFormatException����Ȼ�󽫲�����쳣���·�װ���׳�
			throw new Exception("������ַ��������ܹ�ת�������֣�",e);
		}
		if(n<0) {
			throw new Exception("������ַ���ת���ɵ����ֱ�����ڵ���0��");
		}
		return Math.sqrt(n);      //����ƽ����
	}

	public static void main(String[] args) throws Exception{
		try {
			ThrowAndThrows.sqrt("-124.56");
		} catch (Exception e) {
			//��sqrt���������Ŀ����׳���Exception�쳣����
			//��ʾ������쳣�Ķ�ջ��Ϣ���Ӷ�ջ��Ϣ�п��Է����쳣������λ�ú�ԭ��
			System.out.println("Got a Exception��"+e.getMessage());
			e.printStackTrace();
			throw e;           //������һ���Ĵ������쳣�����׳�
		}
		
		//��sqrt�����˿��ܻ��׳����쳣�����ף������ڷ���������ʹ��throws
		ThrowAndThrows.sqrt("-124.56");     //�������ִ��
		
		//�������׳��쳣
		System.out.println(Math.sqrt(Double.parseDouble("-124.56")));   //�������ִ��

	}

}
