package com.cdut.db_book.service;

import java.util.List;

import com.cdut.db_book.entity.BookInfo;

public interface BookService {
	public List<BookInfo> searchBook(String search);
}
