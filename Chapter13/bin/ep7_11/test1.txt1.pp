fileLength%size!=0)? (int)(fileLength/size+1): (int)(fileLength/size);
		//��ű��ָ���С�ļ���
		String[] outFileNames=new String[num];
		//�����ļ����������ָ���ļ�
		FileInputStream in=new FileInputStream(inFile);
		//�������ļ����Ŀ�ʼ�ͽ����±�
		long inEndIndex=0;
		int inBeginIndex=0;
		//����Ҫ�ָ����Ŀ����ļ�
		for(int outFileIndex=0; outFileIndex<num; outFileIndex++) {
			//����ǰnum-1��С�ļ�����С��Ϊָ����size
			File outFile=new File(parentFile, inFile.getName()+outFileIndex+SUFFIX);
			//����С�ļ��������
			FileOutputStream out=new FileOutputStream(outFile);
			//�������±����size
			inEndIndex+=size;
			inEndIndex=(inEndIndex>fileLength)? fileLength: inEndIndex;
			//���������ж�ȡ�ֽڴ洢���������
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
	 * �ϲ��ļ�
	 * @param fileNa