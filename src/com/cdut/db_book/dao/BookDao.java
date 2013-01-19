package com.cdut.db_book.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.cdut.db_book.entity.BookInfo;

public interface BookDao {
	public List<BookInfo> searckBook(String sql);
	
	public Map<String,Object> getBookDetail(String sql) throws ClientProtocolException,
	IOException;
}
