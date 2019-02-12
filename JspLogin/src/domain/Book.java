package domain;
/**
 * 领域模型，表示是对它进行增删改查。
 */
import java.util.ArrayList;

public class Book {

	private int id;			//书的id
	private Double price;	//价格
	private String name;	//书名
	private String info;   //书的种类
	private String author; //作者
	private int quantity = 1;  //书的数量
	private String pic; 
	

	public Book() {
		
	}
	public Book(int id, double price, String name, String info) {
		this.id = id;
		this.price = price;
		this.name = name;
		this.info = info;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book[id "+id+",price"+price+",name "+name+",description "+info+",pic "+pic;
	}
}
