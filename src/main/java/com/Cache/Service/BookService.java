package com.Cache.Service;

import java.util.List;

import com.Cache.Entity.Book;

public interface BookService {
	
	public Book addBook(Book book);
	public Book updateBook(Book book);
	public Book getBook(int Id);
	public String deleteBook(int Id);
	public List<Book> getAllBooks(Book books);

}
