package com.deepsingh44.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.deepsingh44.model.User;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	private User user;

	public HomePage(User user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 472);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmAddNewBook = new JMenuItem("Add Book");

		mntmAddNewBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmAddNewBook);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		JMenuItem mntmViewProfile = new JMenuItem("View Profile");

		mnView.add(mntmViewProfile);

		JMenuItem mntmBookList = new JMenuItem("Book List");

		mntmBookList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnView.add(mntmBookList);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnView.add(mntmLogout);

		JMenu menu = new JMenu("");
		menuBar.add(menu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		mntmAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook addBook = new AddBook();
				desktopPane.add(addBook);
				addBook.setVisible(true);
			}
		});

		mntmBookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookList bookList = new BookList();
				desktopPane.add(bookList);
				bookList.setVisible(true);
			}
		});

		mntmViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfilePage profilePage = new ProfilePage(user);
				desktopPane.add(profilePage);
				profilePage.setVisible(true);
			}
		});

	}
}
