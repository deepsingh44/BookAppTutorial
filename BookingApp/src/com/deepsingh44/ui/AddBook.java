package com.deepsingh44.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import com.deepsingh44.model.Book;
import com.deepsingh44.service.BookService;
import com.deepsingh44.utility.Util;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class AddBook extends JInternalFrame {
	private JTextField btitle;
	private JTextField bauthor;
	private JTextField bprice;
	private JTextField bimage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Add Book");
		setBounds(100, 30, 588, 367);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 102));
		panel.setBounds(10, 11, 552, 315);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel blabelimage = new JLabel("");
		blabelimage.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		blabelimage.setBounds(206, 11, 127, 93);
		panel.add(blabelimage);

		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setForeground(Color.WHITE);
		lblBookTitle.setFont(new Font("Serif", Font.BOLD, 12));
		lblBookTitle.setBounds(42, 136, 103, 14);
		panel.add(lblBookTitle);

		btitle = new JTextField();
		btitle.setColumns(10);
		btitle.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btitle.setBounds(42, 152, 196, 30);
		panel.add(btitle);

		JLabel lblBookAuthor = new JLabel("Book Author");
		lblBookAuthor.setForeground(Color.WHITE);
		lblBookAuthor.setFont(new Font("Serif", Font.BOLD, 12));
		lblBookAuthor.setBounds(287, 136, 103, 14);
		panel.add(lblBookAuthor);

		bauthor = new JTextField();
		bauthor.setColumns(10);
		bauthor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bauthor.setBounds(287, 152, 225, 30);
		panel.add(bauthor);

		JLabel lblBookPrice = new JLabel("Book Price");
		lblBookPrice.setForeground(Color.WHITE);
		lblBookPrice.setFont(new Font("Serif", Font.BOLD, 12));
		lblBookPrice.setBounds(42, 193, 103, 14);
		panel.add(lblBookPrice);

		bprice = new JTextField();
		bprice.setColumns(10);
		bprice.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bprice.setBounds(42, 209, 196, 30);
		panel.add(bprice);

		JButton btnAddBook = new JButton("Add Book");

		btnAddBook.setBounds(185, 268, 178, 36);
		panel.add(btnAddBook);

		JButton button = new JButton("...");

		button.setForeground(Color.WHITE);
		button.setFont(new Font("Serif", Font.BOLD, 12));
		button.setBackground(new Color(0, 51, 51));
		button.setBounds(483, 208, 33, 30);
		panel.add(button);

		bimage = new JTextField();
		bimage.setEnabled(false);
		bimage.setColumns(10);
		bimage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bimage.setBounds(287, 207, 186, 30);
		panel.add(bimage);

		JLabel lblBookImage = new JLabel("Book Image");
		lblBookImage.setForeground(Color.WHITE);
		lblBookImage.setFont(new Font("Serif", Font.BOLD, 12));
		lblBookImage.setBounds(287, 193, 103, 14);
		panel.add(lblBookImage);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int i = fc.showOpenDialog(AddBook.this);
				if (i == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					blabelimage.setIcon(Util.resize(new ImageIcon(file.getAbsolutePath()), 127, 93));

					bimage.setText(file.getAbsolutePath());

					String dir = System.getProperty("user.dir");
					File folder = new File(dir, "bookimages");
					folder.mkdir();

					try {
						File imagefile = File.createTempFile("book", ".jpg", folder);
						imagename = imagefile.getName();
						FileInputStream fi = new FileInputStream(file.getAbsolutePath());
						FileOutputStream fo = new FileOutputStream(imagefile);
						int k = 0;
						while ((k = fi.read()) != -1) {
							fo.write(k);
						}
						fo.close();
						fi.close();
						System.out.println(imagefile.getAbsolutePath());
					} catch (Exception e2) {
						System.out.println(e2);
					}

				}
			}
		});

		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {

					Book book = new Book(title, author, imagename, Float.parseFloat(price));
					String msg = BookService.getBookService().insert(book);
					Util.normalMessage(AddBook.this, msg);
				}
			}
		});

	}

	private String title, author, price, image;
	private String imagename;

	private boolean valid() {
		title = btitle.getText();
		author = bauthor.getText();
		price = bprice.getText();
		image = bimage.getText();

		if (title.equals("")) {
			Util.warningMessage(this, "please enter title");
			btitle.requestFocus();
			return false;
		} else if (author.equals("")) {
			Util.warningMessage(this, "please enter author name");
			bauthor.requestFocus();
			return false;
		} else if (price.equals("")) {
			Util.warningMessage(this, "please enter price");
			bprice.requestFocus();
			return false;
		} else if (image.equals("")) {
			Util.warningMessage(this, "please select book image");
			bimage.requestFocus();
			return false;
		} else {
			return true;
		}
	}
}
