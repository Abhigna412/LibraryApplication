package com.Cache.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.Cache.Dao.BookDao;
import com.Cache.Entity.Book;

@Service
public class BookServiceImplementation implements BookService{
	
	@Autowired
	private BookDao bookDao;

	@Override
	public Book addBook(Book book) {
		return bookDao.save(book);
	}

	@Override
	@CachePut(cacheNames = "books", key = "#book.Id")
	public Book updateBook(Book book) {
		bookDao.updateBook(book.getId(), book.getBookname());
		return book;
	}

	@Override
	@Cacheable(cacheNames = "books", key = "#Id")
	public Book getBook(int Id) {
		Optional<Book> book = bookDao.findById(Id);
		if(book.isPresent()) {
			return book.get();
		}else {
			return new Book();
		}	
	}

	@Override
	@CacheEvict(cacheNames = "books", key = "#Id")
	public String deleteBook(int Id) {
		bookDao.deleteById(Id);;
		return "Book Deleted.";
	}

	@Override
	public List<Book> getAllBooks(Book books) {
		return bookDao.findAll();
	}

}
