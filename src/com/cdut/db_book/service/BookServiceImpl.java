package com.cdut.db_book.service;

import java.util.List;
import com.cdut.db_book.dao.BookDAOImpl;
import com.cdut.db_book.dao.BookDao;
import com.cdut.db_book.entity.BookInfo;

public class BookServiceImpl implements BookService {

	// ��ȡͼ����Ϣ/GET/https://api.douban.com/V2/book/:id
	// ����ISBM��ȡͼ����Ϣ/GET/https://api.douban.com/V2/book/isbn/:name
	// ����ͼ��/GET/https://api.douban.com/V2/book/search
	// ��ȡĳ��ͼ���б�����ı�ǩ/GET/https://api.douban.com/V2/book/:id/tags
	// ��ȡ�û���ͼ������б�ǩ/GET/https://api.douban.com/V2/book/user/:name/tags
	// ��ȡĳ���û�������ͼ���ղ���Ϣ/GET/https://api.douban.com/V2/book/user/:name/collections
	// ��ȡ�û���ĳ��ͼ����ղ���Ϣ/GET/https://api.douban.com/V2/book/:id/collection
	// ��ȡĳ���û������бʼ�/GET/https://api.douban.com/V2/book/user/:name/annotations
	// ��ȡĳ��ͼ������бʼ�/GET/https://api.douban.com/V2/book/:id/annotations
	// ��ȡĳƪ�ʼǵ���Ϣ/GET/https://api.douban.com/V2/book/annotation/:id


	public List<BookInfo> searchBook(String search) {
		BookDao dao = new BookDAOImpl();
		List<BookInfo> result=null;
		result = dao.searckBook(search);
		return  result;
	}
}
