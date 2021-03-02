package com.deepsingh44.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.deepsingh44.model.Book;
import com.deepsingh44.service.BookService;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class BookList extends JInternalFrame {
	private JTable table;
	private List<Book> books;
	private JTextField updatetitle;
	private JTextField updateprice;
	private JTextField updateauthor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookList frame = new BookList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookList() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Book List");
		setBounds(100, 30, 588, 367);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 102));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		String[] cols = { "ID", "TITLE", "PRICE", "AUTHOR" };
		DefaultTableModel dt = new DefaultTableModel(cols, 0);

		table = new JTable(dt);

		// table.getTableHeader().setBackground(Color.green);
		// table.getTableHeader().setForeground(Color.WHITE);
		// table.getTableHeader().setFont(new Font("",Font.BOLD,20));
		// table.setForeground(new Color(255, 255, 255));
		// table.setBackground(new Color(153, 0, 0));

		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(228, 82, 334, 233);
		panel.add(jp);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Serif", Font.BOLD, 12));
		lblTitle.setBounds(26, 67, 103, 14);
		panel.add(lblTitle);
		
		updatetitle = new JTextField();
		updatetitle.setColumns(10);
		updatetitle.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		updatetitle.setBounds(26, 83, 167, 30);
		panel.add(updatetitle);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Serif", Font.BOLD, 12));
		lblPrice.setBounds(26, 122, 103, 14);
		panel.add(lblPrice);
		
		updateprice = new JTextField();
		updateprice.setColumns(10);
		updateprice.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		updateprice.setBounds(26, 138, 167, 30);
		panel.add(updateprice);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setFont(new Font("Serif", Font.BOLD, 12));
		lblAuthor.setBounds(26, 179, 103, 14);
		panel.add(lblAuthor);
		
		updateauthor = new JTextField();
		updateauthor.setColumns(10);
		updateauthor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		updateauthor.setBounds(26, 195, 167, 30);
		panel.add(updateauthor);
		
		JButton btnUpdateHere = new JButton("Update Here");
		btnUpdateHere.setForeground(Color.WHITE);
		btnUpdateHere.setFont(new Font("Serif", Font.BOLD, 12));
		btnUpdateHere.setBackground(new Color(0, 102, 153));
		btnUpdateHere.setBounds(41, 252, 137, 30);
		panel.add(btnUpdateHere);

		books = BookService.getBookService().getAllBooks();
		Iterator<Book> it = books.iterator();
		DefaultTableModel dt1 = (DefaultTableModel) table.getModel();
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		
		while (it.hasNext()) {
			Book book = it.next();
			dt1.addRow(new Object[] { book.getId(), book.getTitle(), book.getPrice(), book.getAuthor() });
		}

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPopupMenu pm=new JPopupMenu();
				JMenuItem m1=new JMenuItem("Update Book");
				JMenuItem m2=new JMenuItem("Delete Book");
				JMenuItem m3=new JMenuItem("Purchase Book");
				pm.add(m1);
				pm.add(m2);
				pm.add(m3);
				
				pm.show(table, e.getX(), e.getY());
				
				
				m1.addActionListener((x)->updateBook(table.getSelectedRow()));
				
				m2.addActionListener((x)->deleteBook(table.getSelectedRow()));
			}
		});
	}
	
	private void updateBook(int selectedrow) {
		DefaultTableModel dt1 = (DefaultTableModel) table.getModel();
		int id=(Integer)dt1.getValueAt(selectedrow, 0);
		updatetitle.setText(dt1.getValueAt(selectedrow, 1).toString());
		updateprice.setText(dt1.getValueAt(selectedrow, 2).toString());
		updateauthor.setText(dt1.getValueAt(selectedrow, 3).toString());
	}
	
	private void deleteBook(int selectedrow) {
		DefaultTableModel dt1 = (DefaultTableModel) table.getModel();
		int id=(Integer)dt1.getValueAt(selectedrow, 0);
		BookService.getBookService().deleteBookById(id);
		dt1.removeRow(selectedrow);
	}
}
