mes ���ϲ����ļ�������һ������
	 * @param TargetFileName Ŀ���ļ���
	 * @return Ŀ���ļ���ȫ·��
	 * @throws Exception �ϲ������п����׳����쳣
	 */
	public static String unite(String[] fileNames, String TargetFileName) throws Exception {
		File inFile=null;
		//�����ļ������
		File outFile=new File(TargetFileName);
		FileOutputStream out=new FileOutputStream(outFile);
		for(int i=0; i<fileNames.length; i++) {
			//���ļ�������
			inFile=new File(fileNames[i]);
			FileInputStream in=new FileInputStream(inFile);
			//���������ж�ȡ���ݣ���д�뵽�ļ��������
			int c;
			while((c=in.read())!=-1) {
				out.write(c);
			}
			in.close();
		}
		out.close();
		return outFile.getAbsolutePath();
	}
	
	public static void main(String[] args) throws Exception {
		//�ָ��ļ�
		String fileName="./src/ep7_11/test1.txt";
		long size=1000;
		String[] fileNames=FileDivisionUniter.divide(fileName, size);
		System.out.println("�ָ��ļ�"+fileName+"�����");
		for(int i=0; 