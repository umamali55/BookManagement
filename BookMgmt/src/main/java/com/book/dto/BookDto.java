package com.book.dto;

import jakarta.persistence.Lob;

public class BookDto {
	
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private float bookPrice;
	private String description;
	@Lob
	private byte[] bookImage;
	public BookDto() {
		super();
	}
	public BookDto(int bookId, String bookName, String bookAuthor, float bookPrice, String description,
			byte[] bookImage) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.description = description;
		this.bookImage = bookImage;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getBookImage() {
		return bookImage;
	}
	public void setBookImage(byte[] bookImage) {
		this.bookImage = bookImage;
	}
	@Override
	public String toString() {
		return "BookDto [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPrice="
				+ bookPrice + ", description=" + description + ", bookImage=" + Arrays.toString(bookImage) + "]";
	}
	
	
}