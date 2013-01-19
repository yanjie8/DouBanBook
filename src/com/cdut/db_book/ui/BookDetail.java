package com.cdut.db_book.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.cdut.db_book.entity.BookInfo;

public class BookDetail extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel context;
	private JTextArea detai;

	public BookDetail(BookInfo book) {
		setTitle("Book detail..........");
		{
			context = new JPanel();
			getContentPane().add(context, BorderLayout.CENTER);
			{
				detai = new JTextArea();
				context.add(detai);
				detai.setText("detail");
				detai.setPreferredSize(new java.awt.Dimension(382, 345));
				setDetail(book);
			}
		}
		setSize(405, 385);
		// getContentPane().add(createContentPane());
		// addWindowListener(new WindowAdapter() {
		// public void windowClosing(WindowEvent arg0) {
		// clientContext.exitWindow(clientContext.getSearchResult(),
		// clientContext.getSearchWindow());
		// }
		// });
	}

	public void setDetail(BookInfo book){
		 String id="ID: "+book.getId();
		 String isbn10="ISBM: "+book.getIsbn10();
//		 String isbn13="ISBM13: "+book.getIsbn13();
//		 String publisher="PUBLISHER: "+book.getPublisher();
//		 String pubdate="PUBDATE: "+book.getPubdate();
//		 String origin_title="ORIGIN_TITLE: "+book.getOrigin_title();
//		 String subtitle="SUBTITLE: "+book.getSubtitle();
		 String title="TITLE: "+book.getTitle();
		 String alt_title="ALT_TITLE: "+book.getAlt_title();
		 String alt="ALT: "+book.getAlt();
		 String author="AUTHOR: ";
		 for(int i=0;i<book.getAuthor().size();i++)
			 author+=book.getAuthor().get(i)+"     ";
		 String translator="TRANSLATOR: ";
		 for(int i=0;i<book.getTranslator().size();i++)
			 translator+=book.getTranslator().get(i)+"     ";
		 
		 String binding="BINDING: "+book.getBinding();
		 String price="PRICE: "+book.getPrice();
		 String pages="PAGES: "+book.getPages();
		 String author_intro="AUTHOR_INTRO: "+book.getAuthor_intro();
		 String summary="SUMMARY: "+book.getSummary();
		 String text=title+"\n"+alt_title+"\n"+alt+"\n"+author+"\n"+id+"\n"+isbn10+"\n"
		 +translator+"\n"+binding+"\n"+price+"\n"+pages+"\n"+author_intro+"\n"+summary;
		detai.setText(text);
	}
}
