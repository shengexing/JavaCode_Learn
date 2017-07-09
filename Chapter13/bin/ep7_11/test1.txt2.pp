mes 待合并的文件名，是一个数组
	 * @param TargetFileName 目标文件名
	 * @return 目标文件的全路径
	 * @throws Exception 合并过程中可能抛出的异常
	 */
	public static String unite(String[] fileNames, String TargetFileName) throws Exception {
		File inFile=null;
		//构建文件输出流
		File outFile=new File(TargetFileName);
		FileOutputStream out=new FileOutputStream(outFile);
		for(int i=0; i<fileNames.length; i++) {
			//打开文件输入流
			inFile=new File(fileNames[i]);
			FileInputStream in=new FileInputStream(inFile);
			//从输入流中读取数据，并写入到文件输出流中
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
		//分割文件
		String fileName="./src/ep7_11/test1.txt";
		long size=1000;
		String[] fileNames=FileDivisionUniter.divide(fileName, size);
		System.out.println("分割文件"+fileName+"结果：");
		for(int i=0; 