package com.cdut.db_book.ui;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.cdut.db_book.entity.BookInfo;
import com.cdut.db_book.service.BookService;

public class ClientContext {
	private SearchWindow searchWindow;
	private SearchResult searchResult;
	private BookMain bookMain;
	private BookDetail bookDetail;
	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public SearchWindow getSearchWindow() {
		return searchWindow;
	}

	public void setSearchWindow(SearchWindow searchWindow) {
		this.searchWindow = searchWindow;
	}

	public SearchResult getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(SearchResult searchResult) {
		this.searchResult = searchResult;
	}

	public BookMain getBookMain() {
		return bookMain;
	}

	public void setBookMain(BookMain bookMain) {
		this.bookMain = bookMain;
	}

	public BookDetail getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

	public void show() {
		searchWindow.setVisible(true);
	}

	public void exit(JFrame frame, String msg1, String msg2) {
		int val = JOptionPane.showConfirmDialog(frame, msg1, msg2,
				JOptionPane.YES_NO_OPTION);
		if (val == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void exitWindow(JFrame frame, String msg1, String msg2) {
		int val = JOptionPane.showConfirmDialog(frame, msg1, msg2,
				JOptionPane.YES_NO_OPTION);
		if (val == JOptionPane.YES_OPTION) {
			frame.setVisible(false);
		}
	}
	
	public void exitWindow(JFrame frame) {
			frame.setVisible(false);
	}

	public void search(String search) {
		if (search.equals("  "))
			searchWindow.setMessage("Please  enter search conditon");
		else {
			// List<BookInfo> BookInfo = bookService.searchBook(search);
			List<BookInfo> BookInfo = bookService.searchBook(search);
			searchResult =new SearchResult(BookInfo);
			searchResult.setClientContext(this);
			searchResult.setVisible(true);
			searchResult.setCurrPage(1);
		}
	}
}
