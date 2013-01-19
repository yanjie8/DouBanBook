package com.cdut.db_book.client;

import com.cdut.db_book.service.BookService;
import com.cdut.db_book.service.BookServiceImpl;
import com.cdut.db_book.ui.BookDetail;
import com.cdut.db_book.ui.BookMain;
import com.cdut.db_book.ui.ClientContext;
import com.cdut.db_book.ui.SearchWindow;

public class Main {

	public static void main(String[] args) {
		SearchWindow searchWindow=new SearchWindow();
		BookMain bookMain=new BookMain();
		ClientContext clientContext = new ClientContext();
		BookService bookService=new BookServiceImpl();
		
		
		clientContext.setSearchWindow(searchWindow);
		clientContext.setBookMain(bookMain);
		clientContext.setBookService(bookService);
		
		
		searchWindow.setClientContext(clientContext);
		clientContext.show();
	}

}
