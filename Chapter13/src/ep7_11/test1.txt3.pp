i<fileNames.length; i++) {
			System.out.println(fileNames[i]);
		}
		//合并文件
		String newFileName="./src/ep7_11/test2.txt";
		System.out.println("合并文件结果："+FileDivisionUniter.unite(fileNames, newFileName));
	}

}
