package com.cdut.db_book.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cdut.db_book.entity.BookInfo;

public class SearchResult extends JFrame {
	private static final long serialVersionUID = 1L;
	private ClientContext clientContext;
	private JLabel resultCount;
	private List<BookInfo> bookInfoList;
	private List<JButton> resultButtons;
	private JPanel resultLsit;
	private int pageSize;
	private int currPage;
	private JLabel currPageJLabel;
	private JPanel contentPane;
	private int bookNum;
	public SearchResult(List<BookInfo> bookInfo) {
		pageSize = 10;
		currPage = 1;
		setTitle("result.........");
		setSize(405, 385);
		setResizable(false);
		setLocationRelativeTo(null);
		bookInfoList = bookInfo;
		getContentPane().add(createContentPane());
//		addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent arg0) {
//				clientContext.exitWindow(clientContext.getSearchResult(),
//						clientContext.getSearchWindow());
//			}
//		});
	}

	public ClientContext getClientContext() {
		return clientContext;
	}

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	public List<BookInfo> getBookInfoList() {
		return bookInfoList;
	}

	public void setBookInfoList(List<BookInfo> bookInfoList) {
		this.bookInfoList = bookInfoList;
	}

	public List<JButton> getResultButtons() {
		return resultButtons;
	}

	public void setResultButtons(List<JButton> resultButtons) {
		this.resultButtons = resultButtons;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public void setResultCount(JLabel resultCount) {
		this.resultCount = resultCount;
	}

	public void setResultLsit(JPanel resultLsit) {
		this.resultLsit = resultLsit;
	}

	public JLabel setResultCount() {
		return resultCount = new JLabel("Find" + bookInfoList.size() + " "
				+ "result!");
	}

	public JLabel getResultCount() {
		return resultCount;
	}

	public List<JButton> getResultButtons(int currPage) {
		resultButtons = new ArrayList<JButton>();
		int start = (currPage - 1) * pageSize;
		int end = currPage * pageSize;
		
		for (int i = start; i < end; i++) {
			JButton b = new JButton(bookInfoList.get(i).getTitle());
			bookNum=i;
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					showDetail(bookInfoList.get(bookNum));
				}
			});
			resultButtons.add(b);
		}
		return resultButtons;
	}

	public JPanel getResultLsit() {
		resultLsit = new JPanel();
		resultLsit.removeAll();
		GridLayout thisLayout = new GridLayout(10, 1);
		thisLayout.setColumns(1);
		thisLayout.setHgap(5);
		thisLayout.setVgap(5);
		thisLayout.setRows(pageSize);
		resultLsit.setLayout(thisLayout);
		List<JButton> Buttons = getResultButtons(currPage);
		for (int i = 0; i < Buttons.size(); i++)
			resultLsit.add(Buttons.get(i));
		return resultLsit;
	}

	public JPanel createContentPane() {
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));// 四个参数对应上 左 下 右
		setResultCount();
		contentPane.add(BorderLayout.NORTH, getResultCount());
		contentPane.add(BorderLayout.CENTER, getResultLsit());
		contentPane.add(BorderLayout.SOUTH, creatBottomPane());
		return contentPane;
	}

	public JPanel creatBottomPane() {
		JPanel p = new JPanel(new BorderLayout());
		JButton last = new JButton("Last");
		JButton next = new JButton("Next");
		String a = Integer.toString(currPage);
		currPageJLabel = new JLabel(a, JLabel.CENTER);
		p.setBorder(new EmptyBorder(10, 10, 10, 10));// 四个参数对应上 左 下 右
		p.add(BorderLayout.WEST, last);
		p.add(BorderLayout.CENTER, currPageJLabel);
		p.add(BorderLayout.EAST, next);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int currPage = getCurrPage() + 1;
				int pageCount = 0;
				if (bookInfoList.size() % pageSize > 0)
					pageCount = bookInfoList.size() / pageSize + 1;
				else
					pageCount = bookInfoList.size() / pageSize;
				if (currPage > pageCount)
					currPage--;
				setCurrPage(currPage);
				currPageJLabel.setText(Integer.toString(currPage));
				for (int i = 0; i < pageSize; i++)
					getResultButtons().get(i).setText(
							bookInfoList.get((currPage - 1) * pageSize + i)
									.getTitle());
			}

		});
		last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int currPage = getCurrPage() - 1;
				if (currPage < 1)
					currPage++;
				setCurrPage(currPage);
				currPageJLabel.setText(Integer.toString(currPage));
				for (int i = 0; i < pageSize; i++)
					getResultButtons().get(i).setText(
							bookInfoList.get((currPage - 1) * pageSize + i)
									.getTitle());
			}
		});
		return p;
	}
	
	public void showDetail(BookInfo book){
		BookDetail bookDetail=new BookDetail(book);
		bookDetail.setVisible(true);
	}
}
