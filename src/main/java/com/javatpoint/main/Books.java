package com.javatpoint.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
	public class Books {
		@Id
		@Column
	    private int bookid;
		@Column
		private String bookname;
		@Column
		private String author;
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		public String getBookname() {
			return bookname;
		}
		public void setBookname(String bookname) {
			this.bookname = bookname;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		
	}	

