// 百元买百只鸡，公鸡5元/只，母鸡3元/只，小鸡3只/元。
public class Check {
	public static void main(String[] args) {
		
		for(int i=1; i<20; i++)
			for(int j=1; j<34; j++)
				for(int t=1; t<34; t++)
					if((5*i+3*j+t)==100 && (i+j+3*t)==100)
						System.out.println("公鸡："+i+"   ;母鸡："+j+"   ;小鸡："+3*t);
	}
}
