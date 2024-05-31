package com.book.dto;

public class BuyBook {
	
	private int bookId;
    private int userId;
	public BuyBook() {
		super();
	}
	public BuyBook(int bookId, int userId) {
		super();
		this.bookId = bookId;
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BuyBook [bookId=" + bookId + ", userId=" + userId + "]";
	}
    
    
}
