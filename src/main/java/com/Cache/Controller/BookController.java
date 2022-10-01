package com.Cache.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cache.Entity.Book;
import com.Cache.Service.BookServiceImplementation;

@RestController
@RequestMapping("api/book")
public class BookController {
	
	@Autowired
	private BookServiceImplementation bookService;
	
	 	@PostMapping("add")
	    public Book addBook(@RequestBody Book book){
	        return bookService.addBook(book);
	    }

	    @PutMapping("update/{Id}")
	    public Book updateBook(@PathVariable int Id, @RequestBody Book book) {
	    	book.setId(Id);
	        return bookService.updateBook(book);
	    }

	    @GetMapping("get/{Id}")
	    public Book getBook(@PathVariable int Id){
	        return bookService.getBook(Id);
	    }
	    
	    @GetMapping("getlist")
	    public List<Book> getAllBooks(@RequestBody Book book){
			return bookService.getAllBooks(book);
	    	
	    }
	    
	    @DeleteMapping("delete/{Id}")
	    public String deleteBook(@PathVariable int Id){
	        return bookService.deleteBook(Id);
	    }
}
