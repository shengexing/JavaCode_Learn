//章节9.9.2                     基本类型与字符串的互相转换
package ex9_9_2;

public class BasicTypeToString {
	
	/*整数转换成字符串，n为待转换的整数*/
	public String int2str(int n) {
		//3种方法实现转换
		//return new Integer(n).toString();
		//return ""+n;
		return String.valueOf(n);
	}

	/*字符串转换成整数，str为待转换的字符串*/
	public int str2int(String str) {
		//2种方法实现转换
		//return new Integer(str).intValue();
		return Integer.parseInt(str);
	}
	
	/*小数转换成字符串，d为待转换的小数*/
	public String double2str(double d) {
		//3种方法实现转换
		//return new Double(d).toString();
		//return ""+d;
		return String.valueOf(d);
	}
	
	/*字符串转换成小数，str为待转换的字符串*/
	public double str2double(String str) {
		//2种方法实现转换
		//return new Double(str).doubleValue();
		return Double.parseDouble(str);
	}
	
	/*其他基本类型与字符串的互相转换这里不一一列出，方法都类似*/
	public static void main(String[] args) {
		BasicTypeToString test=new BasicTypeToString();
		int n=156;
		String str1=test.int2str(n);
		System.out.println("test.int2str(n)="+str1);
		System.out.println("test.str2int(str1)="+test.str2int(str1));
		
		double d=12.345;
		String strD=test.double2str(d);
		System.out.println("test.double2str(d)="+strD);
		System.out.println("test.str2Double(strD)="+test.str2double(strD));
		// TODO 自动生成的方法存根

	}

}
