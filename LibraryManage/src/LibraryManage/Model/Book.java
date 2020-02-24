package LibraryManage.Model;

/**
 * Õº È¿‡
 * @author dell
 *
 */

public class Book {
	
	private String bookID;
	private String ISBNNumber;
	private String bookName;
	private String author;
	private String bookState;
	private String price;
	private String putinDate;
	private String outputDate;
	private String IsDelete;
	
	public String getIsDelete() {
		return IsDelete;
	}


	public void setIsDelete(String isDelete) {
		IsDelete = isDelete;
	}


	public Book(String bookID,String ISBNNumber,String bookName,String author,String price,String bookSatte,String putinDate,String outputDate) {
		this.bookID=bookID;
		this.ISBNNumber=ISBNNumber;
		this.bookName=bookName;
		this.author=author;
		this.price=price;
		this.bookState=bookSatte;
		this.putinDate=putinDate;
		this.outputDate=outputDate;
		
	}
	
	
	public Book() {
		
	}

	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getISBNNumber() {
		return ISBNNumber;
	}
	public void setISBNNumber(String iSBNNumber) {
		ISBNNumber = iSBNNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookState() {
		return bookState;
	}
	public void setBookState(String bookState) {
		this.bookState = bookState;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPutinDate() {
		return putinDate;
	}
	public void setPutinDate(String putinDate) {
		this.putinDate = putinDate;
	}
	public String getOutputDate() {
		return outputDate;
	}
	public void setOutputDate(String outputDate) {
		this.outputDate = outputDate;
	}
	
	
}
