package domain;
/**
 * ����ģ�ͣ���ʾ�Ƕ���������ɾ�Ĳ顣
 */
import java.util.ArrayList;

public class Book {

	private int id;			//���id
	private Double price;	//�۸�
	private String name;	//����
	private String info;   //�������
	private String author; //����
	private int quantity = 1;  //�������
	
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book[id"+id+",price"+price+",name"+name+",description"+info;
	}
}