import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.cdut.db_book.dao.HttpRequester;
import com.cdut.db_book.entity.BookInfo;


public class Test {
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args){
		HttpRequester httpRequester=new HttpRequester();
		httpRequester.setCallParam("q", "java");
		httpRequester.setUrl("http://api.douban.com/v2/book/search");
		String resultString =httpRequester.executing();
		System.out.println(resultString);
		
		
		List<BookInfo> result=new ArrayList<BookInfo>();
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
	}
}	
