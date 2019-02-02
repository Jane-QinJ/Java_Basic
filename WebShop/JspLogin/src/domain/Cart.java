package domain;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class Cart {
	private Hashtable<String, Book> ht = new Hashtable<>(); 
	
	public void addBook(String id, Book book) {
		if(ht.containsKey(id)) { //�ж�id�Ƿ����
			Book book_bought = ht.get(id); //�Ѿ��������
			book_bought.setQuantity(book_bought.getQuantity()+1);//��һ
			
			
		}else {
			ht.put(id, book); 
		}
	}
	
	public void deleteBook(String id) {
		Book book_bought = ht.get(id);
		if(book_bought.getQuantity()>1) {
			book_bought.setQuantity(book_bought.getQuantity()-1);
		}else if(book_bought.getQuantity() == 1) {
			ht.remove(id);
		}
	}
	
	public void clearBook() {
		ht.clear();
	}
	
	//
	public ArrayList<Book> showCart(){
		ArrayList<Book> booklist = new ArrayList<Book>();
		
//		Iterator<String> iterator = ht.keySet().iterator();   //��ֵ����  Ҳ����id
//		
//		while(iterator.hasNext()) {
//			String id = (String)iterator.next(); //�õ�������������id
//			Book book = ht.get(id); //��id����book����
//			booklist.add(book);   
//		}
		//ö��
		Enumeration<Book> elements = ht.elements();
		while (elements.hasMoreElements()) {
			Book book = (Book) elements.nextElement();
			booklist.add(book);
		}
		return booklist;
	}
	
	public double getTotalPrice() {
		double totalPrice = 0;
		Enumeration<Book> e = ht.elements();  //���ر���ֵ
		while(e.hasMoreElements()) {
			Book book = e.nextElement();  //
			totalPrice += book.getPrice()*book.getQuantity();
		}
		return totalPrice;
	}

	//�����鱾����
	public void updateBook(String id, String quantity) {
		Book book = ht.get(id); //��������
		book.setQuantity(Integer.parseInt(quantity)); //�����������
	}
}
