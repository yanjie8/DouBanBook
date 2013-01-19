package com.cdut.db_book.dao;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.cdut.db_book.entity.BookInfo;

public class BookDAOImpl implements BookDao {
	//��ȡͼ����Ϣ/GET/https://api.douban.com/V2/book/:id
	//����ISBM��ȡͼ����Ϣ/GET/https://api.douban.com/V2/book/isbn/:name
	//����ͼ��/GET/https://api.douban.com/V2/book/search
	//��ȡĳ��ͼ���б�����ı�ǩ/GET/https://api.douban.com/V2/book/:id/tags
	//��ȡ�û���ͼ������б�ǩ/GET/https://api.douban.com/V2/book/user/:name/tags
	//��ȡĳ���û�������ͼ���ղ���Ϣ/GET/https://api.douban.com/V2/book/user/:name/collections
	//��ȡ�û���ĳ��ͼ����ղ���Ϣ/GET/https://api.douban.com/V2/book/:id/collection
	//��ȡĳ���û������бʼ�/GET/https://api.douban.com/V2/book/user/:name/annotations
	//��ȡĳ��ͼ������бʼ�/GET/https://api.douban.com/V2/book/:id/annotations
	//��ȡĳƪ�ʼǵ���Ϣ/GET/https://api.douban.com/V2/book/annotation/:id

		private static final String URL_getBookInfoById="htt://api.douban.com/v2/book/";
		private static final String URL_getBookInfoByISBM="http://api.douban.com/v2/book/isbn/";
		private static final String URL_searchBookInfoByKey="http://api.douban.com/v2/book/search";
		private static final String URL_searchBookInfoByTag="http://api.douban.com/v2/book/search?tag=";
		private static final String URL_getBookTagsById="http://api.douban.com/v2/book/user_tags/";
		private static final String URL_getBookNotesById="http://api.douban.com/v2/book/*/annotations";
	
	
	
	private HttpRequester httpRequester;
	public BookDAOImpl() {
		httpRequester = HttpRequester.getInstance();
	}
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<BookInfo> searckBook(String criteria) {
		List<BookInfo> result=new ArrayList<BookInfo>();
		httpRequester.setCallParam("q", criteria);
		httpRequester.setUrl(URL_searchBookInfoByKey);
		String resultString =httpRequester.executing();
		JSONObject json=JSONObject.fromString(resultString);
		JSONArray jsonArray=json.getJSONArray("books");
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonBook=(JSONObject)jsonArray.get(i);
			BookInfo book=new BookInfo();
			book.setId(jsonBook.getString("id"));
			book.setIsbn10(jsonBook.getString("isbn10"));
			book.setIsbn13(jsonBook.getString("isbn13"));
			book.setTitle(jsonBook.getString("title"));
			book.setOrigin_title(jsonBook.getString("origin_title"));
			book.setAlt_title(jsonBook.getString("alt_title"));
			book.setSubtitle(jsonBook.getString("subtitle"));
			book.setAlt(jsonBook.getString("alt"));
			book.setImage(jsonBook.getString("image"));
			JSONArray author=jsonBook.getJSONArray("author");
			List<String> authorList=JSONArray.toList(author);
			JSONArray translator=jsonBook.getJSONArray("translator");
			List<String> translatorList=JSONArray.toList(translator);
			book.setAuthor(authorList);
			book.setTranslator(translatorList);
			book.setPublisher(jsonBook.getString("publisher"));
			book.setPubdate(jsonBook.getString("pubdate"));
			book.setBinding(jsonBook.getString("binding"));
			book.setPrice((jsonBook.getString("price")));
			book.setPages((jsonBook.getString("pages")));
			book.setAuthor_intro((jsonBook.getString("author_intro")));
			book.setSummary((jsonBook.getString("summary")));
			result.add(book);
		}
		return result;
	}

	public JSONObject getBookDetail(String sql){
		return null;
	}
}
