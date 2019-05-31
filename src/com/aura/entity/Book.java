package com.aura.entity;

import java.io.Serializable;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer bid;
	private String bname;
	private String author;
	
	private Integer price;
	
	public Book() {
		super();
	}
	public Book(Integer bid, String bname, String author, Integer price) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [书籍编号=" + bid + ", 书籍名称=" + bname + ", 作者=" + author + ", 密码="  + ", 价格=" + price
				+ "]";
	}
}
