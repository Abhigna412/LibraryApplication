package com.Cache.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BOOK")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String Bookname;
	private String Author;
	
}
