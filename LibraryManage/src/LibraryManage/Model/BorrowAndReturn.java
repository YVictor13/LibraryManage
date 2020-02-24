package LibraryManage.Model;

public class BorrowAndReturn {
	private int id;
	private String readerID;
	private String bookId;
	private String bookname;
	private String borrowdate;
	private String returndate;
	

	public BorrowAndReturn(String readerID,String bookId,String bookname,String borrowdate,String returndate ) {
		this.readerID=readerID;
		this.bookId =bookId;
		this.bookname=bookname;
		this.borrowdate=borrowdate;
		this.returndate=returndate;
	}
	
	public BorrowAndReturn(String readerID,String bookId,String borrowdate,String returndate ) {
		this.readerID=readerID;
		this.bookId =bookId;
		this.borrowdate=borrowdate;
		this.returndate=returndate;
	}
	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public BorrowAndReturn() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReaderID() {
		return readerID;
	}
	public void setReaderID(String readerID) {
		this.readerID = readerID;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	

}
