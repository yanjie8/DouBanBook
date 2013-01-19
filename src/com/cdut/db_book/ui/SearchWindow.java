package com.cdut.db_book.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class SearchWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	public ClientContext clientContext;
	private JLabel message;
	private JTextField nameField;
	private JTextField authorField;
	private JTextField ISBMField;

	public SearchWindow(){
		setTitle("Search Book for DouBan");
		setSize(300, 220);
		setResizable(false);
		setLocationRelativeTo(null);
		
		getContentPane().add(createContentPane());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
					System.exit(0);
			}
		});
	}
	
	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}
	
	public String getName(){
		return nameField.getText();
	}
	public String getAuthor(){
		return authorField.getText();
	}
	public String getISBM(){
		return ISBMField.getText();
	}
	private JPanel createContentPane() {
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(10,10,10,10));//四个参数对应上 左 下 右
		p.setPreferredSize(new java.awt.Dimension(282, 179));
		p.add(BorderLayout.NORTH,new JLabel("Enter search....",JLabel.CENTER));
		p.add(BorderLayout.CENTER,creatCenterPane());
		p.add(BorderLayout.SOUTH,creatBottomPane());
		return p;
	}
	
	private JPanel creatCenterPane() {
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(8,8,8,8));
		p.add(BorderLayout.NORTH,createInputPane());
		message = new JLabel();
		p.add(BorderLayout.CENTER,message);
		return p;
	}
	private JPanel createInputPane() {
		JPanel p = new JPanel(new BorderLayout());
		p.add(BorderLayout.NORTH,createNamePane());
		p.add(BorderLayout.CENTER,createAuthorPane());
		p.add(BorderLayout.SOUTH,createISBMPane());
		return p;
	}
	

	private JPanel createNamePane() {
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(1,1,3,1));
		p.add(BorderLayout.WEST,new JLabel("Title："));
		nameField = new JTextField();
		p.add(BorderLayout.CENTER,nameField);
		return p;
	}

	private JPanel createAuthorPane() {
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(3,1,1,1));
		p.add(BorderLayout.WEST,new JLabel("Author："));
		authorField = new JTextField();
		p.add(BorderLayout.CENTER,authorField);
		return p;
	}

	private JPanel createISBMPane() {
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(3,1,1,1));
		p.add(BorderLayout.WEST,new JLabel("ISBM："));
		ISBMField = new JTextField();
		p.add(BorderLayout.CENTER,ISBMField);
		return p;
	}
	

	

	public void setMessage(String msg){
		Color col = Color.red;
		message.setForeground(col);
		message.setText(msg);
		message.setHorizontalAlignment(JLabel.CENTER);
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				Color color = message.getForeground();
				int a = color.getAlpha();
				a = a == 0 ? 0 : (int)(a*80/100);
				Color c = new Color(color.getRed(),color.getGreen(),color.getBlue(),a);
				message.setForeground(c);
			}
		},3000,200);
		timer.schedule(new TimerTask() {
			public void run() {
				message.setText("");
				timer.cancel();
			}
		}, 4000);
	}
	
	private JPanel creatBottomPane() {
		JPanel p = new JPanel(new FlowLayout());
		JButton submit = new JButton("Search");
		JButton reset = new JButton("reset");
		JButton cancel = new JButton("cancel");
		p.add(submit);
		p.add(reset);
		p.add(cancel);
		getRootPane().setDefaultButton(submit);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String search="";
				search=nameField.getText()+" "+
				authorField.getText()+" "+
				ISBMField.getText();
				System.out.println(search);
				clientContext.search(search);	
			}
		});
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					nameField.setText("");
					authorField.setText("");
					ISBMField.setText("");
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int val = JOptionPane.showConfirmDialog(SearchWindow.this, "Exit？","Exit",JOptionPane.YES_NO_OPTION);
				if (val == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		return p;
	}
}