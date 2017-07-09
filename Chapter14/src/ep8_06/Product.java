//章节8.6                     生产者消费者问题
package ep8_06;

/*
 *产品类*/
public class Product {
	private String name;        //产品名
	
	public Product(String name) {
		this.name=name;
	}
	
	public String toString() {
		return "Product-"+name;
	}

}
