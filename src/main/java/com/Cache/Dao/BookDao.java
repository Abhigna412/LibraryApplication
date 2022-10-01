package com.Cache.Dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Cache.Entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer>{

	@Transactional
	@Modifying
	 @Query("update Book u set u.Bookname=?2 where u.Id=?1")
	    int updateBook(int Id, String Bookname);	

}
