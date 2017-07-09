fileLength%size!=0)? (int)(fileLength/size+1): (int)(fileLength/size);
		//存放被分割后的小文件名
		String[] outFileNames=new String[num];
		//输入文件流，即被分割的文件
		FileInputStream in=new FileInputStream(inFile);
		//读输入文件流的开始和结束下标
		long inEndIndex=0;
		int inBeginIndex=0;
		//根据要分割的数目输出文件
		for(int outFileIndex=0; outFileIndex<num; outFileIndex++) {
			//对于前num-1个小文件，大小都为指定的size
			File outFile=new File(parentFile, inFile.getName()+outFileIndex+SUFFIX);
			//构建小文件的输出流
			FileOutputStream out=new FileOutputStream(outFile);
			//将结束下标后移size
			inEndIndex+=size;
			inEndIndex=(inEndIndex>fileLength)? fileLength: inEndIndex;
			//从输入流中读取字节存储到输出流中
			for(; inBeginIndex<inEndIndex; inBeginIndex++) {
				out.write(in.read());
			}
			out.close();
			outFileNames[outFileIndex]=outFile.getAbsolutePath();
		}
		in.close();
		return outFileNames;
	}
	
	/**
	 * 合并文件
	 * @param fileNa