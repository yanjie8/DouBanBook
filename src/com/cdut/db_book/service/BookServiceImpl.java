package com.cdut.db_book.service;

import java.util.List;
import com.cdut.db_book.dao.BookDAOImpl;
import com.cdut.db_book.dao.BookDao;
import com.cdut.db_book.entity.BookInfo;

public class BookServiceImpl implements BookService {

	// 获取图书信息/GET/https://api.douban.com/V2/book/:id
	// 根据ISBM获取图书信息/GET/https://api.douban.com/V2/book/isbn/:name
	// 搜索图书/GET/https://api.douban.com/V2/book/search
	// 获取某个图书中标记最多的标签/GET/https://api.douban.com/V2/book/:id/tags
	// 获取用户对图书的所有标签/GET/https://api.douban.com/V2/book/user/:name/tags
	// 获取某个用户的所有图书收藏信息/GET/https://api.douban.com/V2/book/user/:name/collections
	// 获取用户对某本图书的收藏信息/GET/https://api.douban.com/V2/book/:id/collection
	// 获取某个用户的所有笔记/GET/https://api.douban.com/V2/book/user/:name/annotations
	// 获取某本图书的所有笔记/GET/https://api.douban.com/V2/book/:id/annotations
	// 获取某篇笔记的信息/GET/https://api.douban.com/V2/book/annotation/:id


	public List<BookInfo> searchBook(String search) {
		BookDao dao = new BookDAOImpl();
		List<BookInfo> result=null;
		result = dao.searckBook(search);
		return  result;
	}
}
