
public class TEST {
	static String str1="a";
	static String str2="a";

	public static void main(String[] args) {
		str1 = str1 + "b";
		str2.concat("b");
		System.out.println(str1+" ,"+str2);
	}
}
