package imooc.domain;

public class Book {
  private int id;
  private String bookname;
  private String catgoryName;
  private String price;
  private String description;
  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getCatgoryName() {
	return catgoryName;
}
public void setCatgoryName(String catgoryName) {
	this.catgoryName = catgoryName;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String toString() {
	return "Book [bookname=" + bookname + ", ID="+ id + ", catgoryName=" + catgoryName  + ", price="+ price + ", description="+ description+"]";
}
}
